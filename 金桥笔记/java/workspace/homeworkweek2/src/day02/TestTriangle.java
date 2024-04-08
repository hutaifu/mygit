package day02;

import java.util.Scanner;

/**
 * @ClassName TestTriangle
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入行高");
        triangle.rows = input.nextInt();
        System.out.println("请输入打印的字符");
        triangle.string = input.next();
        triangle.show();
    }
}
