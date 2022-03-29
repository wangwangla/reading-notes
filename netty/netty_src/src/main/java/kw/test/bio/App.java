package kw.test.bio;

import kw.test.log.KLog;
import kw.test.log.NettyLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        new NettyLog();
        try {
            KLog.info("server port", "8888");
            ServerSocket socket = new ServerSocket(8888);
            KLog.info("server bind","success");
            while (true) {
                KLog.info("server","accept");
                Socket accept = socket.accept();
                //每个连接通过一个线程进行处理
                new Thread(new AcceptHandler(accept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class AcceptHandler implements Runnable {
    private Socket socket;
    public AcceptHandler(Socket socket){
        this.socket = socket;
        KLog.info("handler ","socket connect!!!");
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
                KLog.info("wait read"," wait msg");
                body = in.readLine();
                if (body == null){
                    break;
                }
                if (body.equals("exit")){
                    KLog.info("exit","channel 关闭");
                    break;
                }
                KLog.info("the msg ", body);
                current = "revive "+ socket.getInetAddress()+"  msg "+body;
                out.println(current);
            }

        }catch (Exception e){

        }
    }
}