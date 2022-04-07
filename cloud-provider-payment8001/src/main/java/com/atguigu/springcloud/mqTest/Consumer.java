/*
package com.atguigu.springcloud.mqTest;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

*/
/**
 * @author dongjunzi
 * @DATE 2022/4/6 11:08
 *//*

public class Consumer {

    public static void main(String[] args) throws InterruptedException, MQClientException {

        // 使用指定的消费者组名称进行实例化.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");

        // Specify name server addresses.
        consumer.setNamesrvAddr("localhost:9876");

        // 再订阅一个主题来消费。
        consumer.subscribe("TopicTest", "*");
        // 注册回调以在从代理获取的消息到达时执行。
        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //启动消费者实例。
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}*/
