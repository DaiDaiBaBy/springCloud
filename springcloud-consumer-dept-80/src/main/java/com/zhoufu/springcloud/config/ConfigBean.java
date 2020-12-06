package com.zhoufu.springcloud.config;

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
    @Bean
    public RestTemplate getResTemplate(){
        return new RestTemplate();
    }
}
