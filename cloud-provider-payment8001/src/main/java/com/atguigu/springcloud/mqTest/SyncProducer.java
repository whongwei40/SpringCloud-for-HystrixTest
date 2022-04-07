/*
package com.atguigu.springcloud.mqTest;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;


*/
/**
 * @author dongjunzi
 * @DATE 2022/4/6 10:56
 *//*

public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //使用生产者组名称进行实例化。
        DefaultMQProducer producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        // 指定名称服务器地址。
        producer.setNamesrvAddr("localhost:9876");
        //启动实例。
        producer.start();
        for (int i = 0; i < 100; i++) {
            //创建一个消息实例，指定主题、标签和消息正文。
            Message msg = new Message("TopicTest" */
/* Topic *//*
,
                    "TagA" */
/* Tag *//*
,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) */
/* 邮件正文 *//*

            );
            //调用发送消息以将消息传递给代理之一.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //一旦生产者实例不再使用就关闭。
        producer.shutdown();
    }
}
*/
