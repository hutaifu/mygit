package com.jxd.petstore.util;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName INPUT
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class INPUT {
    public static int input(List<Integer> list){
        Scanner input = new Scanner(System.in);
        while (true){
            int s = input.nextInt();
            try {
                for (int num: list) {
                    if (num == s){
                        return s;
                    }
                }
                System.out.println("请重新输入");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static String inputStr(List<String> list){
        Scanner input = new Scanner(System.in);
        while (true){
            String s = input.next();
            try {
                for (String s1: list) {
                    if (s1.equals(s)){
                        return s;
                    }
                }
                System.out.println("请重新输入");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
