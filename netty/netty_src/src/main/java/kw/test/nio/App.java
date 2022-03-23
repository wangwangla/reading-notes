package kw.test.nio;

import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
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
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            serverSocket.configureBlocking(false);
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator!=null){
                    SelectionKey next = iterator.next();
                    if (next.isReadable()) {

                    }else if (next.isReadable()){

                    }
                }
            }
//            serverSocket.accept()
        }catch (Exception e){

        }
    }
}
