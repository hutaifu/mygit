package ch08;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(j +1 +"*"+(i+1)+"="+(i+1)*(j+1));
            }
            System.out.println();
        }
    }
}
