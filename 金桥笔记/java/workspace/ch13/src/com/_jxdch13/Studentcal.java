package com._jxdch13;

/**
 * @ClassName Studentcal
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Studentcal {
    public double getAvg(Student student){
        double sum = student.db+ student.html + student.java;
        return sum / 3;

    }

    public static void main(String[] args) {
        Student student = new Student();
        student.java = 90;
        student.html = 92;
        student.db = 100;
        Studentcal studentcal = new Studentcal();
        double ava = studentcal.getAvg(student);
        System.out.println("平均分" +ava);
    }
}
