package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dongjunzi
 * @DATE 2022/4/6 13:56
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentMapper paymentMapper;

    @Override
    public int add(Payment payment) {

        int i = paymentMapper.add(payment);

        return i;
    }

    @Override
    public Payment getPaymentById(@Param("id") Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
