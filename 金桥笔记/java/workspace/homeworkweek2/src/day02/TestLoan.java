package day02;

import java.util.Scanner;

/**
 * @ClassName TestLoan
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestLoan {
    public static void main(String[] args) {
        Loan loan = new Loan();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入贷款数目：");
        int num = input.nextInt();
        System.out.println("请输入贷款年限：");
        int age = input.nextInt();
        loan.show(num,age);
    }
}
