package com._jxdch13;

import java.util.Scanner;

/**
 * @ClassName Heightcal
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Heightcal {
    public double getavg(Student[] students){
        double sum = 0.0;
        double avg = 0.0;
        for (int i = 0; i < students.length; i++) {

            sum += students[i].height;

        }
        avg= sum /students.length;
        return avg;

    }
    public void  show(Student student){
        System.out.println(student.height);
    }

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        Student[] stus = new Student[5];
        for (int i = 0; i < stus.length; i++) {
            Student student = new Student();
            System.out.println("请输入身高");
            student.height = input.nextDouble();
//            将学生赋给数组
            stus[i] = student;
        }
        Heightcal heightcal = new Heightcal();
        double avg = heightcal.getavg(stus);
        System.out.println("平均身高是" + avg);
    }
}
