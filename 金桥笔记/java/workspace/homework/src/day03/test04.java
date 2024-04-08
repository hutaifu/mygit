package day03;

import java.util.Scanner;

public class test04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入4位会员号：");
        int num =  input.nextInt();
        int random = (int)(Math.random()*10);
        int a = num % 1000 / 100;

        if (random == a){
            System.out.println(num+"号客户是幸运客户，获得精美MP3一个。");
        }else if (num >= 1000 && num <= 9999){
            System.out.println(num+"号客户，谢谢你的支持！");
        }else{
            System.out.println("请输入正确会员号");
        }
    }
}
