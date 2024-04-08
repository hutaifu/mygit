package day04;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        String name = "无名";
        String pwt = "371452986";
        String name1 = "";
        String pwt1 = "";
        Scanner input = new Scanner(System.in);
        for (int i = 1;i <= 3;i++){
            System.out.println("请输入用户名：");
            name1 = input.next();
            System.out.println("请输入密码：");
            pwt1 = input.next();
            if (name.equals(name1) && pwt.equals(pwt1)){
                System.out.println("欢迎登录系统");
                break;
            }else {
                System.out.println("输入错误，你还有"+(3 - i)+"次机会");
            }
            if (i == 3){
                System.out.println("对不起，你三次输入均错误！");
            }

        }




    }
}
