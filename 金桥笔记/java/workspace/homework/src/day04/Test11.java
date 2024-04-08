package day04;

import java.util.Scanner;

/**
 * @ClassName Test11
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/14
 * @Version 1.0
 */

public class Test11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] line = new String[5];
        for (int i = 0; i < line.length; i++) {
            line[i] = input.nextLine();
        }
        for (int i = line.length-1; i >= 0; i--) {
            System.out.println(line[i]);

        }
    }
}
