package com._jxdch13;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Test04 {
//    求num的阶乘
//    f(n)用于求n的阶乘，n+1的阶乘f(n+1) = f(n) * (n+1)
    public int fact(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        return fact(n-1) * n;

    }

    public static void main(String[] args) {
        Test04 test04 = new Test04();
        int num = test04.fact(2);
    }
}
