package com.jxd.ch0602;

import com.jxd.ch0601.Dog;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestMap
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class TestMap {
    public static void main(String[] args) {
        //创建map集合
        Map map = new HashMap();
        //存储数据
        map.put("CN","中华人民共和国");
        map.put("RU","俄罗斯联邦");
        map.put("FR","法兰西共和国");
        map.put("FR","法国");//如果有重复的key值，那么value值会被覆盖

        //map的长度
        System.out.println(map.size());

        //获取map中的值，通过key值获取value值//map是无序的，无法通过下标访问。
        System.out.println(map.get("FR"));

        map.put("UA",123);

        //移除数据
        map.remove("RU");
        System.out.println(map.get("RU"));//null值

        //直接输出map中的数据
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map);

        //判断是否包含某个key值
        if (map.containsKey("CN")){
            System.out.println("包含");
        }

        if (map.containsValue("法国")){
            System.out.println("包含");
        }

        //泛型map
        Map<String , Dog> mapDog = new HashMap<>();
        //key值必须是String类型，value值必须是Dog类型
        mapDog.put("001",new Dog("毛毛","泰迪"));
        mapDog.put("002",new Dog("大毛","柴犬"));

        //获取元素，并且输出
        Dog dog = mapDog.get("002");
        System.out.println(dog.getName());

        mapDog.put("003",null);//value值可以为空
        mapDog.get("003").getName();//空指针异常




    }
}
