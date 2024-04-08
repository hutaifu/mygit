package com.jxd.vehmanage.util;

/**
 * @ClassName FrontToInteger
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/28
 * @Version 1.0
 */

public class FrontToInteger {

    public static Integer toInteger(Object object){
        Integer num = null;
        String s = (String)object;
        if (object != ""){
            num = Integer.parseInt(s);
        }
        return num;
    }
}
