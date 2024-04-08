package com.jxd.test02;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test01 {
    public static void show(int money,Consumer<Integer> consumer){
        consumer.accept(money);
    }

    public static void main(String[] args) {
        //消费型函数式接口，提供accept方法，要求有参数，但是没有返回值
        //我们定义的泛型是什么类型，那么accept方法就接收什么类型参数
      /*  Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("hello");*/
      Consumer<Integer> consumer = money -> System.out.println("花费了" + money + "元");
      show(1000,consumer);

    }
}
