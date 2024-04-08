package day05;

import java.util.Scanner;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test04 {
    public static void main(String[] args) {
        int rows = 0;
        System.out.println("从控制台输入直角三角形的高度:");
        Scanner input = new Scanner(System.in);
        rows = input.nextInt();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 2 * i +1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
