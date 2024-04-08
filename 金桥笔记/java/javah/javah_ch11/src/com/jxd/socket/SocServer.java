package com.jxd.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName SocServer
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class SocServer {
    public static void main(String[] args) {
        //创建服务端,指定端口
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            //接收客户端的访问,并且返回服务端的socket对象
            Socket s = serverSocket.accept();
            //向客户端发送连接成功的信息
            OutputStream out = s.getOutputStream();
//包装为PrintStream
            PrintStream pw = new PrintStream(out);
            pw.println("你已经成功连接服务端");

//            System.out.println("客户端访问成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
