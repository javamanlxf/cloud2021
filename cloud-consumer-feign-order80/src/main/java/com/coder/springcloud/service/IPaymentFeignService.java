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
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface IPaymentFeignService {

    @GetMapping("/payment/getPaymentById/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);
}
