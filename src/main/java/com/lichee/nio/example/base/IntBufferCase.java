package com.lichee.nio.example.base;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class IntBufferCase {

    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            intBuffer.put(randomNumber);
        }

        //从读取切换到写入的翻转方法
        intBuffer.flip();

        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
