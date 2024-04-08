package com.jxd_ch05;

/**
 * @ClassName TestStu
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class TestStu {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("张三");
        try {
            stu.setSex("男生");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
