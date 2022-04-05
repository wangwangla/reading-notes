package kw.test.chat.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import kw.test.ByteBufferUtil;
import kw.test.chat.config.Config;
import kw.test.chat.protocol.Serializer;

import java.util.List;

public class MessageCodecSharable extends MessageToMessageCodec<ByteBuf, Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> outList) throws Exception {
        System.out.println("编码"+msg.getClass());
        ByteBuf out = ctx.alloc().buffer();
        // 1. 4 字节的魔数  1234
        out.writeBytes(new byte[]{1, 2, 3, 4});
        // 2. 1 字节的版本,1
        out.writeByte(1);
        // 3. 1 字节的序列化方式 jdk 0 , json 1 1
        out.writeByte(Config.getSerializerAlgorithm().ordinal());
        //1
        out.writeByte(1);
        // 4. 1 字节的指令类型  0
        out.writeByte(msg.getMessageType());
        // 5. 4 个字节  0000
        out.writeInt(msg.getSequenceId());
        // 无意义，对齐填充 -1000-56
        out.writeByte(0xff);
        // 6. 获取内容的字节数组
        byte[] bytes = Config.getSerializerAlgorithm().serialize(msg);
//        byte[] bytes = Serializer.Algorithm.Java.serialize(msg);
        // 7. 长度
        out.writeInt(bytes.length);
        // 8. 写入内容
        out.writeBytes(bytes);
        outList.add(out);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
//        while (in.isReadable()) {
//            System.out.print(in.readByte());
//        }
//
        System.out.println("解码");
        int mag = in.readInt();
        int version = in.readByte();
        int serType = in.readByte();
        int no = in.readByte();
        int messageType = in.readByte();
        int seqId = in.readInt();
        int noValue = in.readByte();
        int length = in.readInt();
//
        System.out.println(
                "\nmag"+mag
                +"\nversion"+version
                +"\nserType"+serType
                +"\nno"+no
                +"\nmessageType"+messageType
                +"\nseqId"+seqId
                +"\nnoValue"+noValue
                +"\nlength"+length
        );
//
//        in.readBytes(mag,0,4);
//        for (int i = 0; i < mag.length; i++) {
//            System.out.print(mag[i]+" msg");
//        }
//        System.out.println();
//        byte b = in.readByte();
//        System.out.println(b+"  字节版本");
//
//        //序列胡方式
//        byte b1 = in.readByte();
//        System.out.println(b1+"序列化方式");
//
//        //
//        byte b2 = in.readByte();
//        System.out.println(b2+"  不知道是什么");
//
//
//        byte b3 = in.readByte();
//        System.out.println(b3+"  指令类型");
//
//        byte[] b4 = new byte[8];
//        in.readBytes(b4,0,8);
//        System.out.println("对---------------");
//        for (byte b5 : b4) {
//            System.out.println(b5);
//        }


//        while (in.isReadable()) {
//            System.out.println(in.readByte());
//        }
//
//
//        int magicNum = in.readInt();
//        tool(magicNum,in);
//        byte version = in.readByte();
//        tool(version,in);
//        byte serializerAlgorithm = in.readByte(); // 0 或 1
//        tool(serializerAlgorithm,in);
//        byte messageType = in.readByte(); // 0,1,2...
//        tool(messageType,in);
//        int sequenceId = in.readInt();
//        tool(messageType,in);
//        in.readByte();
//        int length = in.readInt();
//        System.out.println("--length"+length);
        byte[] bytes = new byte[length];
        in.readBytes(bytes, 0, length);
//
//        // 找到反序列化算法
        Serializer.Algorithm algorithm = Serializer.Algorithm.values()[serType];
//
//        // 确定具体消息类型
        Class<? extends Message> messageClass = Message.getMessageClass(messageType);
        Message message = algorithm.deserialize(messageClass, bytes);
//        log.debug("{}, {}, {}, {}, {}, {}", magicNum, version, serializerType, messageType, sequenceId, length);
//        log.debug("{}", message);
        out.add(message);
    }

    public static void tool(int magicNum, ByteBuf in){
        System.out.println(magicNum+"---------");
//        byte mag[] = new byte[magicNum];
//        in.readBytes(mag,0,mag.length);
//        System.out.println("mag");
//        for (int i = 0; i < mag.length; i++) {
//            System.out.println(mag[i]);
//        }
//        System.out.println("mag");
    }
}
