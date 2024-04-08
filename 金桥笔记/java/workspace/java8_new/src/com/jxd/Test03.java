package com.jxd;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        //Lambda 表达式替代 匿名内部类
        //表达式其实就是在实现接口中的抽象方法
        //以 -> 为分隔，左侧代表抽象方法的参数，自定义名称即可
        //右侧代表抽象方法的实现

        MyInterfance myInterfance = str -> str.substring(2,5);
        String str = myInterfance.strHandler("hello");
        System.out.println(str);
    }
}
