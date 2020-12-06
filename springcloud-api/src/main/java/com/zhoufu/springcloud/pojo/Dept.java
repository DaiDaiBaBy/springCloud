package com.zhoufu.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: zhoufu
 * @Date: 2020/12/5 15:00
 * @description: com.zhoufu.springcloud.pojo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //链式写法开启
public class Dept {
    /**
     * 主键
     */

    private Long deptno;

    private String dname;
    /**
     * 代表数据存在哪个数据库的字段
     */
    private String db_source;

    public Dept(String dname){
        this.dname = dname;
    }
    /**
     * 链式写法：
     * Dept dept = new Dept();
     * dept.setDeptNo(1).setDname("sss").setDbSource("db01")
     */
}
