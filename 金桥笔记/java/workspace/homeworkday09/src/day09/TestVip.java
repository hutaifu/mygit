package day09;

import java.util.Scanner;

/**
 * @ClassName TestVip
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class TestVip {
    public static void main(String[] args) {
        Vip vip = new Vip();
        Scanner input = new Scanner(System.in);
        boolean issuecc = true;

        System.out.println("***欢迎进入注册系统***\n");
        do {
            System.out.println("请输入身份证：");
            String id = input.next();
            System.out.println("请输入手机号；");
            String phonum = input.next();
            System.out.println("请输入座机号");
            String localnum = input.next();
            issuecc = vip.firm(id,phonum,localnum);
        }while (!issuecc);
        System.out.println("注册成功！");
    }
}
