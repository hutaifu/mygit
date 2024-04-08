package com.jxd;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        //匿名内部类实现了接口的抽象方法
        MyInterfance myInterfance = new MyInterfance(){
             public String strHandler (String str) {
                 return str.substring(2, 5);
             }
            };
        String str = myInterfance.strHandler("hello");
        System.out.println(str);
    }
}
