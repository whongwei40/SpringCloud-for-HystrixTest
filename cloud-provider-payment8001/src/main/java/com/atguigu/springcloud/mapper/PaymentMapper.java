package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author dongjunzi
 * @DATE 2022/4/6 14:00
 */
@Mapper
public interface PaymentMapper {

    //新增
    int add(Payment payment);

    //查询
    Payment getPaymentById(@Param("id") Long id);

}
