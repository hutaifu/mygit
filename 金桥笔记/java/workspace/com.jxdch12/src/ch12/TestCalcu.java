package ch12;

import java.util.Scanner;

/**
 * @ClassName TestCalcu
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestCalcu {
    public static void main(String[] args) {
        Calcu calcu = new Calcu();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入两个操作数：");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int sum = calcu.add(num1,num2);
        System.out.println("求和结果是"+ sum);
    }
}
