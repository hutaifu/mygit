package day09;

import java.util.Scanner;

/**
 * @ClassName Birthpwt
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Birthpwt {
    public static void main(String[] args) {
        boolean is = true;
        System.out.println("请输入生日：");
        Scanner input = new Scanner(System.in);
        String bir = input.next();
        System.out.println("请输入密码：");
        String pwt = input.next();
        if (bir.indexOf("/") != 2 || bir.lastIndexOf("/") !=8 || bir.indexOf(":") != 5) {
            System.out.println("会员生日格式为<月/日:00/00>");
            is = false;
        }
        if (pwt.length() < 6 || pwt.length() >10){
            System.out.println("会员密码为<6~10位>");
            is =false;
        }
        if (is){
            System.out.println("信息有效");
        }



    }
}
