package com.atguigu.springcloud.service.lmpl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author dongjunzi
 * @DATE 2022/4/7 10:37
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInto_OK(int id) {
        return "服务降级-----系统响应的时间过久，已切换到我来执行"+id;
    }

    @Override
    public String paymentInfo_Timeout() {
        return "我是80的服务降级，系统响应的时间过久，已切换到我来执行 ";

    }
}

