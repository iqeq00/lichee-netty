package com.lichee.nio.example.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileNioCase {

    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("lichee-netty.log");
        FileOutputStream fileOutputStream = new FileOutputStream("lichee-netty2.log");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

        while (true) {
            byteBuffer.clear();
            int readNum = inputChannel.read(byteBuffer);
            System.out.println("readNum: " + readNum);
            if (-1 == readNum) {
                break;
            }
            byteBuffer.flip();
            outputChannel.write(byteBuffer);
        }
        inputChannel.close();
        outputChannel.close();
    }
}
