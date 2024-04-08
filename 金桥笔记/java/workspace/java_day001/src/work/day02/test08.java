package work.day02;

import java.util.Scanner;

public class test08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入会员号{<4位整数>}");
        int num = input.nextInt();

        System.out.println("请输入会员生日(月/日《用两位数表示)：");
        String bir = input.next();
        System.out.println("请输入积分：");
        double score = input.nextDouble();
        System.out.println("已录入的会员信息是：");
        if (num >=1000 && num<=9999){
            System.out.println(num+"\t"+bir+"\t"+score);
        }else {
            System.out.println("会员号错误");
        }


    }
}
