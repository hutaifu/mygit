package day09;

import java.util.Scanner;

/**
 * @ClassName Name1
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Name1 {
    public static void main(String[] args) {
        System.out.println("请输入姓名：");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        String lastName = name.substring(0,1);
        String fistName = name.substring(1);
        System.out.println("姓：" + lastName);
        System.out.println("名：" + fistName);
    }
}
