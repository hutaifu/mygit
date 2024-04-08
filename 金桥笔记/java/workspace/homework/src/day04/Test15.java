package day04;

import java.util.Scanner;

/**
 * @ClassName Test15
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/14
 * @Version 1.0
 */

public class Test15 {
    public static void main(String[] args) {
        double sum = 0;
        double[] fee = new double[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + i + "笔购物的金额：");
            fee [i] = input.nextDouble();
        }
        System.out.println("序号\t\t金额（元）");
        for (int i = 0; i < 5; i++) {
            System.out.println(i+"\t\t\t" + fee[i]);
            sum += fee[i];
        }
        System.out.println("总金额\t\t" + sum);

    }
}
