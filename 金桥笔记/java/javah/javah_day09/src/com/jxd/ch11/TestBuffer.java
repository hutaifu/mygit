package com.jxd.ch11;

import java.io.*;

/**
 * @ClassName TestBuffer
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class TestBuffer {
    public static void main(String[] args) {
        //创建输入流、用于将键盘输入的内容读到程序中
        InputStreamReader in = new InputStreamReader(System.in);
        //创建输入流的缓冲区
        BufferedReader br = new BufferedReader(in);

        //创建输出流对象，勇于写入到文件中
        try {
            Writer writer = new FileWriter("d:\\test.txt");
            //创建缓存区
            BufferedWriter bw = new BufferedWriter(writer);

            String str = "";
            //br.readline用于读取数据到缓冲区，并返回读取到的字符串
           str = br.readLine();
           while (str.length() > 0){
               //将字符串内容写入到缓冲区
               bw.write(str);
               bw.newLine();
               //在控制台继续输入内容
               str = br.readLine();
           }
           br.close();
           bw.flush();
           bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
