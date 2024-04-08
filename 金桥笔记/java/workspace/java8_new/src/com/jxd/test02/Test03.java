package com.jxd.test02;

import java.util.function.Function;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        Function<String,Integer> function = str -> str.length();

        int lenght = function.apply("java");
        System.out.println(lenght);

        Function<Integer,String[]> function1 = count -> new String[count] ;//{
          /*  String[] strings = new String[count];
            return strings;*/
//        };
        String[] strs = function1.apply(5);
        strs[0] = "java";

        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}
