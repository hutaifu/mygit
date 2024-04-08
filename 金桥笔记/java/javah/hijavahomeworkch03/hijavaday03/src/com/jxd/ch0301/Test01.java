package com.jxd.ch0301;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        int num = 10;
        Integer num01 = 10;
        //自动装箱，将int转换为integer
        num01.compareTo(num);
         //自动拆箱，将Integer 转换为int
        int num02= num01;

        if (num01 instanceof Object){

        }

        String str = "123";
        int  num03 = Integer.parseInt(str);
        double num04 = Double.parseDouble(str);
    }
}
