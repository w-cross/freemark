//package netty.nio;
//
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//
//import java.util.Scanner;
//
///**
// * @author
// * @version $Id: ServerHandler, v0.1
// * @company
// * @date 2018年03月08日 18:00
// */
//public class ServerHandler extends SimpleChannelInboundHandler<String> {
//    /**
//     * 检测会话状态
//     * @param ctx
//     * @param msg
//     * @throws Exception
//     */
//    @Override
//    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
//        System.out.println(msg);
//        //客户端给服务端回消息
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入:");
//        msg = scanner.nextLine();
//        System.out.println("发送");
//        ctx.channel().writeAndFlush(msg);
//
//    }
//
//    /**
//     * 新客户端接入
//     *
//     * @param ctx
//     * @throws Exception
//     */
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("新客户端连接..");
//        super.channelActive(ctx);
//    }
//
//    /**
//     * 新客户端断开
//     *
//     * @param ctx
//     * @throws Exception
//     */
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        super.channelInactive(ctx);
//    }
//
//    /**
//     * 异常处理
//     *
//     * @param ctx
//     * @param cause
//     * @throws Exception
//     */
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
//    }
//
//}
