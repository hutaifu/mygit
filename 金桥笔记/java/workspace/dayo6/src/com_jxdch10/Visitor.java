package com_jxdch10;

/**
 * @ClassName Visitor
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class Visitor {
    int fee;
    String name ;
    int age ;
    public void show(){
        if (age < 18 || age >60){
            fee = 0;
        }else {
            fee = 20;
        }
        System.out.println(name+"的年龄为:"+age+",门票价格为："+fee);

    }
}
