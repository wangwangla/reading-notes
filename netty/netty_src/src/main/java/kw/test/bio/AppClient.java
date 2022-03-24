package kw.test.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;

public class AppClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1",8888);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){

            System.out.println("_--------------------");
            out.println("hello");
            out.flush();
            char [] arr = new char[30];
            in.read(arr);
            System.out.println(String.copyValueOf(arr));
            out.println("exit");
            out.flush();
            in.read(arr);
            System.out.println(String.copyValueOf(arr));
            System.in.read();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
