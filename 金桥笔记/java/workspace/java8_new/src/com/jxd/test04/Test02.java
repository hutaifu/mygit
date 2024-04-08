package com.jxd.test04;

import com.jxd.test03.Emp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        Stream<String> stream1= Stream.of("a","b","c","d");
        //01-遍历输出
        stream1.forEach(s -> System.out.println(s));
//        stream1.forEach(System.out::println);

        //02-筛选和切片，中间操作
        //0201:fillter方法
        List<Emp> list = new ArrayList<>();
        Collections.addAll(list,new Emp("张三",20),new Emp("李四",19),new Emp("王五",18)
        ,new Emp("赵六",21),new Emp("田七",22));
        //筛选年龄大于等于20的员工对象
        /*Stream<Emp> streamEmp = list.stream().filter(emp -> emp.getAge() >= 20);
        streamEmp.forEach(emp -> System.out.println(emp.getName()));*/
        //0202：截断流 limit（）
       // Stream<Emp> stream01 = list.stream().limit(3);
       // stream01.forEach(emp -> System.out.println(emp.getName()));

        //0203：跳过元素 skip（）
        //list.stream().skip(3).forEach(emp -> System.out.println(emp.getName()));

        //0204：去除流中的重复数据：distinct（）
        list.stream().distinct().forEach(emp -> System.out.println(emp.getName()));







    }
}
