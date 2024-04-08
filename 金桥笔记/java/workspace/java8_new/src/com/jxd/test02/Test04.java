package com.jxd.test02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test04 {
    public static List<String> getList(List<String> list,Predicate<String> predicate) {
        List<String> listNew = new ArrayList<>();

        for (String s : list) {
            if (predicate.test(s)) {
                listNew.add(s);
            }
        }
        return listNew;
    }


    public static void main(String[] args) {
        Predicate<String> predicate = str -> str.length() > 3;

        if (predicate.test("java")){
            System.out.println("长度符合要求");
        }
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"java","ok","true","lambda","yes");
        List<String> list1new =  getList(list,predicate);
        for (String s: list1new) {
            System.out.println(s);
        }
    }
}
