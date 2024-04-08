package com._jxdch13;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
//        创建了一个字符串对象
        String s1 = "hello";
        String s2 = new String("java");
        String s3 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
