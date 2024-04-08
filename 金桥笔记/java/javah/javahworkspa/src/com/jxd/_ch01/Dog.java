package com.jxd._ch01;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Dog {
    String name;
    String type;
    int health;
    int love;



    public  void showinfor(){
        System.out.println("昵称是" + name);
        System.out.println("品种是" + type);
        System.out.println("健康值是"+ health);
        System.out.println("亲密度是" + love);
    }

    //构造方法，创建对象的同时给属性赋初值。
    public Dog(){
        name = "二毛";
        type = "金毛";
        health = 180;
        love = 50;
    }

    //带参数的构造方法
    public Dog(String name,String type,int health,int love){
        this.name = name;
        this.type = type;
        if (health > 0 && health <= 100) {
            this.health = health;
        }else {
            this.health = 60;
        }
        this.love = love;
    }

   /* public Dog(String name){
        this.name = name;
    }

    public Dog(String type){
        this.type = type;
    }*/
}
