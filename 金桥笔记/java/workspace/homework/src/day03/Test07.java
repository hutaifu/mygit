package day03;

import java.util.Scanner;

public class Test07 {
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
    if ((month1 <= 5 || month1 >= 10) && month1 > 0){
        if ("y".equals(choose)){
            System.out.println("价格为：3600");
        }else if ("n".equals(choose)){
            System.out.println("价格为：3000");
        }
    }else if ("y".equals(choose) && !(month1 ==0) ){
        System.out.println("价格为：24000");
    }else if ("n".equals(choose)){
        System.out.println("价格为：1200");
    }else {
        System.out.println("错误");
    }


    }
}
