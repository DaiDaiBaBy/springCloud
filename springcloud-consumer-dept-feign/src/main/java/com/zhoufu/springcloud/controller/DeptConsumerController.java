package com.zhoufu.springcloud.controller;

import com.zhoufu.springcloud.pojo.Dept;
import com.zhoufu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: zhoufu
 * @Date: 2020/12/5 23:02
 * @description: com.zhoufu.springcloud.controller
 */
@RestController
public class DeptConsumerController {
    /**
     * Restful调用模式    RestTemplate....有模板提供  直接调用 注册到spring中
     * RestTemplate  提供多种便捷访问远程http服务的方法，简单的Restful服务模板
     */
    @Autowired
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX="http://localhost:8001";
//    /**
//      *Ribbon  我们这里的地址，应该是一个变量，并且通过微服务名来访问  配置了负载均衡后 每个节点都有此服务名  则会根据算法（轮询、随机等）访问
//      */
//    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

//    使用Feign后
    @Autowired
    private DeptClientService service =  null;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        // （url，实体：Map， Class<T> responseType）
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/"+  id, Dept.class);  robbin调用方式
        return this.service.queryById(id);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
//        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept,Boolean.class);
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
        return this.service.queryAll();
    }
}
