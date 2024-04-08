package day02;

import day01.Customer;

import java.util.Scanner;

/**
 * @ClassName TestCustomerBiz
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestCustomerBiz {
    public static void main(String[] args) {
        String choic ="";
        CustomerBiz customerBiz = new CustomerBiz();
        Scanner input= new Scanner(System.in);
        do {
            System.out.println("请输入客户的姓名：");
            String name = input.next();
            customerBiz.addName(name);
            System.out.println("继续输入吗（y/n）？");
            choic = input.next();
        }while (choic.equals("y"));
        customerBiz.showNames();

    }
}
