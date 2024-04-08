package chapter14.shapping;

import java.util.Scanner;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        MemberOpe memberOpe = new MemberOpe();
        Meber[] mebers= new Meber[4];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < mebers.length; i++) {
            System.out.println("输入会员编号：");
            int num = input.nextInt();
            System.out.println("输入会员积分：");
            int scoers = input.nextInt();
            mebers[i] = memberOpe.add(num,scoers);
        }
        System.out.println("***会员列表**8");
        System.out.println("编号\t\t\t积分");
        for (int i = 0; i < mebers.length; i++) {
            System.out.println(mebers[i].num+"\t\t\t"+mebers[i].socres);
        }
        System.out.println("请输入要查找的会员编号：");
        int num1 = input.nextInt();
        System.out.println("该会员积分为" + memberOpe.found(num1,mebers));
    }
}
