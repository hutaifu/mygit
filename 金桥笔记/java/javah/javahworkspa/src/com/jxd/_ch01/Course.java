package com.jxd._ch01;

/**
 * @ClassName Course
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Course {
    int courseno;
    String coursename;
    String remark;

    public Course() {
    }

    public Course(String coursename) {
        this();
        this.coursename = coursename;
    }

    public Course(int courseno, String coursename, String remark) {
        //调用其他的构造方法
        this(coursename);//必须放在第一句
        this.courseno = courseno;
        this.remark = remark;
    }

    public static void main(String[] args) {
        //只会创建一个对象
        Course course = new Course(1,"java","基础");
    }
}
