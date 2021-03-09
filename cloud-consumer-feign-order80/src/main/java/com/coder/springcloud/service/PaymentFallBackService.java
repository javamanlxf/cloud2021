package com.coder.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: cloud2021
 * @classname: PaymentFallBackService
 * @description:
 * @author: 李小飞
 * @create: 2021-03-08 23:07
 **/
@Component
public class PaymentFallBackService implements IPaymentFeignHystrixService {
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "timeout";
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "runtime e";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "paymentCircuitBreaker 兜底";
    }
}
