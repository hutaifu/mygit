package com.jxd.ch11;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName TestOutputStream
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class TestOutputStream {
    public static void main(String[] args) {
        //创建数据的传输通道
        try {
            OutputStream out = new FileOutputStream("d:\\test.txt");
            //用于存储控制台输入内容
            byte[] bytes = new byte[1024];

            try {
                //将控制台输入的内容保存到了字节数组中，返回读取到的字节长度
                int count = System.in.read(bytes);
                //将字节数组中的内容保存到文件中
                //将数组中有值的元素写到文件中，后面的空位置不会写入到文件中
                out.write(bytes,0,count);

                //刷新输出流
                out.flush();
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
