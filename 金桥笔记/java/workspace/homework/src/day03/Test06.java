package day03;

import java.util.Scanner;

public class Test06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入成绩：");
        double score = input.nextDouble();
        if (score >= 90){
            System.out.println("爸爸给他卖车");
        }else if (score >= 80){
            System.out.println("妈妈给买电脑");
        }else if (score >= 60){
            System.out.println("奶奶给买手机");
        }else {
            System.out.println("没有礼物");
        }
    }
}
