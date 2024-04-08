package com.jxd.test03;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test05 {
    public static void main(String[] args) {
        Supplier<Emp> supplier = () -> new Emp();
        Emp emp = supplier.get();

        //调用无参构造方法
        Supplier<Emp> supplier1 = Emp::new;
        BiFunction<String,Integer,Emp> biFunction = (name,age) -> new Emp(name,age);
        biFunction.apply("张三",20);

        BiFunction<String,Integer,Emp> biFunction1 = Emp::new;
        Emp emp1 = biFunction1.apply("张三",20);

        Function<Integer,String[]> function = count -> new String[count];
        Function<Integer,String[]> function1 = String[] ::new;
        //返回长度为5的字符串数组
        String[] strs = function1.apply(5);
    }
}
