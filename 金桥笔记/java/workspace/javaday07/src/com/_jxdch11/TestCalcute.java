package com._jxdch11;

/**
 * @ClassName TestCalcute
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestCalcute {
    public static void main(String[] args) {
//        先创建对象
        Calcute calcute = new Calcute();
        calcute.num1 = 123;
        calcute.num2 = 345;
        calcute.avg();
        int sum = calcute.add();
        System.out.println("求和结果是" + sum);

    }
}
