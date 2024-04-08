package day03;

import java.util.Scanner;

public class test06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入张三的名次：");
        int ranking = input.nextInt();

        switch (ranking){
            case 1:
                System.out.println("参加夏令营");
                break;//跳出当前判断
            case 2:
                System.out.println("奖励一个笔记本电脑");
                break;
            case 3:
                System.out.println("奖励一个移动硬盘");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("纪念奖");
                break;
            default:
                System.out.println("没有奖励");
        }
    }
}
