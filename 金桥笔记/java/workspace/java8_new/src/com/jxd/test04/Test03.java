package com.jxd.test04;

import com.jxd.test03.Emp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        List<Emp> list = new ArrayList<>();
        Collections.addAll(list,new Emp("张三",20),new Emp("李四",19),new Emp("王五",18)
                ,new Emp("赵六",21),new Emp("田七",22));

        //映射操作，map中间操作
        //获取每个对象的姓名值
        //map方法本身有循环动作，会处理每个员工对象，获取他们的姓名信息；
        Stream<String> stream = list.stream().map(emp -> emp.getName());
        stream.forEach(System.out::println);




    }
}
