package day02;

import java.util.Scanner;

public class test05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入张三的成绩：");
        int sore = input.nextInt();
        if (sore > 90){
            System.out.println("奖励张三");
        }else{
            System.out.println("惩罚张三");
        }
        //条件不成立的代码
//        if (sore <= 90){
//            System.out.println("奖励张三");
//        }
    }
}
