package com.coder.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud2021
 * @classname: ApplicationContextConfig
 * @description: 配置类
 * @author: 李小飞
 * @create: 2021-03-06 19:56
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced // 负载均衡 注掉，采用自定义的负载均衡方法
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
