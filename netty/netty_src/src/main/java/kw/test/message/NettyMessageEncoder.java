//package kw.test.message;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.MessageToMessageEncoder;
//import io.netty.handler.codec.marshalling.MarshallingEncoder;
//
//import java.util.List;
//import java.util.Map;
//
//public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {
//    private MarshallingEncoder marshallingEncoder;
//    public NettyMessageEncoder(){
//        this.marshallingEncoder = new MarshallingEncoder();
//    }
//    @Override
//    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, List<Object> out) throws Exception {
//        if (msg == null || msg.getHeader() == null){
//            throw new Exception("The code message is null");
//        }
//        ByteBuf sendBuf = Unpooled.buffer();
//        sendBuf.writeInt(msg.getHeader().getCrcCode());
//        sendBuf.writeInt(msg.getHeader().getLength());
//        sendBuf.writeLong(msg.getHeader().getSessionId());
//        sendBuf.writeByte(msg.getHeader().getType());
//        sendBuf.writeByte(msg.getHeader().getPriority());
//        sendBuf.writeInt(msg.getHeader().getAttachMent().size());
//
//        String key = null;
//        byte[] keyArray = null;
//        Object value = null;
//
//        for (Map.Entry<String, Object> param : msg.getHeader().getAttachMent().entrySet()) {
//            key = param.getKey();
//            key.getBytes("UTF-8");
//            sendBuf.writeInt(keyArray.length);
//            sendBuf.writeBytes(keyArray);
//            value = param.getValue();
//            marshallingEncoder.encode(value,sendBuf);
//        }
//        key = null;
//        keyArray = null;
//        value = null;
//        if (msg.getBody() != null){
//            marshallingEncoder.encode(msg.getBody(),sendBuf);
//        }else {
//            sendBuf.writeInt(0);
//            sendBuf.setInt(4,sendBuf.readableBytes());
//        }
//
//    }
//}
