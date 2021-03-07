package com.coder.springcloud.dao;

import com.coder.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2021
 * @classname: PaymentDao
 * @description: dao层：支付类
 * @author: 李小飞
 * @create: 2021-03-06 11:47
 **/
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
