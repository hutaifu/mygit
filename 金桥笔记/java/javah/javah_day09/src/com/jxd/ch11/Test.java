package com.jxd.ch11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        //建立数据传输的通道
        try {
            InputStream in = new FileInputStream("d:\\Welcome.html");
            //创建字节数组接收文件中读取到的数据
            byte[] bytes = new byte[1024];
            //读取文件内容,存储到字节数组中,并返回读取到的字节数
            try {
          /*      int length = in.read(bytes);
                System.out.println(new String(bytes));
                //将字节数组中的内容转换为字符串输出
                while (length != -1){//-1代表没有读到任何内容
                    length = in.read(bytes);
                    System.out.println(new String(bytes));
                }*/

                while (in.read(bytes) != -1){
                    System.out.println(new String(bytes));
                }


                in.close();

            }catch (IOException e){
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
