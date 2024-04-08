package day04;

import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        int fist = 0;
        String bir = "";
        double score = 0;

        Scanner input = new Scanner(System.in);
        for (int i = 1;i <= 3;i++ ){
            System.out.println("请输入会员号（<4位整数>）：");
            fist = input.nextInt();
            System.out.println("请输入会员生日（月/日<用两位数整数表示>）：");
            bir = input.next();
            System.out.println("请输入会员积分：");
            score = input.nextDouble();
            if (fist >= 1000 && fist <= 9999){
                System.out.println("你输入的会员信息是\n"+fist+"\t"+bir+"\t"+score);
            }else {
                System.out.println("客户号"+fist+"是无效会员号！\n录入信息失败");
            }
        }
    }
}
