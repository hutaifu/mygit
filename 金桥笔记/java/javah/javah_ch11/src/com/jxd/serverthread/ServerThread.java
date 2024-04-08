package com.jxd.serverthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @ClassName ServerThread
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread() {
    }

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //用于获取客户端数据
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    //用于向所有客户端回显消息
//            PrintStream ps = new PrintStream(socket.getOutputStream());

            while (true){
                //接收某个客户端的消息
                String str = br.readLine();
                //将其回显给其他所有的客户端
                for (Socket s: Server.list) {
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(str);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
