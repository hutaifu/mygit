package com.jxd.ch0601;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TestLinkedList
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("hello");
        list.addFirst("java");
        list.addLast("I");

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.removeFirst();//移除第一个
        list.removeLast();
        list.remove(1);
        if (list.contains("java")){

        }
    }
}
