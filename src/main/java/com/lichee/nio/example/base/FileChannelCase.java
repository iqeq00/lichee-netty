package com.lichee.nio.example.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelCase {

    private static void inputFileChannel() {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("settings.gradle");
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(50);
            fileChannel.read(byteBuffer);

            byteBuffer.flip();

            while (byteBuffer.remaining() > 0) {
                byte by = byteBuffer.get();
                System.out.println("Charet : " + (char) by);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void outputFileChannel() {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("lichee-netty.log");
            FileChannel fileChannel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(50);

            byte[] content = "java nio hello world!".getBytes();
            for (int i = 0; i < content.length ; i++) {
                byteBuffer.put(content[i]);
            }

            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        inputFileChannel();
        outputFileChannel();
    }

}