package ch05prc01;

import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入1到3之间一个整数：");
        try {
            int num = input.nextInt();
            switch (num){
                case 1:
                    System.out.println("htmll");
                    break;
                case 2:
                    System.out.println("java");
                case 3:
                    System.out.println("oracle");
                default:
                    System.out.println("输入不符合要求");
            }
        }catch (Exception e){
            System.out.println("输入错误");
            e.printStackTrace();
        } finally {
            System.out.println("欢迎提出建议！");
        }
    }
}
