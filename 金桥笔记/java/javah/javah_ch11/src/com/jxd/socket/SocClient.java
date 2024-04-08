package com.jxd.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @ClassName SocClient
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/11
 * @Version 1.0
 */

public class SocClient {
    public static void main(String[] args) {
        //尝试访问服务端
        try {
            Socket s = new Socket("127.0.0.1",6666);
            //获取服务器的数据
            InputStream in = s.getInputStream();
            //包装为缓冲区对象
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            //接收服务端发送的数据
            String str = br.readLine();
            System.out.println(str);

            /*System.out.println("连接成功");*/


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
