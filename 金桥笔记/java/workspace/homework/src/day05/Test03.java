package day05;

import java.util.Scanner;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        boolean is = true;
        int fee = 0;
        String password = "111111";
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入密码：");
            if (password.equals(input.next())){
                System.out.println("请输入金额：");
                while (is){
                    fee = input.nextInt();
                    if(fee > 0 && fee <= 10000 && fee % 100.0 == 0){
                        System.out.println("交易完成");
                        is = false;
                    }else {
                        System.out.println("请重新输入金额：");
                    }
                }
            }else if (i == 2){
                System.out.println("密码错误，请取卡。");
            }
            if (!is){
                break;
            }

        }
    }
}
