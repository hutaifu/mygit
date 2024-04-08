package day03;

import java.util.Scanner;

public class Test08 {
    public static void main(String[] args) {
        int var = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入成绩：");
        double score = input.nextDouble();
        if (score >= 90){
            var = 1;
        }else if (score >= 80){
            var = 2;
        }else if (score >= 60){
            var = 3;
        }
        switch (var){
            case 1:
                System.out.println("爸爸给他卖车");
                break;
            case 2:
                System.out.println("妈妈给买电脑");
                break;
            case 3:
                System.out.println("奶奶给买手机");
                break;
            default:
                System.out.println("没有礼物");
        }

    }
}
