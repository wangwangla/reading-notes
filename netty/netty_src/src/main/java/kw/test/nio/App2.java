package kw.test.nio;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class App2 {

    public static void main(String[] args) {
        ThreadPoolExecutor bossgroup  = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
        try (
                ServerSocketChannel serverSocket = ServerSocketChannel.open();
                Selector selector = Selector.open();
        ){
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            serverSocket.configureBlocking(false);
            bossgroup.execute(new BossGroup(selector));
//            serverSocket.accept()
        }catch (Exception e){

        }
    }
}


class BossGroup implements Runnable{
    private Selector selector;
    public BossGroup(Selector selector){
        this.selector = selector;
    }

    @Override
    public void run() {
        while (true) {
            try {
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator!=null){
                SelectionKey next = iterator.next();
                if (next.isReadable()) {

                }else if (next.isReadable()){

                }
            }
        }
    }
}

class DefaultGroup implements Runnable{
    public Selector selector;
    public DefaultGroup(SelectionKey key){
        try {
            this.selector = Selector.open();
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            channel.register(selector,SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            selector.select();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}