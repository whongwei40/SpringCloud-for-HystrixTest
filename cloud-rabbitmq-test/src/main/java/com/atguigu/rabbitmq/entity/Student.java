package com.atguigu.rabbitmq.entity;

import lombok.Data;

/**
 * @author dongjunzi
 * @version 1.0
 * @date 2022/7/27 15:06
 */
@Data
public class Student implements Comparable<Student> {

    public  Student(String name,Integer age){
        this.age=age;
        this.name=name;
    }
    private String name;

    private int age;

    @Override
    public int compareTo(Student student) {
        return this.getAge()<student.getAge()?-1:1;
    }
}
