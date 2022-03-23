package kw.test.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AppClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1",8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){
            String s = in.readLine();
            out.println("xxxxxxxxxxxxx");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
