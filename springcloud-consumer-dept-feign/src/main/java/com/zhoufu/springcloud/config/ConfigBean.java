package com.zhoufu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zhoufu
 * @Date: 2020/12/5 23:04
 * @description: com.zhoufu.springcloud.config
 */

/**
 * Configuration 等同于spring中的  ApplicationContext.xml   ( <bean></bean>)
 */
@Configuration
public class ConfigBean {
    /**
     * 配置负载均衡实现 restTemplate  只需加上注解 @LoadBalanced即可
     * LoadBalanced  ====》 Ribbon
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }

}
