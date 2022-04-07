package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author dongjunzi
 * @DATE 2022/4/6 13:55
 */
public interface PaymentService {

    int add(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
