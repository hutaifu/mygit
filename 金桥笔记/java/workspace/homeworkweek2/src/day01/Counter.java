package day01;

import java.util.Scanner;

/**
 * @ClassName Counter
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class Counter {
    double a;
    double b;
    char oper;
    public void run(){
        switch (oper){
            case '+':
                System.out.println(a+b);
                break;
            case '-':
                System.out.println(a-b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
            default:
                System.out.println("错误");
        }
    }


}
