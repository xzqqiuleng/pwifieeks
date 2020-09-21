package com.peek.camera.tcp;


import io.netty.channel.ChannelHandler;

public interface FireChannelHandlers {
    ChannelHandler[] channelHandlers();
}