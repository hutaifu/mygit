package ch006;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数");
        int num = input.nextInt();

        for (int i = 0,j= num; i <= num; i++,j--) {
            System.out.println(i+ "+" +j+ "=" + num);
        }
    }
}
