package com.ruoyi.Mudbus;

import com.ruoyi.iot.domain.TDevice;
import com.ruoyi.iot.domain.THistory;
import com.ruoyi.iot.service.ITDeviceService;
import com.ruoyi.iot.service.ITHistoryService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//作为组件加载
@Component
public class NettyServerHandler extends SimpleChannelInboundHandler{

    public static NettyServerHandler nettyServerHandler;
    //注入物联网终端数据操作服务
    @Autowired
    protected ITDeviceService itDeviceService;
    //注入历史数据操作服务
    @Autowired
    protected ITHistoryService itHistoryService;

    /**
     * 构建函数
     */
    public NettyServerHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }


    /**
     * 初始化服务器处理
     */
    @PostConstruct
    public void init(){
        nettyServerHandler=new NettyServerHandler();
        nettyServerHandler.itDeviceService=this.itDeviceService;
        nettyServerHandler.itHistoryService=this.itHistoryService;
    }

    /**
     * 客户端连接触发
     * @param ctx
     * @throws Exception
     */
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        System.out.println("客户端激活....");
        ctx.writeAndFlush("hello client");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        //提取有效数据
        byte[] bytes=(byte[])msg;
        //显示接收数据
        String strData=NettyServer.byteToHexSpring(bytes);
        System.out.println("服务器收到Message"+strData);
        //解析并保存数据
        int rest=SaveData(getZh(bytes),getwendu(bytes),getShuiwei(bytes));
        System.out.println("保存数据"+rest+"条！");
    }

    /**
     * 处理接收数据
     * @param ctx
     * @param o
     */

    protected void messageReceived(ChannelHandlerContext ctx, Object o){
        //提取有效数据

    }

    /**
     * 通道数据读取完成事件
     * @param ctx
     * @throws Exception
     */
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("data ok!");
    }

    /**
     * 异常错误处理
     * @param ctx
     * @param cause
     * @throws Exception
     */
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) throws Exception{
        System.out.println("error!"+cause.getMessage());
        ctx.close();
    }

    /**
     * 解析站号
     * @param bdata
     * @return
     */
    public long getZh(byte[] bdata){
        long istation=bdata[6];
        return istation;
    }

    /**
     * 解析温度
     * @param bdata
     * @return
     */
    public BigDecimal getwendu(byte[] bdata){
        //取字节数组第10数据，并消除负值
        int iHigh=0xff&bdata[9];
        //取字节数组第11数据，并消除负值
        int iLow=0xff&bdata[10] ;
        float fVaL= (iHigh*255+iLow)/100.0f;
        BigDecimal result=new BigDecimal(Float.toString(fVaL));
        System.out.println("温度:"+ result) ;
        return result;
    }

    /**
     * 解析水位
     * @param bdata
     * @return
     */
    public BigDecimal getShuiwei(byte[] bdata){
        //取字节数组第12数据，并消除负值
        int iHigh=0xff&bdata[11];
        //取字节数组第13数据，并消除负值
        int iLow=0xff&bdata[12];
        float fval= (iHigh*255+iLow)/100.0f;
        System.out.println("f水位:"+ bdata[11]+"-"+ bdata[12]);
        BigDecimal result=new BigDecimal(Float.toString(fval));
        System.out.println("水位:"+ result);
        return result;
    }

    /**
     更新实时数据，插入历史数据
     //@param zh站号
     // @param wd温度
     // @param SW水位
     @return改变记录数
     */
    public static int SaveData(long zh, BigDecimal wd,BigDecimal sw) {
        //查询该站号设备列表
        TDevice tDevice = new TDevice();
        tDevice.setStation(zh);
        List<TDevice> devices = nettyServerHandler.itDeviceService.selectTDeviceList(tDevice);
        int Reult = 0;

        if (!devices.isEmpty()) {
            for (TDevice td : devices) {
                //更新物联网终端设备实时数据
                td.setTemperature(wd);
                td.setWaterlevel(sw);
                td.setUptime(new Date());
                nettyServerHandler.itDeviceService.updateTDevice(td);
                Reult++;
                //插入历史数据
                THistory th = new THistory();
                th.setDeviceid(td.getId());
                th.setTemperature(wd);
                th.setWaterlevel(sw);
                th.setUptime(new Date());
                nettyServerHandler.itHistoryService.insertTHistory(th);
                Reult++;
            }
        }
        return Reult;
    }
}

