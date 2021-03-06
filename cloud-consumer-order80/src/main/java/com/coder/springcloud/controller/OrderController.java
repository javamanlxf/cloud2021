package com.coder.springcloud.controller;

import com.coder.springcloud.entities.CommonResult;
import com.coder.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud2021
 * @classname: OrderController
 * @description: 订单 controller
 * @author: 李小飞
 * @create: 2021-03-06 19:53
 **/
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001/";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("订单系统，添加订单：" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("订单系统，获取订单: " + id);
        return restTemplate.getForObject(PAYMENT_URL + "payment/getPaymentById/" + id, CommonResult.class);
    }
}
