package com.jxd.ch11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName TestReader
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class TestReader {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("d:\\test.txt");
            char[] chars = new char[1024];

            while(true){
                try {
                    if (((reader.read(chars)) != -1)) {
                        System.out.println(new String(chars));
                        chars = new char[1024];
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
