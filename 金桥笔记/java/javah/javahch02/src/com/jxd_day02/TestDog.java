package com.jxd_day02;

import java.util.Date;

/**
 * @ClassName TestDog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class TestDog {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("旺财");
        dog.setType("金毛");
        dog.setHealth(90);
        dog.setLove(70);
        System.out.println(dog.getName());
    }
}
