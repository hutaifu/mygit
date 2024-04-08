package day03;

import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        String choose ="";
        int ord = 0;
        System.out.println("请选择购买商品编号：\n1.T恤\t2.网球鞋\t3.网球拍");
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入商品编号：");
            ord = input.nextInt();
            switch (ord){
                case 1:
                    System.out.println("T恤\t￥245.0");
                    break;
                case 2:
                    System.out.println("网球鞋\t￥570.0");
                    break;
                case 3:
                    System.out.println("网球拍\t￥150.0");
                    break;
                default:
                    System.out.println("错误");
            }
            System.out.println("是否继续（y/n）:");
            choose = input.next();
        }while ("y".equals(choose));

    }
}
