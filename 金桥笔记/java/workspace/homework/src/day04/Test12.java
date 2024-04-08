package day04;

/**
 * @ClassName Test12
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/14
 * @Version 1.0
 */

public class Test12 {
    public static void main(String[] args) {
        int[] nums = new int[]{18,25,7,36,13,2,89,63};
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min){
                min = nums[i];
            }
        }
        System.out.println(min);
    }
}
