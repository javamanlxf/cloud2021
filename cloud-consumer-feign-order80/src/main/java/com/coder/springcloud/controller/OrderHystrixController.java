package com.coder.springcloud.controller;

import com.coder.springcloud.service.IPaymentFeignHystrixService;
import com.coder.springcloud.service.IPaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2021
 * @classname: OrderHystrixController
 * @description:
 * @author: 李小飞
 * @create: 2021-03-08 22:39
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_fallBack")
public class OrderHystrixController {

    @Autowired
    private IPaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentFeignHystrixService.paymentInfo_TimeOut(id);
    }


    @GetMapping("consumer/payment/hystrix/timeout2/{id}")
    @HystrixCommand
    public String paymentInfo_TimeOutGlobal(@PathVariable("id") Integer id) {
        return paymentFeignHystrixService.paymentInfo_TimeOut(id);
    }

    @GetMapping("consumer/payment/hystrix/timeout3/{id}")
    public String paymentInfo_TimeOut_Feign(@PathVariable("id") Integer id) {
        return paymentFeignHystrixService.paymentInfo_OK(id);
    }


    public String paymentInfo_TimeOutHandler(Integer id) {
        return "服务端，进行服务降级，降级你懂不？菜逼";
    }

    public String global_fallBack() {
        return "Global fall back, 全局服务降级";
    }


    @GetMapping(value = "consumer/payment/hystrix/circuitbreaker/{id}")
    String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        log.info("进入order，id={}", id);
        return paymentFeignHystrixService.paymentCircuitBreaker(id);
    }
}
