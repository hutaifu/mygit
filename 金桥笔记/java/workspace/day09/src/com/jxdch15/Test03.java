package com.jxdch15;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        String today = "2022/7/21";
//        2022-7-21
        String[] strings = today.split("/");
        System.out.println(strings[0]+"-"+strings[1]+"-"+strings[2]);
    }
}
