package ch05;

import java.util.Scanner;

public class test04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer ="";
        do {
            System.out.println("上午学习理论，下午上机编程");
            System.out.println("合格了吗（y/n）");
            answer = input.next();
        } while (!"y".equals(answer));
//        循环结束
        System.out.println("完成学习任务");
    }
}
