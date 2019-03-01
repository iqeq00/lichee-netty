package com.lichee.nio.example.base;

import java.nio.ByteBuffer;

/**
 * ByteBuffer typization method: put and get
 * Be careful: get element sequence must equal with put element sequence
 */
public class TypizationBufferCase {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

        byteBuffer.putShort((short)6);
        byteBuffer.putInt(66);
        byteBuffer.putLong(6666666L);
        byteBuffer.putFloat(6.0f);
        byteBuffer.putDouble(66.6666);
        byteBuffer.putChar('你');

        byteBuffer.flip();

        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getFloat());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getChar());
    }
}
