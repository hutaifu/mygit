package com_jxdch10;

/**
 * @ClassName TestSchool
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class TestSchool {
    public static void main(String[] args) {
        School school01 = new School();
        school01.name = "实验一小";
        school01.classroomcount = 32;
        school01.labCount = 10;
        school01.showInfo();

        School school02 = new School();
//        每个对象的属性有初值
//        String 为null
//        int 为0
//        double为0.0
//        booleam 为false
        school02.showInfo();
    }
}
