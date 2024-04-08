package com.jxd.ch0601;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestArrayLIst
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class TestArrayLIst {
    public static void main(String[] args) {
        //声明集合对象
        List list = new ArrayList();
        //存储数据,可以存储object类型，也就是任意数据
        list.add("hello");//按照顺序依次存放内容
        list.add(100);
        System.out.println(list.size());
        list.add(1,"java");//将元素放在指定位置上。

        //获取集合的长度
        System.out.println(list.size());

        //获取集合中的元素
        System.out.println(list.get(1));
        //获取到的是Object类型，如果需要作为具体的字符串或者整型进行处理
        //需要强转
        String str = (String)list.get(0);
        System.out.println(str.length());

        //遍历输出
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //删除集合中的元素
        list.remove(1);
        list.remove("hello");
        System.out.println(list.size());
        if (list.remove("hello")){

        }

        //查找集合中是否包含某个元素
        if (list.contains(100)){
            System.out.println("包含");
        }


    }
}
