package com_jxdch10;

import java.util.Scanner;

/**
 * @ClassName TestVisitor
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class TestVisitor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            Visitor visitor = new Visitor();
//            创建类对象时必定要保证现实中一定要保证真实存在那个对象
            System.out.println("请输入姓名：");
            visitor.name = input.next();
            if (visitor.name.equals("n")){
                break;
            }
            System.out.println("请输入年龄：");
            visitor.age = input.nextInt();
            visitor.show();
        }while (true);
        System.out.println("退出程序");
    }
}
