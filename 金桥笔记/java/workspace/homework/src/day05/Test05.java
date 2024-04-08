package day05;

import java.util.Scanner;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入直角三角形的行数：");
        int rows = input.nextInt();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
