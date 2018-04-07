package netty.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.ImmediateEventExecutor;

import java.util.*;

/**
 * @author
 * @version $Id: Server, v0.1
 * @company
 * @date 2018年03月08日 17:52
 * <p>
 * Netty5服务类
 */
public class Server {
    static List<Channel> list = new ArrayList<Channel>();

    public static void main(String[] args) {
        //服务类
        final ServerBootstrap bootstrap = new ServerBootstrap();

        //boss和worker
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ChannelGroup group = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);
        //等待服务端关闭
        try {

            //设置线程池
            bootstrap.group(boss, worker);

            //设置Socket工厂
            bootstrap.channel(NioServerSocketChannel.class);

            //设置管道工厂
            bootstrap.childHandler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel channel) throws Exception {
                    /**
                     *
                     通常我们也习惯将编码（Encode）称为序列化（serialization），
                     它将对象序列化为字节数组，用于网络传输、数据持久化或者其它用途。
                     反之，解码（Decode）/反序列化（deserialization）把从网络、
                     磁盘等读取的字节数组还原成原始对象（通常是原始对象的拷贝），以方便后续的业务逻辑操作。
                     */
                    //设置解码过滤器
                    channel.pipeline().addLast(new StringDecoder());
                    //设置编码过滤器
                    channel.pipeline().addLast(new StringEncoder());
                    //设置处理器
                    //先加入list中
                    list.add(channel);
                    channel.pipeline().addLast(new ServerHandler());
                }
            });

            //设置参数 TCP参数
            //设置连接缓冲池的大小
            bootstrap.option(ChannelOption.SO_BACKLOG, 2048);
            //维持连接的活跃，清楚子连接
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            //关闭延迟发送
            bootstrap.childOption(ChannelOption.TCP_NODELAY, true);


            //绑定端口
            ChannelFuture future = bootstrap.bind(10101);

            System.out.println("服务启动...");

            //等待服务器关闭
            future.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }

    static class ServerHandler extends SimpleChannelInboundHandler<String> {
        /**
         * 检测会话状态
         *
         * @param ctx
         * @param msg
         * @throws Exception
         */
        @Override
        protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {

            System.out.println(msg);
            //客户端给服务端回消息

//            Scanner scanner = new Scanner(System.in);
//            System.out.println("输入:");
//            msg = scanner.nextLine();
//            System.out.println("发送");

//            ctx.channel().writeAndFlush(msg);
            for (Channel s : list){
                s.writeAndFlush(msg);
            }
        }

        /**
         * 新客户端接入
         *
         * @param ctx
         * @throws Exception
         */
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("新客户端连接..");
            super.channelActive(ctx);
        }

        /**
         * 新客户端断开
         *
         * @param ctx
         * @throws Exception
         */
        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            super.channelInactive(ctx);
        }

        /**
         * 异常处理
         *
         * @param ctx
         * @param cause
         * @throws Exception
         */
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }

    }


}
