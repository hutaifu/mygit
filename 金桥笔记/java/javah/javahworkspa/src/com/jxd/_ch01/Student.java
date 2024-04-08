package com.jxd._ch01;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Student {
    //对象级别的变量，随着对象的创建而申请空间
    String name;
    int age;
    double javaScore;

//    静态变量
//    属于整个类，随着类的加载而申请空间，
    static double avgScore;

    //类级别的方法
    public static void showAvg(){
        System.out.println(avgScore);
        //静态方法中不可以访问普通的变量，因为对象未知
        //System.out.println(javaScore);
        //showScore();
    }

    //普通方法随着对象的创建而加载的
    //必须通过对象.方法的方式进行访问
    //打印的成绩正在调用改方法的对象的成绩
    public void showScore(){
        System.out.println(javaScore);
    }

    public Student(String name){
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int age) {
        this.age = age;
    }



    public Student(){}

    public static void main(String[] args) {
        //对象创建之前类最先加载，同时初始化了静态变量
        Student.avgScore = 30;
        Student.showAvg();

        Student student = new Student();
        Student student1 = new Student(20);
        student1.name = "张三";
        student1.age = 18;
        student1.javaScore = 90;

        //静态对象的访问:通过类名直接访问
        Student.avgScore = 90;
        student1.javaScore = 99;
        System.out.println(student.avgScore);
    }
}
