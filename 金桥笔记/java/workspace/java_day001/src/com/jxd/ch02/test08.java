package com.jxd.ch02;

import java.util.Scanner;

public class test08 {
    public static void main(String[] args) {
        int zhangSocer = 94;
        //张三的成绩
        //从键盘输入李四的成绩
        Scanner input = new Scanner(System.in);
        System.out.println("请输入李四的成绩：");
        double liScore = input.nextDouble();//获取键盘输入的成绩
        //判断张三的成绩是否大于李四的成绩
        if(zhangSocer > liScore){
            System.out.println("奖励张三一个U盘");
        }
    }
}
