package day02;

import java.util.Scanner;

/**
 * @ClassName TestAccout
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestAccout {
    public static void main(String[] args) {
        boolean issue = true;
        Scanner input = new Scanner(System.in);
        Accout accout = new Accout();
        do {
            System.out.println("1.存款2.取款0.退出");
            System.out.println("请选择你要办理的业务");
            int num = input.nextInt();
            switch (num){
                case 1:
                    System.out.println("请输入存款金额：");
                    double num1 = input.nextDouble();
                    accout.add(num1);
                    break;
                case 2:
                    System.out.println("请输入取款金额:");
                    double num2 = input.nextDouble();
                    accout.get(num2);
                    break;
                case 0:
                    accout.exit();
                    issue = false;
            }
        }while (issue);
    }
}
