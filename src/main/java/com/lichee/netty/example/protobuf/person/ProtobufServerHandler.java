package com.lichee.netty.example.protobuf.person;

import com.lichee.protobuf.example.person.Person;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtobufServerHandler extends SimpleChannelInboundHandler<Person.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Person.Student msg) throws Exception {

        System.out.println(msg.getName());
        System.out.println(msg.getAge());
        System.out.println(msg.getAddress());
    }
}
