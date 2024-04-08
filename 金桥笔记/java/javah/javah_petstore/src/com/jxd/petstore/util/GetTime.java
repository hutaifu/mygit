package com.jxd.petstore.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName GetTime
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class GetTime {
    public static String currentime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }
}
