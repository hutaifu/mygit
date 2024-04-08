package com.jxdch15;



public class Test05 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("你好");
        String str = sb.toString();
        System.out.println(str.concat("吃了吗"));
        sb = new StringBuffer(str);
        sb.insert(2,"早上好");
        System.out.println(sb);
    }
}
