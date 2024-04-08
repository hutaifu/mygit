package com.jxd.test04;

import com.jxd.test03.Emp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test05 {
    public static void main(String[] args) {
        List<Emp> list = new ArrayList<>();
        Collections.addAll(list,new Emp("张三",20),new Emp("李四",19),new Emp("王五",18)
                ,new Emp("赵六",21),new Emp("田七",22));

        //查询集合中是否有年龄大于20的员工
        //任意一个大于20，返回true 相当于||
       /* boolean exists = list.stream().anyMatch(emp -> emp.getAge() > 30);
        System.out.println(exists);*/

        //所有人都大于20,相当于&&
      /*  boolean all = list.stream().allMatch(emp -> emp.getAge() > 20);
        System.out.println(all);*/


        //没有人大于20岁 anyMatch的非操作
       /* boolean isnotAll = list.stream().noneMatch(emp -> emp.getAge() > 30);
        System.out.println(isnotAll);*/


        //查找第一个
        Optional<Emp> op = list.stream().sorted((e1, e2) -> e1.getAge() - e2.getAge())
                .findFirst();
        //Optional是一个盒子，容器，存放了第一个员工对象
        //避免获取到null对象，出现空指针异常
        System.out.println(op.get().getName());

        //查找任意一个对象
        Optional<Emp> op2 = list.stream().findAny();
        System.out.println(op2.get().getName());

        //count计数
        System.out.println(list.stream().count());//list.size();

        //max/min
        //年龄最大的员工信息
        Optional<Emp> op3 = list.stream().max((e1,e2) -> e1.getAge() - e2.getAge());
        System.out.println(op3.get().getName());

        Optional<Emp> op4 = list.stream().min((e1,e2) -> e1.getAge() - e2.getAge());
        System.out.println(op4.get().getName());
    }
}
