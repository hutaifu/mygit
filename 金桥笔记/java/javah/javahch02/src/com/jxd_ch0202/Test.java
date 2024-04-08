package com.jxd_ch0202;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
//        Children c1 = new Children();

        Children c2 = new Children(20,"张三");
        System.out.println(c2.getAge());
    }
}
