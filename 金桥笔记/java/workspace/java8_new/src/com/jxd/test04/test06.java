package com.jxd.test04;

import com.jxd.test03.Emp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName test06
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class test06 {
    public static void main(String[] args) {
        //规约 reduce
        Integer[] nums = {1,2,3,4,5,6};
        Stream<Integer> stream = Arrays.stream(nums);
        //累计求和,从零开始依次累加
        System.out.println(stream.reduce(0,(x,y) -> x + y));

        //收集操作  collect 终端操作
        List<Emp> list = new ArrayList<>();
        Collections.addAll(list,new Emp("张三",20),new Emp("李四",20),new Emp("王五",18)
                ,new Emp("赵六",18),new Emp("田七",22));
        List<Emp> listNew = list.stream().filter(emp -> emp.getAge() >20)
                .collect(Collectors.toList());
        for (Emp emp: listNew) {
            System.out.println(emp.getName());
        }

        //年龄最大的员工信息
        Optional<Emp> op = list.stream().collect(Collectors.maxBy((e1, e2) -> e1.getAge() + e2.getAge()));
        System.out.println(op.get().getName());

        //年龄平均值
        double avg = list.stream().collect(Collectors.averagingDouble(Emp::getAge));
        System.out.println(avg);

        //按年龄分组
        Map<Integer,List<Emp>> map = list.stream().collect(Collectors.groupingBy(Emp::getAge));
        System.out.println(map.get(20).get(0).getName());
    }
}
