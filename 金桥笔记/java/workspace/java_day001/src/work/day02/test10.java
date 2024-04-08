package work.day02;

import java.util.Scanner;

public class test10 {
    public static void main(String[] args) {
        String username = "shl";
        String pwt = "123456";
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username1 = input.next();
        System.out.println("请输入密码：");
        String pwt1 = input.next();
        if ((username.equals(username1)) && (pwt.equals(pwt1))){
            System.out.println("欢迎使用");
        }else {
            System.out.println("对不起用户名密码错误");
        }


    }
}
