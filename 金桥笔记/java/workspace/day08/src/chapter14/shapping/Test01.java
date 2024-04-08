package chapter14.shapping;

import java.lang.reflect.Member;
import java.util.Scanner;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入会员编号：");
        int num = input.nextInt();
        System.out.println("输入会员积分：");
        int scoers = input.nextInt();
        MemberOpe memberOpe = new MemberOpe();
        Meber meber = new Meber();
        meber = memberOpe.add(num,scoers);
        memberOpe.show(meber);
    }
}
