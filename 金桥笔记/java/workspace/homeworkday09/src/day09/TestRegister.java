package day09;

import java.util.Scanner;

/**
 * @ClassName TestRegister
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class TestRegister {
    public static void main(String[] args) {
        boolean issucee = false;
        Register register = new Register();
        System.out.println("***欢迎进入注册系统***");
        System.out.println();
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("请输入用户名：");
            String name = input.next();
            System.out.println("请输入密码：");
            String pwt1 = input.next();
            System.out.println("请再次输入密码：");
            String pwt2 = input.next();
            issucee = register.verify(name,pwt1,pwt2);
        }while (!issucee);

    }
}
