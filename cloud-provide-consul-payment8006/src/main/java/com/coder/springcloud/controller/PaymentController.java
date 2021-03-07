package com.coder.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: cloud2021
 * @classname: PaymentController
 * @description: controller consul
 * @author: 李小飞
 * @create: 2021-03-07 21:43
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springcloud with consul:" + serverPort + "\t序列号:" + UUID.randomUUID().toString();
    }
}
