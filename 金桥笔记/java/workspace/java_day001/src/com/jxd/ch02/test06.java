package com.jxd.ch02;

public class test06 {
    public static void main(String[] args) {
        int num1 = 10;
        double num2 = num1;
//        自动类型转换,小范围转大范围
        float num3 = num1;
        System.out.println(num1/1.0);
//        当表达式中有一个是double类型，那么结果将会提升为一个double类型
        int num4 = 8;
        System.out.println(1.0 * num4 / 3.0);
        double num5 = 1;
        int num6 = (int)num5;
        String str = "123";
        byte b1 = 1;
//      运算结果必须使用int类型变量接受
        int num = b1 +1;
        char c1 = 'a';
        int numc = c1 +1;
//
        b1++; //b1 =b1 +1
        c1 +=1;
//        没有显示作为参数






    }
}
