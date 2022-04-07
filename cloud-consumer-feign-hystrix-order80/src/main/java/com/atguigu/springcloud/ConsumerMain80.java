package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dongjunzi
 * @DATE 2022/4/7 9:55
 */
@EnableFeignClients            //开启feign
@EnableDiscoveryClient        //开启服务发现
@EnableHystrix                //开启hystrix 继承了@EnableCircuitBreaker
@SpringBootApplication
public class ConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain80.class, args);
    }
}
