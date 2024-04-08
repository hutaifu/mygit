package com.jxd.test03;

import java.util.function.Supplier;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        Emp emp = new Emp("张三",20);
        //共给式接口可以访问同一级别的局部变量
        //getName和接口中的get方法都是无参带返回值的方法
        //可以应用方法引用
        Supplier<String> supplier = () -> emp.getName();
        supplier.get();

        Supplier<String> supplier1 = emp::getName;
        System.out.println(supplier1.get());

        String s = "java";
        Supplier<Integer> supplier2 = () -> s.length();
        Supplier<Integer> supplier3 = s::length;
        supplier2.get();



    }

}
