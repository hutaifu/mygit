package pra01;

import java.util.Scanner;

/**
 * @ClassName input
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("请输入天数");
            if (input.hasNextInt()) {
                int days = input.nextInt();
                System.out.println("输入的天数是" + days);
                break;
            }
            input.next();
        }
    }

}
