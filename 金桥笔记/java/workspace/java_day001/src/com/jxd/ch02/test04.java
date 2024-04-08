package com.jxd.ch02;

public class test04 {
    public static void main(String[] args) {
        String name = "admin";
//              一个变量给另外一个变量赋值
        String name2 = name ;
        String name3 = "你好，" + name;
        int num3 = 10;
        System.out.println(num3 ++);
//        加加在后先执行输出，然后再进行++
        System.out.println(num3);
        int num4 =10;
        System.out.println(++ num4);
//        ++在前，先加加，然后再输出
        int num5 = 10;
//        System.out.println(num5 ++ +1 );
////        只要++再后面最后一步做++
//        System.out.println(num5);
        System.out.println(--num5 /2);
//        先减减，再/2，最后输出
        System.out.println(num5);



//
    }
}
