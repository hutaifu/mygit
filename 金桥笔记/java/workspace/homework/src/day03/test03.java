package day03;

import java.util.Scanner;

public class test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1.登录系统\n2.退出");
        int ord = input.nextInt();
        switch (ord){
            case 1:
                System.out.println("跳转到主菜单");
                break;
            case 2:
                System.out.println("退出");
                break;
            default:
                System.out.println("重新输入");
        }
    }
}
