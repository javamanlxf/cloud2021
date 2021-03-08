package com.coder.springcloud.controller;

import com.coder.springcloud.entities.CommonResult;
import com.coder.springcloud.service.IPaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2021
 * @classname: OrderFeignController
 * @description:
 * @author: 李小飞
 * @create: 2021-03-08 15:14
 **/
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private IPaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
