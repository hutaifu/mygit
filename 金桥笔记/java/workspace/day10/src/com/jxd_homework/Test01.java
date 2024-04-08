package com.jxd_homework;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/22
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        Numlist numlist = new Numlist();

//        输出前十个数字

        System.out.println("前是个数是");
        for (int i = 0; i < 10; i++) {
            System.out.println(numlist.getnumlist(i));
        }

    }
}
