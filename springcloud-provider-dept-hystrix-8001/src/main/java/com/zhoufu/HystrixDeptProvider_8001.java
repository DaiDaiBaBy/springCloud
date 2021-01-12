package com.zhoufu;

import com.netflix.hystrix.Hystrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: zhoufu
 * @Date: 2020/12/5 16:06
 * @description: 配置 EnableEurekaClient   项目启动后，  会自动注册到Eureka中
 *  服务发现注解  EnableDiscoveryClient
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker // 添加对 熔断的支持
public class HystrixDeptProvider_8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDeptProvider_8001.class, args);
    }
}
