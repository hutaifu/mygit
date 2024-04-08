package com.jxdch15;

import javax.jws.Oneway;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Test04 {
    public static void main(String[] args) {

        StringBuffer sbi = new StringBuffer("你好");
        sbi = new StringBuffer("谢谢");
//    拼接字符
//    A.(append)B将B拼接在A后面
        sbi = sbi.append("好心人");
        System.out.println(sbi);
        sbi.insert(1,"!");
        System.out.println(sbi);
//        123456789   ￥123456789
        StringBuffer sb = new StringBuffer("123456789");
        for (int i = sb.length() -3; i > 0 ; i -= 3) {
            sb = sb.insert(i,",");
        }
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
