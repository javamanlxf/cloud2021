package com.coder.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2021
 * @classname: PaymentService
 * @description:
 * @author: 李小飞
 * @create: 2021-03-08 16:17
 **/
@Service
@Slf4j
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        int a = 1/0;
        return "线程池：[" + Thread.currentThread().getName() + "]\t" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：[" + Thread.currentThread().getName() + "]\t" + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "这是一个兜底的方法，进行服务降级: " + "线程池：[" + Thread.currentThread().getName() + "]\t" + id;
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否打开断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        log.info("进入 payment service， id={}", id);
        if (id < 0) {
            throw new RuntimeException("id不能为负数，id = " + id);
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用方法成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能为负数，请稍后再试，id=" + id;
    }
}
