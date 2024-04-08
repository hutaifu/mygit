package day09;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Fuirt
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Fuirt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入五种水果名字");
        String[] names = new String[5];
        for (int i = 0; i < names.length; i++) {
            names[i] = input.next();
        }
        Arrays.sort(names);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }


}
