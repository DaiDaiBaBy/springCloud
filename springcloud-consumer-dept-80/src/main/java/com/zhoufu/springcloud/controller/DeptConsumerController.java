package com.zhoufu.springcloud.controller;

import com.zhoufu.springcloud.pojo.Dept;
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

    private static final String REST_URL_PREFIX="http://localhost:8001";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        // （url，实体：Map， Class<T> responseType）
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/"+  id, Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}
