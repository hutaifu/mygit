package day02;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入张三的html成绩：");
        double htmlSore = input.nextDouble();
        System.out.println("请输入张三的Java成绩：");
        double javaScore = input.nextDouble();
//        if(htmlSore > 90 && javaScore >85){
//            System.out.println("奖励张三一个u盘");
            //满足其中一个条件
            if (htmlSore == 100 || javaScore >99){
                System.out.println("奖励张三一个u盘");
            }
                if ((htmlSore > 90 && javaScore >80) || (htmlSore > 95 && javaScore>90)){
                    System.out.println("奖励张三");
                }
                if (htmlSore !=100){
                    System.out.println("没有满分");
                }
                if (!(htmlSore >90)){
                    System.out.println("没有到九十分");
                }
                if (!true){
                    System.out.println();
                }
    }
}
