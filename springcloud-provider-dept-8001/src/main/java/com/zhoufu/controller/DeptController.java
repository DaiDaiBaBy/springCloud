package com.zhoufu.controller;

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
    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id){
        return deptService.queryById(id);
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
