package com.atguigu.rabbitmq.server;
import com.alibaba.fastjson.JSON;
import com.atguigu.rabbitmq.entity.Student;
import com.atguigu.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.tools.json.JSONUtil;

import java.util.ArrayList;

/**
 * @author dongjunzi
 * @version 1.0
 * @date 2022/7/27 13:52
 */
public class Producer {

      public   static final String QUEUE_NAME = "simple_queue";
        public static void main(String[] args) throws Exception {

            //创建连接
            Connection connection = ConnectionUtil.getConnection();
            // 创建频道
            Channel channel = connection.createChannel();
            // 声明（创建）队列
            /**
             * 参数1：队列名称
             * 参数2：是否定义持久化队列
             * 参数3：是否独占本次连接
             * 参数4：是否在不使用的时候自动删除队列
             * 参数5：队列其它参数
             */
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            // 要发送的信息
            String message = "你好；小兔子！";
            Student student = new Student("1", 23);
            Student student1 = new Student("2", 30);
            ArrayList<Student> students = new ArrayList<>();
            students.add(student1);
            students.add(student);
            /**
             * 参数1：交换机名称，如果没有指定则使用默认Default Exchage
             * 参数2：路由key,简单模式可以传递队列名称
             * 参数3：消息其它属性
             * 参数4：消息内容
             */
            channel.basicPublish("", QUEUE_NAME, null, student.toString().getBytes());
            System.out.println("已发送消息：" + student);
            // 关闭资源
            channel.close();
            connection.close();
        }
    }


