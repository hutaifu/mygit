package com.jxd._ch01;

import java.util.Date;

/**
 * @ClassName TestDog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class TestDog {
    public static void main(String[] args) {
        /*Dog dog = new Dog();
        dog.name = "大毛";
        dog.health = 90;
        dog.love = 60;
        dog.type = "金毛";

        dog.showinfor();*/

        //调用构造方法创建对象
        Dog dog = new Dog();
        dog.showinfor();

        Dog dog02 = new Dog();
        dog02.showinfor();

        //用户输入的数据作为属性值，赋予对象

        Dog dog03 = new Dog("三毛","金毛",80,70);
        dog03.showinfor();
    }
}
