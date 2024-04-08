package ch08;

/**
 * @ClassName Test03
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test03 {
    public static void main(String[] args) {
        boolean idChange = false;
        int[] nums = {21,454,45,87,654,54,4,454,4,5,5,};
        for (int i = 0; i < nums.length-1; i++) {
            idChange = false;
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    idChange = true;
                 }


            }
            if (!idChange){
                System.out.println("数组为有序");
                break;

            }

        }
        System.out.println("排序后");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
    }
}
