package day03;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入是否是会员：是（y)/否（其他字符）");
        String yes= input.next();
        System.out.println("请输入购物金额：");
        double pre = input.nextDouble();
        double pre1 =0;
        if (yes.equals("y")){
            if (pre >=200){
                 pre1 = 7.5 * pre;
            }else {
                 pre1 = 0.8 * pre;
            }

        }else {
             pre1 = 0.9 * pre;
        }
        System.out.println("实际支付："+pre1);
    }
}
