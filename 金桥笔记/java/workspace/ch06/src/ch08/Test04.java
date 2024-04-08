package ch08;

/**
 * @ClassName Test04
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test04 {
    public static void main(String[] args) {


        int[] nums = {45634, 54, 487, 45, 54, 41};
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

            }

        }
        System.out.println("排序后：");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
    }
}