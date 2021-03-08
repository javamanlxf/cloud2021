package com.coder.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud2021
 * @classname: FeignConfig
 * @description: 配置feign 日志级别
 * @author: 李小飞
 * @create: 2021-03-08 15:43
 **/
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
