package com.ruoyi.Mudbus;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup ;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;

public class NettyServer{

    public void start(InetSocketAddress socketAddress) {
        //new一个主线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //new一个工作线程组
        EventLoopGroup workGroup = new NioEventLoopGroup(200);
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerChannelInitializer())
                .localAddress(socketAddress)
                //设置队列大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                //两个小时没有数据通信时，tcp会自动发送-个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        try{
            ChannelFuture future=bootstrap.bind(socketAddress).sync();
            System.out.println("服务器启动开始监听端口："+socketAddress.getPort());
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //关闭主线程组
            bossGroup.shutdownGracefully();
            //关闭工作组线程组
            workGroup.shutdownGracefully();
        }
    }
    //十六进制转换成字符串
    public  static String byteToHexSpring(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte :bytes) {
            String hex = Integer.toHexString(0xFF & aByte);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
            sb.append(' ');
        }
        return "ok";
    }

}