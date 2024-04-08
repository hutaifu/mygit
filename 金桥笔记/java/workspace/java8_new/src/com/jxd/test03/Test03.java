package com.jxd.test03;

import java.util.function.BiFunction;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> biFunction = (x,y) -> Integer.compare(x,y);
        //0   1  -1
        System.out.println(biFunction.apply(10,20));

        //类名：静态方法
        BiFunction<Integer,Integer,Integer> biFunction1 = Integer::compare;
        System.out.println(biFunction1.apply(20,10));
}
}
