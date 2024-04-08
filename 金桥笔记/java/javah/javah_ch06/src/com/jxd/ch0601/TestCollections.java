package com.jxd.ch0601;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName TestCollections
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //批量添加
        Collections.addAll(list,"hello","java","!");
        System.out.println(list.size());
        //排序
        Collections.sort(list);
        //反转
        Collections.reverse(list);
    }
}
