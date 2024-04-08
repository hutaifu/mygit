package com.jxd.test04;

import com.jxd.test03.Emp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test04 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("c","d","a","b");
        //升序排序
        stream.sorted().forEach(System.out::println);

        List<Emp> list = new ArrayList<>();
        Collections.addAll(list,new Emp("张三",20),new Emp("李四",19),new Emp("王五",18)
                ,new Emp("赵六",21),new Emp("田七",22));


        //指定排序
        //sorted 内部有遍历操作，将所有的对象都进行年龄排序
        list.stream().sorted((e1,e2) -> e1.getAge()-e2.getAge())
                .forEach(emp -> System.out.println(emp.getName()));

    }
}
