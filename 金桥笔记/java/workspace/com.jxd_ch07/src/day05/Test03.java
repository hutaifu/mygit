package day05;

import java.util.Scanner;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        int totalCoun = 0;
        int shopCount = 5;
        int  clothCount = 3;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < shopCount; i++) {
            System.out.println("欢迎光临第"+(i+1)+"家店");
            for (int j = 0; j < clothCount; j++) {
                System.out.println("要离开吗？");
                String answer = input.next();
                if ("y".equals(answer)){
                    System.out.println("离开 这家店");
                    break;
                }
                totalCoun ++;
                System.out.println("买了一件衣服");
            }


        }
        System.out.println("总共买了" + totalCoun + "件衣服");
    }
}
