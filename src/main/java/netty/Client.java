package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author
 * @version $Id: Client, v0.1
 * @company
 * @date 2018年03月08日 19:38
 *
 * Netty5 服务类
 */
public class Client {
    public static void main(String[] args) {


        //创建服务类
        Bootstrap bootstrap = new Bootstrap();

        //worker
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            //设置线程池
            bootstrap.group(worker);

            //设置socket工厂
            bootstrap.channel(NioSocketChannel.class);

            //设置管道
            bootstrap.handler(new ChannelInitializer<Channel>() {
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
                    channel.pipeline().addLast(new ClientHandler());
                }
            });

            //设置连接
            ChannelFuture future = bootstrap.connect("127.0.0.1", 10101);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.println("请输入:");
                String msg = bufferedReader.readLine();
                future.channel().writeAndFlush(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            worker.shutdownGracefully();
        }
    }
}
