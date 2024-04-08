package day03;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        double extafee = 0;
        double truefee = 0;
        double fee = 0;
        int num = 0;
        int sum = 0;
        String choose ="";
        int ord = 0;
        System.out.println("请选择购买商品编号：\n1.T恤\t2.网球鞋\t3.网球拍");
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入商品编号：");
            ord = input.nextInt();
            System.out.println("请输入购买数量");
            num = input.nextInt();
            switch (ord){
                case 1:
                    sum += num * 245;
                    System.out.println("T恤\t￥245.0\t数量"+num+"\t合计￥"+sum);
                    break;
                case 2:
                    sum += num * 570;
                    System.out.println("网球鞋\t￥570.0\t数量"+num+"\t合计￥"+sum);
                    break;
                case 3:
                    sum += num * 150;
                    System.out.println("网球拍\t￥150.0\t数量"+num+"\t合计￥"+sum);
                    break;
                default:
                    System.out.println("错误");
            }
            System.out.println("是否继续（y/n）:");
            choose = input.next();
        }while ("y".equals(choose));
        System.out.println();
        System.out.println("折扣：0.8");
        fee = sum * 0.8;
        System.out.println("应付金额："+fee);
        Scanner input = new Scanner(System.in);
        System.out.println("实付金额：");
        truefee = input.nextDouble();
        extafee = truefee - fee;
        System.out.println("找钱："+extafee);



    }
}
