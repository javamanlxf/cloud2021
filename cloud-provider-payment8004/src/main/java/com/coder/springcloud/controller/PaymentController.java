package com.coder.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: cloud2021
 * @classname: PaymentController
 * @description: 支付controller
 * @author: 李小飞
 * @create: 2021-03-07 18:39
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk() {
        return "springcloud with zookeeper：" + serverPort + "\t流水号：" + UUID.randomUUID().toString();
    }
}
