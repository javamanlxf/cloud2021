package com.coder.springcloud.service;

import com.coder.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud2021
 * @classname: PaymentFeignService
 * @description:
 * @author: 李小飞
 * @create: 2021-03-08 15:08
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX", fallback = PaymentFallBackService.class)
public interface IPaymentFeignHystrixService {

    @GetMapping(value = "payment/htstrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

    @GetMapping(value = "payment/htstrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "payment/htstrix/circuitbreaker/{id}")
    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
