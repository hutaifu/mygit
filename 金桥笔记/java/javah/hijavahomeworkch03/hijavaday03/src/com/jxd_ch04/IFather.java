package com.jxd_ch04;

public interface IFather {
    //String name;
    //接口中之能声明常量；
    public final static String NAME = "HELLO";

    //接口中没有构造方法



    public abstract void buycar();
    //抽象方法可以省略访问修饰符和abstract
    void show();
    //java8支持
    /*static void showinfo(){

    }*/
    //java9支持私有方法



}
