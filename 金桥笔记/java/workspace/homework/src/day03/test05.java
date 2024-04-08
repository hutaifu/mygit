package day03;

import java.util.Scanner;

public class test05 {
    public static void main(String[] args) {
        double mofee = 0;
        String change = "";
        Scanner input = new Scanner(System.in);
        System.out.println("请输入消费金额：");
        double fee = input.nextDouble();
        System.out.println("是否参加优惠换购活动：\n1:满50元。加2元换购百事可乐饮料1瓶");
        System.out.println("2:满100元，加3元换购500ml可乐一瓶");
        System.out.println("3.满100元，加10元换购5公斤面粉");
        System.out.println("4.满200元，加10元可换购1个苏波尔炒菜用具");
        System.out.println("5.满200元，加20元可换购欧莱雅爽肤水一瓶");
        System.out.println("0.不换购");
        System.out.println("请选择：");
        int choose = input.nextInt();

        switch (choose){
            case 1:
                if (fee >= 50){
                    mofee = 50;
                    change = "百事可乐饮料一瓶";
                }else {
                    change = "错误";
                }
                break;
            case 2:
                if(fee >= 100) {
                    mofee = 100;
                    change = "500ml可乐一瓶";
                }else {
                    change = "错误";
                }
                break;
            case 3:
                if (fee >= 100) {
                    mofee = 100;
                    change = "5公斤面粉";
                }else {
                    change = "错误";
                }
                break;
            case 4:
                if (fee >= 200) {
                    mofee = 200;
                    change = "1个炒菜锅";
                }else {
                    change = "错误";
                }
                break;
            case 5:
                if (fee >= 200) {
                    mofee = 200;
                    change = "爽肤水一瓶";
                }else {
                    change = "错误";
                }
                break;
            case 0:
                mofee = 0;
                change = "不换购";
                break;
            default:
                change = "错误";
        }
        System.out.println("本次消费金额：" + (mofee +fee ));
        System.out.println("成功换购："+ change);


    }
}
