package com.jxd_homework;

import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/22
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        boolean flag = true;
        System.out.println("我心里有个0到99之间的整数，你猜猜是啥");
        int num= (int)(Math.random()*100);
        Scanner input = new Scanner(System.in);
        int sum = 0;

//        开始循环猜大小

        do {
            int num1 = input.nextInt();
            if (num1 > num){
                System.out.println("大了点，再猜");
            }else if (num1 < num){
                System.out.println("小了点，再猜");
            }else if (num1 == num){
                System.out.println("猜对了！");
                flag = false;
            }
            sum++;
        }while (flag);

//        输出结果

        if (sum == 1){
            System.out.println("你太聪明了");
        }else if (sum >= 6){
            System.out.println("要努力啊");
        }else {
            System.out.println("不错，再接再厉");
        }
    }
}
