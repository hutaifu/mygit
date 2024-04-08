package com_jxdch10;

/**
 * @ClassName TestStu
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class TestStu {
    public static void main(String[] args) {
//        创建对象：对应实际问题中的一个具体的学生
        Student student01 = new Student();
//        给对象的属性赋值
        student01.name = "张三";
        student01.age = 20;
        student01.sex = '男';
        student01.address = "山东济南";
        System.out.println(student01.name);
//        方法的调用
//        自我介绍
        student01.showInfo();
//        创建其他的对象
        Student student02 = new Student();
        student02.name = "李四";
        student02.sex = '男';
        student02.address = "山东青岛";
        student02.age = 20;
        student02.showInfo();
    }
}
