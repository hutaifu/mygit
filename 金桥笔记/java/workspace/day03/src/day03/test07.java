package day03;

import java.util.Scanner;

public class test07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数:");
//        判断用户输入的是否是一个整数
        if (input.hasNextInt()){
            int num = input.nextInt();
        }else {
            input.nextInt();//将错误的内容拿走
            System.out.println("请输入整数");
        }
        System.out.println("请输入下一个整数");
        int num1 = input.nextInt();

    }
}
