package com.jxd.serverthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @ClassName ClientTread
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class ClientTread extends Thread{
    private Socket socket;

    public ClientTread() {
    }


    public ClientTread(Socket socket) {
        this.socket = socket;
    }

    //该线程用于接收服务器的消息
    public void run(){
        //定义输入流
        try {
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            while (true){
                String str = br.readLine();
                System.out.println(str);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
