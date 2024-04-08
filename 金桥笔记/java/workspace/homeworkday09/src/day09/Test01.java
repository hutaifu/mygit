package day09;

import java.util.Scanner;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        Good good = new Good();
        good.names[0] = "电风扇";
        good.names[1] = "洗衣机";
        good.names[2] = "电视机";
        good.names[3] = "冰箱";
        good.names[4] = "空调机";
        good.fee[0] = 124.23;
        good.fee[1] = 4500.0;
        good.fee[2] = 8800.9;
        good.fee[3] = 5000.88;
        good.fee[4] = 4456.0;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名；");
        String name = input.next();
        System.out.println("请输入密码：");
        String pwt = input.next();
        if (pwt.equals("123") && name.equals("TOM")){
            System.out.println("登录成功！");
            good.show();
            System.out.println("****************************");
            System.out.println("请输入你批发的商品编号：");
            int num = input.nextInt();
            System.out.println("请输入批发数量：");
            int num1 = input.nextInt();
            good.change(num,num1);



        }

    }
}
