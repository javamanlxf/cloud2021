package com.coder.springcloud.service;

import com.coder.springcloud.entities.Payment;

/**
 * @program: cloud2021
 * @classname: PaymentService
 * @description: 支付服务类
 * @author: 李小飞
 * @create: 2021-03-06 17:32
 **/
public interface PaymentServiceImpl {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
