package com.jxd_ch05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) throws Exception{
        /*try {
            divde();
        }catch (Exception e){
            System.out.println("输入有误");
        }*/
        divde();
    }

    public static void divde() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("请输入被除数：");
        int num01 = input.nextInt();
        System.out.println("请输入除数：");
        int num02 = input.nextInt();

        System.out.println("结果是" + num01 / num02);


        System.out.println("感谢使用本程序");
    }

}
