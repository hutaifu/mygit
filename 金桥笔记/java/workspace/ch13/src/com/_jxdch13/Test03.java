package com._jxdch13;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Test03 {
    public void setStr(String str){
        str = "java";
        System.out.println(str);
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        String str = "hello";
        test03.setStr(str);
        System.out.println(str);
    }
}
