package com.jxd_homework;

import java.util.Scanner;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/22
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = input.next();
        System.out.println("请输入工资");
        double fee = input.nextDouble();
        System.out.println("请输入加班补贴：");
        double fee1 = input.nextDouble();
        Employee employee = new Employee();
        employee.name = name;
        employee.salary = fee;
        employee.subsidy = fee1;
        employee.getter();
    }
}
