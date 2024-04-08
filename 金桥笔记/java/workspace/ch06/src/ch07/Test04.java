package ch07;

import java.util.Arrays;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/14
 * @Version 1.0
 */

public class Test04 {
    public static void main(String[] args) {

        int[] nums = {3, 2, 4, 5, 5};
        Arrays.sort(nums);
            for (int j = nums.length-1; j >= 0; j--) {
                System.out.println(nums[j]);

            }
    }
}
