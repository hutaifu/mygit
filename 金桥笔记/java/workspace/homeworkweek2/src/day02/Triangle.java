package day02;

/**
 * @ClassName Triangle
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class Triangle {
    int rows;
    String string;
    public void show(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
