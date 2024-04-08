package day04;

import java.text.NumberFormat;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        int num = 0;
        int age = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0;i < 10;i++){
            System.out.println("请输入第"+(i+1)+"位顾客的年龄：");
            age = input.nextInt();
            if (age > 30){
                num++;
            }

        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result1 = numberFormat.format((float) num / (float) 10 * 100);
        String result2 = numberFormat.format((10 - num)/ (float) 10 * 100);
        System.out.println("30岁以上的比例是：" + result1 + "%");
        System.out.println("30岁以下的比例是：" + result2 + "%");

    }
}
