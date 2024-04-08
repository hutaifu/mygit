package day09;

import java.util.Scanner;

/**
 * @ClassName TestHappennum
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class TestHappennum {
    public static void main(String[] args) {
        Happennum happennum = new Happennum();
        String str2 = "";

        System.out.println("请输入一个字符串：");
        Scanner input = new Scanner(System.in);
        String string = input.next();
        System.out.println("请输入要查找的字符：");
        String str1 = input.next();
        if (str1.length() == 1){
            str2 = str1;
        }
        happennum.happenNum(string,str2);
    }
}

