package com._jxdch13;

import java.util.Arrays;

/**
 * @ClassName Calcu
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Calcu {
    public int cal01(int num){
//        形参都是方法的局部变量
        num += 10;
        return num;

    }
//    public void calu02(){
//        int num= 10;



    public static void main(String[] args) {
        Calcu calcu = new Calcu();
        int num = 10;
//        方法在传递参数时会将当前方法复制一份,传到方法中
        int num02 = calcu.cal01(num);
        System.out.println(num);
        System.out.println(num02);
//        基本数据作为参数时，方法内的操作都不会影响原来的数据





    }
}
