package com.jxd.test04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/12
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        Stream<String> stream = list.stream();

        //方法二
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        //方法三：
        Stream<String> stream2 = Stream.of("aa","bb","cc");
    }
}
