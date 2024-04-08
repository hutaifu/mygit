package day04;

import java.util.Arrays;

/**
 * @ClassName Test16i
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test16i {
    public static void main(String[] args) {
        char[] one = new char[]{'a','c','u','b','e','p','f','z'};
        Arrays.sort(one);
        System.out.print("升序排列后：");
        for (int i = 0; i < one.length; i++) {
            System.out.print(one[i] + "\t");
        }
        System.out.print("\n逆序输出为：");
        for (int i = one.length-1; i >= 0; i--) {
            System.out.print(one[i] + "\t");

        }
    }
}
