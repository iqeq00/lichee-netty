package com.lichee.protobuf.example.person;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 *
 */
public class PersonTest {

    public static void main(String[] args) throws Exception {

        //生成一个对象
        Person.Student student = Person.Student.newBuilder()
            .setName("里奇").setAge(18).setAddress("成都").build();
        //对象转成字节数组
        byte[] studentToByte = student.toByteArray();
        //把对象字节数组转换成对象
        Person.Student stu = Person.Student.parseFrom(studentToByte);
        System.out.println(stu);
        //通过get方法的调用，就是转义后的内容了
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getAddress());
    }
}
