package com.lichee.netty.example.protobuf.person;

import com.lichee.protobuf.example.person.Person;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtobufClientHandler extends SimpleChannelInboundHandler<Person.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Person.Student msg) throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Person.Student student = Person.Student.newBuilder().setName("里奇").setAge(18).setAddress("成都市").build();
        ctx.channel().writeAndFlush(student);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
