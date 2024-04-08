package com.jxd_homework;

/**
 * @ClassName Numlist
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/22
 * @Version 1.0
 */

public class Numlist {

//设置递归方法

    public int getnumlist(int i){
        if (i==0 || i ==1){
            return 1;
        }
        return getnumlist(i-1) + getnumlist(i-2);
    }
}
