package day06;

import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        Random random = new Random();
        String name = "";
        String pwt = "";
        int max = 10000;
        int min = 1000;
        boolean isSccess = false;
        String con = "y";
        int opt = 0;
        Scanner input = new Scanner(System.in);
        do{
        for (int i = 0; i < 5; i++) {
            System.out.print("*");
        }
        System.out.print("欢迎进入将客富翁系统");
        for (int i = 0; i < 5; i++) {
            System.out.print("*");
        }
            System.out.println();
            System.out.println("1.注册\n2.登录\n3.抽奖");
            for (int j = 0; j < 30; j++) {
                System.out.print("*");
            }
                System.out.println();
                System.out.println("请选择菜单：");
                opt = input.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("奖客富翁系统 > 注册");
                        System.out.println("请填写个人注册信息");
                        System.out.println("用户名：");
                        name = input.next();
                        System.out.println("密码：");
                        pwt = input.next();
                        System.out.println();
                        isSccess = true;
                        int rew = (random.nextInt(max - min) + min + 1);
                        if (isSccess){
                            System.out.println("注册成功，请记好你的会员卡号");
                            System.out.println("用户名\t\t密码\t\t会员卡号");
                            System.out.println(name+"\t\t"+pwt+"\t\t\t"+rew);
                        }
                        break;
                    case 2:
                        System.out.println("奖客富翁系统 > 登录");
                        for (int i = 0; i < 3; i++) {
                            boolean isReg = false;
                            System.out.println("请输入用户名：");
                            String name1 = input.next();
                            System.out.println("请输入密码：");
                            String pwt1 = input.next();
                            if (name.equals(name1) && pwt.equals(pwt1)){
                                System.out.println("欢迎你："+name);
                                isReg = true;
                                break;
                            }else if (!isReg && i != 2){
                                System.out.println("请继续输入密码");
                            }else {
                                System.out.println("机会已用完");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("奖客富翁系统 > 抽奖");
                        System.out.println("请输入你的卡号：");
                        int num = input.nextInt();
                        int luky1 = random.nextInt(random.nextInt(max - min) + min + 1);
                        int luky2 = random.nextInt(random.nextInt(max - min) + min + 1);
                        int luky3 = random.nextInt(random.nextInt(max - min) + min + 1);
                        int luky4 = random.nextInt(random.nextInt(max - min) + min + 1);
                        if (num == luky1 || num == luky2 || num == luky3 || num == luky4){
                            System.out.println("恭喜！你成为本日幸运会员！");
                        }else {
                            System.out.println("抱歉！你不是本日的幸运会员！");
                        }
                        break;
                    default:
                        System.out.println("你的输入有误");
                }
                System.out.println("继续吗？（y/n）:");
                con = input.next();
        }while ( "y".equals(con));
        System.out.println("系统退出，谢谢使用！");
        System.exit(0);
    }
}

