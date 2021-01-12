package com.zhoufu.springcloud.service;

import com.zhoufu.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author: zhoufu
 * @Date: 2020/12/23 22:57
 * @description:
 */
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
@Component
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);

    @PostMapping("/dept/list")
    public List<Dept> queryAll();

    @PostMapping("/dept/add")
    public Boolean addDept(Dept dept);
}
