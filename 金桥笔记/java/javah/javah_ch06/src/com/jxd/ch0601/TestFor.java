package com.jxd.ch0601;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName TestFor
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class TestFor {
    public static void main(String[] args) {
        List list =  new ArrayList();
        list.add(new Dog("大毛","金毛"));
        list.add(new Dog("二毛","拉布拉多"));
        list.add(new Dog("三毛","哈士奇"));

        //1.fori循环
        for (int i = 0; i < list.size(); i++) {
            Dog dog = (Dog)list.get(i);
            System.out.println(dog.getName());
        }

        //for each循环
        //遍历这个集合中的每一个obj对象
        for (Object obj : list) {
            Dog dog = (Dog)obj;
            System.out.println(dog.getName());
        }

        //3.迭代器循环
        Iterator it = list.iterator();
        //hasNext用于判断集合中是否有下一个元素
        //Next用于获取这个元素
        while (it.hasNext()){
            Dog dog = (Dog)it.next();
            System.out.println(dog.getName());
        }
    }
}
