package com.jxd.test03;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test04 {
    public static void main(String[] args) {
        String s = "java";
        //将str传递到方法中，返回长度
        Function<String,Integer> function = str -> str.length();
        System.out.println(function.apply(s));

        //将参数传到方法中，利用参数调用方法的场景
        //可以使用类名：：方法名
        Function<String,Integer> function1 = String::length;

        Supplier<Integer> supplier = s::length;
    }
}
