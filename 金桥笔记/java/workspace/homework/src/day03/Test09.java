package day03;

import java.util.Scanner;

public class Test09 {
    public static void main(String[] args) {
        int month1 = 0;
        int month = 0;
        String choose = "";
        Scanner input = new Scanner(System.in);
        System.out.println("请输入月份：");
        month = input.nextInt();
        if (month <= 12 && month >= 1){
            month1 = month;
        }
        System.out.println("是否选择头等舱（y/n）：");
        choose = input.next();
        switch (month1){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
            case 11:
            case 12:
                if ("y".equals(choose)){
                    System.out.println("价格为：3600");
                }else if ("n".equals(choose)){
                    System.out.println("价格为：3000");
                }
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                if ("y".equals(choose)){
                    System.out.println("价格为：24000");
                }else if ("n".equals(choose)){
                    System.out.println("价格为：1200");
                }
                break;
            default:
                System.out.println("错误");
        }
    }
}
