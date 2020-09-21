package com.peek.camera.tcp;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ClientUserEventTriggeredHandler extends ChannelInboundHandlerAdapter {

    //当超过n秒没有写时会触发该事件
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (state == IdleState.WRITER_IDLE) {
//                ctx.writeAndFlush(Unpooled.copiedBuffer("ping", CharsetUtil.UTF_8));
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}