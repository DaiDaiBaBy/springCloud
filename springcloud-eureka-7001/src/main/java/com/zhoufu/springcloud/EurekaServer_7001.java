package com.zhoufu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: zhoufu
 * @Date: 2020/12/13 23:31
 * @description: EnableEurekaServer 服务端的启动类， 可以接受别人注册进来~
 * 启动之后， 访问  http://localhost:7001/
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class, args);
    }
}
