package com.jxd.ch02;

public class test03 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 2;
//        申请空间存储和
        int sum = num1 + num2;
        System.out.println("求和结果是" + sum);
        System.out.println("求和结果是" + (num1+ num2));
        int num3 =8;
        int num4 =3;
//        两个整数相除，结果仍然是整数，只保留商
        int num5 = num3 / num4;
        System.out.println("除法结果是" + num3 / num4);
//取余
        int num6 = num3 % num4;
        System.out.println("余数是" + num6);
        System.out.println(-10%3);//余数是-1
        double d1 = 9.0;
        double d2 = 2;
        System.out.println(d1  /d2);

    }
}
