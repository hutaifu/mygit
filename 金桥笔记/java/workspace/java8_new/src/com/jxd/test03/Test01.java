package com.jxd.test03;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        Consumer<String> consumer = str -> System.out.println(str);


        //方法应用形式:println方法和抽象方法accept方法都是有参数没有返回值
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;
        Consumer<String> consumer2 = System.out::println;
        consumer1.accept("hello");
        //length方法是无参带返回值，接口中apply方法是带参带返回值



        Function<String,Integer> function = str -> str.length();






    }
}
