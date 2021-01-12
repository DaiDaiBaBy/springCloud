package com.zhoufu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: zhoufu
 * @Date: 2020/12/5 23:22
 * @description: com.zhoufu.springcloud
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.zhoufu.springcloud")
@ComponentScan("com.zhoufu.springcloud")
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class, args);
    }
}
