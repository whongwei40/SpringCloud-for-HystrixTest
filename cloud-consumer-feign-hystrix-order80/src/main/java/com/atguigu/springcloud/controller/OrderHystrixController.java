package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dongjunzi
 * @DATE 2022/4/7 10:00
 */
@RestController
@RequestMapping("/consumer")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;




    @GetMapping("/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id) {
        return paymentHystrixService.paymentInto_OK(id);
    }


    @GetMapping("payment/timeout")
    public String paymentInfo_Timeout() {
        return paymentHystrixService.paymentInfo_Timeout();
    }


}
