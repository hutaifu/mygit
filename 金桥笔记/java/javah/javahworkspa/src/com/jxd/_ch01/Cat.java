package com.jxd._ch01;

import java.util.Arrays;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Cat {
    String name;
    String type;
    int health;

    public Cat() {
    }

    public Cat(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
    }

    public void  eat(){
        System.out.println("没有任何食物");
    }

    public void  eat(String food){
        System.out.println(name + "可以吃这个" + food);
    }

    public void eat(double money){
        System.out.println("可以花钱买猫粮");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "猫宁";


        cat.eat(19);
        cat.eat();
        cat.eat("");

        //java提供的重载
        String str = "hello";
        str.substring(1);
        str.substring(1,3);//左闭右开

//        Arrays.sort();

    }

}
