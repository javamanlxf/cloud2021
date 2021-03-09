package com.coder.springcloud.controller;

import com.coder.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2021
 * @classname: PaymentController
 * @description:
 * @author: 李小飞
 * @create: 2021-03-08 16:22
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "payment/htstrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("payment-hystrix: " + result);
        return result;
    }

    @GetMapping(value = "payment/htstrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("payment-hystrix: " + result);
        return result;
    }

    @GetMapping(value = "payment/htstrix/circuitbreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        log.info("进入payment， id={}", id);
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("payment-paymentCircuitBreaker: " + result);
        return result;
    }

}
