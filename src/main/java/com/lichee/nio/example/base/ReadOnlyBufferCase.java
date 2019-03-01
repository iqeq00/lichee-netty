package com.lichee.nio.example.base;

import java.nio.ByteBuffer;

/**
 * 只读buffer，我们可以随时把一个普通Buffer，通过调用asReadOnlyBuffer方法，
 * 返回一个只读Buffer，但不能把一个只读Buffer转换为读写Buffer
 */
public class ReadOnlyBufferCase {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.getClass());

        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte)i);
        }

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        //Invoking as below method, java.nio.ReadOnlyBufferException
        //readOnlyBuffer.position(0);
        //readOnlyBuffer.put((byte)2);
    }
}
