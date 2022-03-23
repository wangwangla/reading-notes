package kw.test.wbio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 通过线程
 */
public class Wbio {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        try {
            ServerSocket socket = new ServerSocket(8888);
            Socket accept = socket.accept();
            //每个连接通过一个线程进行处理
            executor.execute(new WAcceptHandler(accept));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class WAcceptHandler implements Runnable {
    private Socket socket;
    public WAcceptHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                this.socket.getInputStream()
        ));
             PrintWriter out = new PrintWriter(this.socket.getOutputStream(),true);
        ){
            String current = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body == null){
                    break;
                }
                System.out.println("the time ");
                current = "";
                out.println(current);
            }
        }catch (Exception e){

        }
    }
}