package com.coder.springcloud.controller;

import com.coder.springcloud.entities.CommonResult;
import com.coder.springcloud.entities.Payment;
import com.coder.springcloud.service.impl.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: cloud2021
 * @classname: PaymentController
 * @description: 支付controller
 * @author: 李小飞
 * @create: 2021-03-06 17:36
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功,好耶", result);
        } else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("插入结果" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功", payment);
        } else {
            return new CommonResult<>(444, "没有对应的记录：" + id, null);
        }
    }

}