package kw.test.netty.c5;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;

public class HttpFileServerHandler extends SimpleChannelInboundHandler<HttpRequest> {
    private String url;
    public HttpFileServerHandler(String defaultUrl) {
        this.url = defaultUrl;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpRequest msg) throws Exception {
        // 返回响应
        DefaultFullHttpResponse response =
                new DefaultFullHttpResponse(msg.protocolVersion(), HttpResponseStatus.OK);
        System.out.println("-------------------dddddddddddd");
        byte[] bytes = "<h1>Hello, world!</h1>".getBytes();

        response.headers().setInt(CONTENT_LENGTH, bytes.length);
        response.content().writeBytes(bytes);

        // 写回响应
        ctx.writeAndFlush(response);
    }
}
