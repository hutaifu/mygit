package com.jxd.ch11;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName com.jxd.ch11.TestFile
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class TestFile {
    public static void main(String[] args) {
        //创建文件对象，对应硬盘上的一共文件或者目录
        //\\代表根目录，当前文件所在根目录
        //d盘下的test文件夹
        File file = new File("\\test");
        //判断硬盘上是否存在改文件夹
        if (!file.exists()){
            //我们负责创建这个文件夹
            file.mkdir();
        }

        //在E盘下创建文件夹
        /*File file1 = new File("e:\\test");
        file1.mkdir();*/
/*

相对路径
        File file2 = new File("test");
        file2.mkdir();
*/

        //返回当前目录下所有的子文件,同时包含路径信息
//        File[] lists = file.listFiles();
        File fileTxt = new File("d:\\","test.txt");
        if (!fileTxt.exists()){
            //创建文件
            try {
                fileTxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
