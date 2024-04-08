package day02;

/**
 * @ClassName Calculator
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class Calculator {
    double num1;
    double num2;
    public double get(char coun){
        switch (coun){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                System.out.println("错误");
                return 0.0;
        }
    }
}
