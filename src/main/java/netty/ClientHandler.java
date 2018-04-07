package netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author
 * @version $Id: ClientHandler, v0.1
 * @company
 * @date 2018年03月08日 19:43
 */
public class ClientHandler extends SimpleChannelInboundHandler<String > {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        System.out.println("客户端收到消息：" + msg);

    }
}
