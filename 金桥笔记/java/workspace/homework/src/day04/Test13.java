package day04;

import java.util.Scanner;

/**
 * @ClassName Test13
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/14
 * @Version 1.0
 */

public class Test13 {
    public static void main(String[] args) {
        int num1 = 0;
        double[] nums = new double[10];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("请输入第"+(i+1)+"个数：");
            nums[i] = input.nextDouble();
            if (nums[i] == 1 || nums[i] == 2 || nums[i] == 3){
                num1++;
            }
        }
        System.out.println("合格数个数为：" + num1);
        System.out.println("非法字数个数为" + (10-num1));

    }
}
