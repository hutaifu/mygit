package com.jxd.ch11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @ClassName TestWriter
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class TestWriter {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("d:\\test.txt");
            String str = "这是要写入到文件中的内容";
            //可以直接将字符串写入到文件中
            //方法内部会将这个字符串转换为char数组
            writer.write(str);

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
