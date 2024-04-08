package com.jxd.serverthread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Server
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class Server {
    //将list声明为线程安全，只有上一个线程用完这个对象，下一个线程才去使用它。
    public static List<Socket> list = Collections.synchronizedList(new ArrayList<>());
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);

            while (true){
                //每个客户端连接成功后，都会在服务端创建一个socket对象
                Socket s = serverSocket.accept();
                list.add(s);

                //针对当前的客户端，开启一个线程
                Thread thread = new Thread(new ServerThread(s));
                thread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
