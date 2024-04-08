package day04;

import java.util.Arrays;

/**
 * @ClassName Test14
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/14
 * @Version 1.0
 */

public class Test14 {
    public static void main(String[] args) {
        double[] nums= new double[]{1,3,-1.5,-2};
        for (int i = nums.length-1; i >= 0 ;i--) {
            if (nums[i] < 0){
                nums[i] = 0;
            }
            System.out.println(nums[i]);
        }



    }
}
