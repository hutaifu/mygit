package day02;

import java.util.Scanner;

/**
 * @ClassName TestCalculator
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数");
        calculator.num1 = input.nextDouble();
        System.out.println("请输入运算方式");
        char coun = input.next().charAt(0);
        System.out.println("请输入第二个数");
        calculator.num2 = input.nextDouble();
        System.out.println(calculator.get(coun));
    }
}
