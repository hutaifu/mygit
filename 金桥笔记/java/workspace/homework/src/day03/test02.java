package day03;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入会员积分：");
        double scores = input.nextDouble();
        System.out.println("该会员享受的折扣是：");
        if (scores < 2000){
            System.out.println("0.9");
        }else if (scores >= 2000 && scores <= 4000 ){
            System.out.println("0.8");
        }else if (scores >=4000 && scores < 8000){
            System.out.println("0.7");
        }else if (scores >= 8000){
            System.out.println("0.6");
        }
    }
}
