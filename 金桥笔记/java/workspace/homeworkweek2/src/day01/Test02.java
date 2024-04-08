package day01;

import java.util.Scanner;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        String pwt2 ="";
        String pwt3 = "";
        Administrator aimin1 = new Administrator();
        aimin1.name = "admin1";
        aimin1.pwt = "111111";
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name1 = input.next();
        System.out.println("请输入密码：");
        String pwt1 = input.next();
        if (name1.equals(aimin1.name) && pwt1.equals(aimin1.pwt)) {
            do {
                System.out.println("请输入新密码：");
                pwt2 = input.next();
                System.out.println("请再次输入新密码：");
                pwt3 = input.next();
                if (!pwt2.equals(pwt3)){
                    System.out.println("你再次输入的密码不一致，请重新输入！");
                }
            }while (!(pwt2.equals(pwt3)));
        }
        aimin1.pwt = pwt2;
    }
}
