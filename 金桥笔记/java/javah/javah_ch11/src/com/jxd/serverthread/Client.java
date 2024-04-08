package com.jxd.serverthread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",6666);
            //创建子线程
            ClientTread clientTread = new ClientTread(socket);
            clientTread.start();

            //向服务端发送消息
            OutputStream out = socket.getOutputStream();
            PrintStream pw = new PrintStream(out);

            Scanner input = new Scanner(System.in);

            while (true){
                String str = input.next();
                pw.println(str);
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
