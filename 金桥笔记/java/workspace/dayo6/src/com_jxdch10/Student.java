package com_jxdch10;

/**
 * @ClassName Student
 * @Description 在类中规定学生对象应具有的属性和方法
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class Student {
//属性;我们关注的学生属性
    String name;
    char sex;
    int age;
    String address;
//    方法:学生所具备的技能
    public void showInfo(){
        System.out.println("姓名是"+name);
        System.out.println("性别是"+sex);
        System.out.println("年龄是"+age);
        System.out.println("籍贯是"+address);
    }

}
