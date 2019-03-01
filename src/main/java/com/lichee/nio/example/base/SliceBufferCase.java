package com.lichee.nio.example.base;

import java.nio.ByteBuffer;

/**
 * SliceBuffer和原有的Buffer共享相同的底层数组
 */
public class SliceBufferCase {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte)i);
        }

        //左开右闭原则，新的buffer相当于包含2、3、4、5这几个元素，类似substring
        byteBuffer.position(2);
        byteBuffer.limit(6);
        ByteBuffer sliceBuffer = byteBuffer.slice();

        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte element = sliceBuffer.get(i);
            //相当于乘以2
            element *= 2;
            sliceBuffer.put(i, element);
        }

        //flip method effect is change position/limit
        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());

        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }
}
