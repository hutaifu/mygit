package com.jxd.test.main;

import com.jxd.test.util.GetTime;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/15
 * @Version 1.0
 */

public class Test1 {
    public static void main(String[] args) {
        System.out.println(GetTime.currentime());
        System.out.println(GetTime.currentime() instanceof String);
        char[] ch = {'2','2','3'};
        System.out.println(ch);

    }
}
