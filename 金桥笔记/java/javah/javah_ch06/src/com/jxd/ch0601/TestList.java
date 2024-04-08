package com.jxd.ch0601;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName TestList
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class TestList {
    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("大毛","金毛"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }

        for (Dog dog : list) {
            System.out.println(dog.getName());
        }

        Iterator<Dog> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next().getName());
        }

        List<int[]> list1d = new ArrayList<>();

        List<List<String>> lists = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("java");

        lists.add(list1);
    }
}
