package com.jxd._ch01;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

/**
 * @ClassName Penguin
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Penguin {
    String name;
    String sex;
    int health;
    final String type = "帝企鹅";

    //常量的定义
    public final static double PI = 3.14;

    public final static String SEX_BOY = "男";
    public final static String SEx_GIRL = "女";

    //之间通过类名访问常量


    public  void show(){
        System.out.println(name + sex + health);
        String food = this.getfood();
        System.out.println(food);
    }

    public String getfood(){
        return "鱼干";
    }




    public static void main(String[] args) {
        Penguin penguin = new Penguin();

        final String sexBoy = "boyu";
        final String sexGirl = "gril";
        penguin.sex = sexGirl;

        final int num = 10;
        //final修饰对象或者数组
        final Penguin penguin1 = new Penguin();
        penguin1.name = "QQ";
        penguin1.name = "Q仔";
        System.out.println(penguin1);
        //代表地址不可被更改

    }

}
