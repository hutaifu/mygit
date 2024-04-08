package com.jxd.test02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test02 {
    public static List<Integer> integerList(int num,Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        //向集合中存放随机数，存放num个
        //随机数通过supplier对象获得
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;

    }
    public static void main(String[] args) {
        //供给型接口，get方法无参，但是有返回值
       /* Supplier<String> stringSupplier = () -> "java" + Math.random();
        String str = stringSupplier.get();

        Supplier<Integer> integerSupplier = () -> 1+2;
        System.out.println(integerSupplier.get());*/

       Supplier<Integer> supplier = () -> (int)(Math.random() * 100);
       List<Integer> list = integerList(10,supplier);

       for (Integer integer : list){
           System.out.println(integer);
       }
    }
}
