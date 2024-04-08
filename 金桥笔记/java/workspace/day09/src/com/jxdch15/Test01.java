package com.jxdch15;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        String str = "你好";
        String str2 = "谢谢";
        System.out.println(str.concat(str2));
        String str3 = "aBc";
        String str4 = str3.toUpperCase();
        System.out.println(str4);
        str4 = str3.toLowerCase();
        System.out.println(str4);
//        忽略大小写
        System.out.println("ABC".equalsIgnoreCase(str3));
//        查找某个字符或字符串在指定字符串中首次出现的位置
        String str5 = "apple and banana";
//        int index = str5.indexOf("q");
//        if (index < 0) {
//            System.out.println("没有找到");
//        }
//
//
//            System.out.println("a的位置是" + index);
        String str6 = "今天是周四";
        str6 = str6.substring(0,2);
//        包含头不包含尾
        System.out.println(str6);
        String sti = "床前明月光,疑是地上霜。";
        String[] strat = sti.split(",")  ;
        System.out.println(strat[0]);
        System.out.println(strat[1]);
    }
    }

