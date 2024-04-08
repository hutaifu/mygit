package day04;

import java.util.Scanner;

/**
 * @ClassName Test18
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入5位会员的积分");
        int[] scores = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("第"+(i+1)+"位会员的积分：");
            scores[i] = input.nextInt();
        }
        System.out.println("序号\t\t历史积分\t\t新年积分");
        for (int i = 0; i < 5; i++) {
            System.out.println((i+1) + "\t\t\t" + scores[i] + "\t\t\t\t" + (scores[i]+500));

        }
    }
}
