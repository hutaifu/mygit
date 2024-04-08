package work.day02;

import java.util.Scanner;

public class test06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入当前华氏摄氏：");
        double tem = input.nextDouble();
        System.out.println("摄氏度为："+String.format("%.2f",(tem - 32)/1.8));
    }
}
