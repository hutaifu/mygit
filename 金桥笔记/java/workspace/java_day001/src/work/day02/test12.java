package work.day02;

import java.util.Scanner;

public class test12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数");
        double a = input.nextDouble();
        System.out.println("请输入第二个数");
        double b = input.nextDouble();
        System.out.println("请输入第三个数");
        double c = input.nextDouble();
        if (a < b && a < c){
            if (b<c){
                System.out.println(a+"\t"+b+"\t"+c);
            }else {
                System.out.println(a+"\t"+c+"\t"+b);
        }
    }else {
            if (a > b && a<c){
                System.out.println(b+"\t"+a+"\t"+c);
            }else {
                if(c > b){
                    System.out.println(b+"\t"+c+"\t"+a);
                }else {
                    if (b > c){
                        System.out.println(c+"\t"+a+"\t"+b);
                    }else {
                        System.out.println(c+"\t"+b+"\t"+a);
                    }
                }
            }
        }
}}
