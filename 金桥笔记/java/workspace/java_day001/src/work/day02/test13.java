package work.day02;

import java.util.Scanner;

public class test13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数：");
        double num = input.nextDouble();
        if ((num % 3 == 0) || (num % 5 == 0)){
            System.out.println("能被3或者5整除");
        }else {
            System.out.println("不能别3或者5整除");
        }
    }
}
