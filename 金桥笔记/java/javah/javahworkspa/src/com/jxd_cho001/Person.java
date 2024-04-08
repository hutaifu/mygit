package com.jxd_cho001;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Person {
    private String name;
    private int age;
    static double avgAge;

    //初始化块：对构造方法的补充，用于完善对象的初始化
    {//随着对象的加载而加载执行
        age =1;
        System.out.println(name);
    }

    static {//静态初始化块
        //不能访问普通变量，但是可以访问静态变量
        System.out.println(avgAge);
    }

    {//初始化块可以有多个，从上往下依此执行
        System.out.println(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }


}
