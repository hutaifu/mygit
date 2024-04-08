package com.jxd_ch05;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Test04 {
    public static void main(String[] args) {
        try {
            Class.forName("com.jxd_ch05.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
