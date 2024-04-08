package com.jxd.ch11;

import java.io.*;

/**
 * @ClassName TestCopy
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class TestCopy {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("d:\\DBUtil.java");
            Writer writer = new FileWriter("d:\\test.txt");
            char[] chars = new char[1024];
            while ((reader.read(chars)) != -1){
                writer.write(chars);
            }
            reader.close();
            writer.flush();
            writer.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
