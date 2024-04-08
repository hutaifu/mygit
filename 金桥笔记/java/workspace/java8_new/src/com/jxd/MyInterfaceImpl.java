package com.jxd;

/**
 * @ClassName MyInter
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class MyInterfaceImpl implements MyInterfance {

    @Override
    public String strHandler(String str) {
        return str.substring(2, 5);
    }
}
