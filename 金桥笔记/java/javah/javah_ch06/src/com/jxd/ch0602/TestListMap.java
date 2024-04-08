package com.jxd.ch0602;

import java.util.*;

/**
 * @ClassName TestListMap
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class TestListMap {
    public static void main(String[] args) {
        List<Map<String,String>> list = new ArrayList<>();
        //创建mapo
        Map<String,String> map1 = new HashMap<>();
        map1.put("001","张三");
        map1.put("002","李四");
        list.add(map1);

        Map<String,String> map2 = new HashMap<>();
        map2.put("001","王五");
        map2.put("002","赵六");

        list.add(map2);

        System.out.println(list.size());

        //遍历所有班级所有学生
        for (Map<String,String> map : list) {
            System.out.println(map.get("001"));
            System.out.println(map.get("002"));

        }
    }
}
