package com.jxdch15;

import java.util.Scanner;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("请输入邮箱");
        String email = input.next();
        int index = email.indexOf("@");
        int index2 = email.indexOf(".");
        if (index >= 0 && index < index2){
            System.out.println("邮箱格式正确,进入下一步");
        }else {
            System.out.println("邮箱格式不正确");
        }
    }
}
