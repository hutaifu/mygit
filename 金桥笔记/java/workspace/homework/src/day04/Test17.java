package day04;

import java.util.Scanner;

/**
 * @ClassName Test17
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test17 {
    public static void main(String[] args) {
        double min = 0;
        double[] pre = new double[4];
        Scanner input = new Scanner(System.in);
        System.out.println("请输入4家店的价格");
        for (int i = 0; i < 4; i++) {
            System.out.print("第"+(i+1)+"店的价格：");
            pre[i] = input.nextDouble();
            if (i == 0){
                min = pre[i];
            }else if (pre[i] < min){
                min = pre[i];
            }
        }
        System.out.println("最低价格是：" + min);
    }
}
