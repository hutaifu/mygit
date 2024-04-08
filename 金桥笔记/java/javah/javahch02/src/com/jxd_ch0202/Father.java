package com.jxd_ch0202;

/**
 * @ClassName Father
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Father {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Father() {
        System.out.println("这是父类的无参构造");
    }

    public Father(int age) {
        this.age = age;
        System.out.println("父类的带参构造");
    }
}
