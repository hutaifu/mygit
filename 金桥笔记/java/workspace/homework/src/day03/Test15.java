package day03;

import java.util.Scanner;

public class Test15 {
    public static void main(String[] args) {
        int most = 0;
        int lit = 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个整数");
        num1 = input.nextInt();
        System.out.println("请输入第二个整数");
        num2 = input.nextInt();
        System.out.println("请输入第三个整数");
        num3 = input.nextInt();
        if (num1>num2){
            most = num1;
            lit = num2;
        }else {
            most = num2;
            lit = num1;
        }
        if (num3 > most){
            most = num3;
            System.out.println(most);
            System.out.println(lit);
        }else if(num3 < lit){
            lit = num3;
            System.out.println(most);
            System.out.println(lit);
        }else{
            System.out.println(most);
            System.out.println(lit);
        }


    }
}
