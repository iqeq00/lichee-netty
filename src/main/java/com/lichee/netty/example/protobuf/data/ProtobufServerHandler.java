package com.lichee.netty.example.protobuf.data;

import com.lichee.protobuf.example.dataInfo.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtobufServerHandler extends SimpleChannelInboundHandler<DataInfo.Data> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Data msg) throws Exception {

        DataInfo.Data.DataType dataType = msg.getDataType();
        if(dataType == DataInfo.Data.DataType.PersonType) {
            DataInfo.Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getAddress());
        } else if(dataType == DataInfo.Data.DataType.DogType) {
            DataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        } else {
            DataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getCity());
        }
    }
}
