package com.jxd.bookmanger.util;

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
}
