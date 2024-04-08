package com.jxd;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test05 {
    public static void main(String[] args) {
        MyInerface03 myInerface03 = (num1, num2) -> {
            int sum = num1 + num2;
            System.out.println(sum);
        };
        myInerface03.add(10,20);
    }
}
