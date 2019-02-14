package com.lichee.netty.example.protobuf.data;

import com.lichee.protobuf.example.dataInfo.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class ProtobufClientHandler extends SimpleChannelInboundHandler<DataInfo.Data> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Data msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int randomInt = new Random().nextInt(3);
        DataInfo.Data data = null;

        if (0 == randomInt) {
            data = DataInfo.Data.newBuilder()
                .setDataType(DataInfo.Data.DataType.PersonType)
                .setPerson(DataInfo.Person.newBuilder()
                    .setName("里奇").setAge(18).setAddress("高新区").build())
                .build();
        } else if (1 == randomInt) {
            data = DataInfo.Data.newBuilder()
                .setDataType(DataInfo.Data.DataType.DogType)
                .setDog(DataInfo.Dog.newBuilder()
                    .setName("金毛").setAge(3).build())
                .build();
        } else {
            data = DataInfo.Data.newBuilder()
                .setDataType(DataInfo.Data.DataType.CatType)
                .setCat(DataInfo.Cat.newBuilder()
                    .setName("加菲").setCity("成都").build())
                .build();
        }
        ctx.channel().writeAndFlush(data);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
