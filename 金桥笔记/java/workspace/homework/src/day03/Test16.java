package day03;

import java.util.Scanner;

public class Test16 {
    public static void main(String[] args) {
        int day = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入星期几");
        day = input.nextInt();
        switch (day){
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("WES");
                break;
            case 4:
                System.out.println("THR");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
            case 7:
                System.out.println("SUN");
                break;
            default:
        }
    }
}
