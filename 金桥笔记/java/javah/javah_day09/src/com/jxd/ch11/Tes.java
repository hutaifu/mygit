package com.jxd.ch11;

import java.io.File;

/**
 * @ClassName Tes
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class Tes {
    public static void main(String[] args) {
        File file = new File("d:\\app");
        File[] files = file.listFiles();

        for (int i = 0;i < files.length; i++){
            System.out.println(files[i].getName());
        }
    }
}
