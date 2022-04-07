package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.lmpl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dongjunzi
 * @DATE 2022/4/7 9:56
 */
@Component
@FeignClient(value = "cloud-payment-service",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/ok/{id}")
    public String paymentInto_OK(@PathVariable("id") int id);

    @GetMapping("/payment/timeout")
    public String paymentInfo_Timeout( );

}

