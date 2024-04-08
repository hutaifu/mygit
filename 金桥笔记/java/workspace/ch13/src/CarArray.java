/**
 * @ClassName CarArray
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class CarArray {
    public void setArray(int[] nums){
        nums[1] += 10;
        System.out.println(nums[1]);
    }

    public static void main(String[] args) {
        CarArray carArray = new CarArray();
        int[] nums = {1,2,3};

        carArray.setArray(nums);
        System.out.println(nums[1]);
    }
}
