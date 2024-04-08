package ch07;

import java.security.Key;
import java.util.Arrays;

/**
 * @ClassName Test05
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test05 {
    public static void main(String[] args) {
        int[] nums = {0,4,15,27,40,56,79,132,500};
        int target = 500;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
                continue;
            }
            if (target < nums[mid]) {
                end = mid - 1;
                continue;
            }
            if (target == nums[mid]) {
                System.out.println(mid);
                break;
//                Arrays.binarySearch(nums,500);
            }
        }
    }

}
