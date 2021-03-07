package com.coder.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: cloud2021
 * @classname: PaymentMain001
 * @description: payment service 001
 * @author: 李小飞
 * @create: 2021-03-06 11:07
 **/
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
