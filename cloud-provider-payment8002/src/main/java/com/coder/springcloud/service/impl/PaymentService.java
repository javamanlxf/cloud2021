package com.coder.springcloud.service.impl;

import com.coder.springcloud.dao.PaymentDao;
import com.coder.springcloud.entities.Payment;
import com.coder.springcloud.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: cloud2021
 * @classname: PaymentService
 * @description: 支付 服务类
 * @author: 李小飞
 * @create: 2021-03-06 17:33
 **/
@Service
public class PaymentService implements PaymentServiceImpl {

    @Autowired
    PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
