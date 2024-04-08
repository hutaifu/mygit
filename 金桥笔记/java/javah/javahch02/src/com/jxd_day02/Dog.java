package com.jxd_day02;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Dog extends Pet {
    //会从父类中继承属性和方法
    private String type;

    public String getType() {
        return type;
    }

    public String gettype(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Dog(){}

    public Dog(String name, String type, int health, int love) {
        //如何给父类继承过来的属性赋值
        this.type = type;

    }

    public void showinfo(){
        //可以直接访问父类中继承的属性和方法（私有除外）
        System.out.println("昵称是" + super.getName());
        System.out.println("品种是" + this.gettype());
        System.out.println("健康值是" + super.getHealth());
        System.out.println("年龄是" + super.age);
    }
}