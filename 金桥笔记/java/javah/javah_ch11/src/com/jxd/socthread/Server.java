package com.jxd.socthread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket = serverSocket.accept();
            //获取输入流，用于接收客户端的消息
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            //获取输出流，用于回显客户端的消息
            OutputStream out = socket.getOutputStream();
            PrintStream pw = new PrintStream(out);

            while (true){
                String str = br.readLine();
                pw.println(str);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
