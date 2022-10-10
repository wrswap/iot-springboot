package com.ruoyi.Mudbus;
import io.netty.channel. Channel;
import io.netty.channel. ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.string.StringEncoder;
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
//添加解码器
        socketChannel.pipeline()
                .addLast(new StringEncoder())
                .addLast(new ByteArrayDecoder())
                .addLast(new NettyServerHandler());
    }
}

