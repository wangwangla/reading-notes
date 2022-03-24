package kw.test.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * Buffer
 * channel
 * Selector
 *
 *
 * 分任务进行处理
 */
public class App {
    public static void main(String[] args) {
        try (
                ServerSocketChannel serverSocket = ServerSocketChannel.open();
                Selector selector = Selector.open();
                ){
            serverSocket.configureBlocking(false);
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            serverSocket.bind(new InetSocketAddress(8888));
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    System.out.println("-----------------------");
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    if (next.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) next.channel();
                        SocketChannel accept = serverSocketChannel.accept();
                        accept.configureBlocking(false);
                        accept.register(selector,SelectionKey.OP_READ);
                    }else if (next.isReadable()){
                        SocketChannel channel = (SocketChannel) next.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int read = channel.read(buffer);
                        if (read==-1){
                            next.cancel();
                            continue;
                        }
                        buffer.flip();
                        CharBuffer decode = StandardCharsets.UTF_8.decode(buffer);
                        if (decode.toString().equals("exit")){
                            break;
                        }
                        System.out.println(decode);
                        ByteBuffer hello_world = StandardCharsets.UTF_8.encode("hello world");
                        channel.write(hello_world);
                    }
                }
            }
//            serverSocket.accept()
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
