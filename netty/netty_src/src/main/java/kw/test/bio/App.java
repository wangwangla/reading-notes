package kw.test.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8888);
            while (true) {
                System.out.println("run accept");
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
                if (body.equals("exit")){
                    System.out.println("channel 关闭");
                    break;
                }
                System.out.println("the msg "+ body);
                current = "revive "+ socket.getInetAddress()+"  msg "+body;
                out.println(current);
                System.out.println(socket);
            }

        }catch (Exception e){

        }
    }
}