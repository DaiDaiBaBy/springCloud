package com.zhoufu.service;

import com.zhoufu.springcloud.pojo.Dept;

import java.util.List;

/**
 * @Author: zhoufu
 * @Date: 2020/12/5 15:54
 * @description: com.zhoufu.service
 */
public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
