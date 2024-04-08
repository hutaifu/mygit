package day02;

import java.util.Scanner;

/**
 * @ClassName TestTriangle02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestTriangle02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Triangle02 triangle02 = new Triangle02();
        System.out.println("请输入三边长度：");
        triangle02.a = input.nextDouble();
        triangle02.b = input.nextDouble();
        triangle02.c = input.nextDouble();
        triangle02.isTriangle();
    }
}
