package com.jxd_cho001;

/**
 * @ClassName TestDog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class TestDog {
    public static void main(String[] args) {
        Dog dog = new Dog();

//        dog.health = 80;

        dog.setName("大毛");
        System.out.println(dog.getName());

        Dog dog1 = new Dog("大旺","拉布拉多",666,20);
    }
}
