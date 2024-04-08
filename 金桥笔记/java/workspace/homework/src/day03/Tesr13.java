package day03;

import java.util.Scanner;

public class Tesr13 {
    public static void main(String[] args) {
        int pan = 0;
        int ord = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请选择，输入数字：");
        do {
            if (input.hasNextInt()){
                ord = input.nextInt();
                pan = 1;
            }else {
                input.nextInt();
                System.out.println("输入错误,请重新输入数字：");
            }
        }while (pan != 1);
        System.out.println("执行购物结算");

    }
}
