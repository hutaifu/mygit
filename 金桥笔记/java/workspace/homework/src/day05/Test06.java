package day05;

import java.util.Scanner;

/**
 * @ClassName Test06
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test06 {
    public static void main(String[] args) {
        int rows = 2;
        Scanner input = new Scanner(System.in);
        System.out.println("请菱形输入行数：");
        rows = input.nextInt();
        while (rows % 2.0 == 0) {
            System.out.println("请输入奇数：");
            rows = input.nextInt();
        }
        int harows = (rows- 1) / 2;
        for (int i = 0; i < harows; i++) {
            for (int j = 0; j < harows+i+1; j++) {
                if (j < harows-i) {
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < rows; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < harows; i++) {
            for (int j = 0; j < 2 * harows-i; j++) {
                if (j <= i){
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();

        }





    }
}
