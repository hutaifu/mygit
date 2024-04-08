package work.day02;

import java.util.Scanner;

public class test09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入a：");
        double a = input.nextDouble();
        System.out.println("请输入b：");
        double b = input.nextDouble();
        if ((a % b == 0) || (a + b >100)){
            System.out.println(a);
        }else {
            System.out.println(b);
        }

    }
}
