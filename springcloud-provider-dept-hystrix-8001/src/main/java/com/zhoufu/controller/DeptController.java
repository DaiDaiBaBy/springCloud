package com.zhoufu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhoufu.service.DeptService;
import com.zhoufu.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zhoufu
 * @Date: 2020/12/5 16:02
 * @description: com.zhoufu.controller
 */
//restful调用
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null){
            throw new RuntimeException("id=>" +id+".不存在该用户，或者信息无法找到~");
        }
        return dept;
    }

    // Hystrix 备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("id=>" + id + "没有对应的信息，null -- @Hystrix")
                .setDb_source("no this database in MySql");
    }


    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }



    /**
     * 注册进来的微服务，获取到一些信息~
     *
     * 团队开发中会使用到  向别人告诉你是谁  (服务发现)
     * @return
     */
    @GetMapping("/dept/discovery")
    public Object discovery(){
    //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services: " + services);

        //得到一个具体的微服务信息， 通过具体的微服务id (applicationName)
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getHost() + "\t" +
                    instance.getHost() + "\t" +
                    instance.getInstanceId()
            );
        }
        return client;
    }
}
