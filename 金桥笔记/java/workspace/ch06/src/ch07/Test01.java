package ch07;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/14
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        int num = 10;
        int[] nums = new int[5];
        nums[0] = 90;
        nums[1] = 80;
        nums[4] = 97;
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);


        String[] names = new String[3];
        names[0] = "张三";

        double[] scores;
        scores = new double[10];




//        声明的同时赋值
        char[] sex = {'男','女','男','女'};
        System.out.println(sex[3]);


        String[] addresses = new String[]{"济南","青岛","烟台"};
        System.out.println(addresses[0]);
        System.out.println(addresses[1]);
        System.out.println(addresses[2]);

        for (int i = 0; i <addresses.length ; i++) {
            System.out.println(addresses[i]);

        }



    }
}
