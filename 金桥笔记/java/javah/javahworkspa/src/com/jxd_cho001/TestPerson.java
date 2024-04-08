package com.jxd_cho001;

import com.jxd._ch01.Penguin;

/**
 * @ClassName TestPerson
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class TestPerson {
    public static void main(String[] args) {
        //加载类，加载静态成员，执行静态初始化块
        Person person = new Person();
        //随着对象的创建而直接执行
        System.out.println(person.getAge());
        Person person1 = new Person();
        //不同的对象创建会多次调用初始化块
    }

}
