package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.entities.RequestEnum;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author dongjunzi
 * @DATE 2022/4/6 13:53
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/add")
    public CommonResult insert(Payment payment) {

        int i = paymentService.add(payment);

        if (i > 0) {
            return new CommonResult(RequestEnum.SUCCESS_CODE.getCode(), "插入成功");
        } else {
            return new CommonResult(RequestEnum.FILED_CODE.getCode(), "插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> query(@PathVariable("id") Long id) {

        Payment paymentById = paymentService.getPaymentById(id);

        if (!StringUtils.isEmpty(paymentById)) {
            return new CommonResult(RequestEnum.SUCCESS_CODE.getCode(), "查询成功", paymentById);
        } else {
            return new CommonResult(RequestEnum.FILED_CODE.getCode(), "查询对象不存在");
        }

    }


    /**
     * =====================熔断配置=======================
     * circuitBreaker.enabled: 启动熔断
     * circuitBreaker.requestVolumeThreshold：请求次数
     * circuitBreaker.errorThresholdPercentage： 失败率达到多少启动熔断
     */
    @HystrixCommand(fallbackMethod ="circuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    @GetMapping("/ok/{id}")
    public String paymentInto_OK(@PathVariable("id") int id) {

        if (id>=0){
            log.info("线程池\t" + Thread.currentThread().getName() + "\tpaymentInto_OK\t" + "\tO(∩_∩)O哈哈~");
            return "线程池\t" + Thread.currentThread().getName() + "\tpaymentInto_OK\t" + "\tO(∩_∩)O哈哈~";
        }else {
            throw new RuntimeException("id不能不能为负数"+id);
        }


    }

    @GetMapping("/timeout")
    public String paymentInto_Timeout() {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);

            log.info("线程池\t" + Thread.currentThread().getName() + "\tpaymentInto_Timeout\t" + "\t┭┮﹏┭┮,超时,超时" + time + "s");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池\t" + Thread.currentThread().getName() + "\tpaymentInto_Timeout\t" + "\t┭┮﹏┭┮,超时,超时" + time + "s";
    }

    public String circuitBreakerFallback(@PathVariable("id") int id) {
        return "服务熔断   id =" + id + ", 不能为负数，o(╥﹏╥)o~ ";
    }

}
