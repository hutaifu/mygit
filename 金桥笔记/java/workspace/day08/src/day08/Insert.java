package day08;

/**
 * @ClassName Insert
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Insert {
    public void inser(int postion,int[] ints,int object){
        int[] ints1 = new int[ints.length+1];
        for (int i = ints.length-1; i >= postion-1; i--) {
            ints1[i+1] = ints[i];
        }
            ints1[postion] = ints[postion];
        for (int i = 0; i < ints.length-1; i++) {
            ints1[i] = ints[i];
        }
    }
}
