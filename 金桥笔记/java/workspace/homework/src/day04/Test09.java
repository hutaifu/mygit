package day04;

import java.util.Scanner;

public class Test09 {
    public static void main(String[] args) {
        int num = 0;
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int[] a  = new int[]{8,4,2,1,23,344,12};
        for(int i = 0; i < 7; i++){
            System.out.println(a[i]);
            sum += a[i];
        }
        System.out.println("所有数值和为" + sum);
        System.out.println("请输入一个数：");
        num = input.nextInt();
        for (int i = 0; i < 7; i++) {
            if (num == a[i]){
                System.out.println("是数组中的数");
                break;
            }else if(i == 7){
                System.out.println("不是数组中的数");

            }


        }
    }
}
