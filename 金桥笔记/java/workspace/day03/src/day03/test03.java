package day03;

import java.util.Scanner;

public class test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入存款(万）：");
        double dol = input.nextDouble();

        if (dol > 500){
            System.out.println("买迪拉克");
        }else if(dol > 100){
            System.out.println("买帕萨特");
        }else if(dol > 50){
            System.out.println("买伊兰特");
        }else if(dol > 10){
            System.out.println("买奥托");
        }else {
            System.out.println("买捷安特");
        }

    }
}
