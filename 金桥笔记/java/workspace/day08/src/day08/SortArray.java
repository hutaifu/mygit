package day08;

/**
 * @ClassName SortArray
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class SortArray {
    public void findMinMax(double[] doubles){
        double min = 0;
        double max = 0;
        for (int i = 0; i < doubles.length-1; i++) {
            if (max < doubles[i]){
                max = doubles[i];
            }
            if(min > doubles[i]){
                min = doubles[i];
            }


        }
        System.out.println("最大值为"+max+"最小值为"+min);
    }
}
