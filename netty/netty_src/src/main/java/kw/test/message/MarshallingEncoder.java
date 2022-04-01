//package kw.test.message;
//
//import io.netty.buffer.ByteBuf;
//
//public class MarshallingEncoder {
//    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
//    Marshaller marshaller;
//
//    public MarshallingEncoder(){
//        marshaller = MarshallingCodecFactory().buildMarshalling();
//    }
//
//    protected void encode(Object msg, ByteBuf out){
//        int lengthPos = out.writerIndex();
//        out.writeBytes(LENGTH_PLACEHOLDER);
//        ChannelBufferByteOut outPut = new ChannelBufferByteOutput(out);
//        marshaller.start(outPut);
//        marshaller.writeObject(msg);
//        marshaller.finish();
//        out.setInt(lengthPos,out.writerIndex() - lengthPos - 4);
//    }
//}
