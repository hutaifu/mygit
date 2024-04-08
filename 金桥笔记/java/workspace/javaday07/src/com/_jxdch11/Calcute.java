package com._jxdch11;

/**
 * @ClassName Calcute
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class Calcute {
    int num1;
    int num2;

    public int add(){
//      sout(num1 + num2)
        int sum = num1 + num2;
//        方法的返回操作
        return sum;
    }
    public void avg(){
//        System.out.println((num1 + num2) / 2);
//        先去执行add（）方法求和
        int sum = add();
        System.out.println("平均值是：" + sum /2.0);
    }
    public  void  show(){
        int num1 = 10;
    }
}
