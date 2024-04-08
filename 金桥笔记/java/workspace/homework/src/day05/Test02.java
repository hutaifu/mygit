package day05;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        boolean isSuccess = false;
        for (int i =0; i < 21; i++) {
            for (int j = 0; j < 34; j++) {
                if (i * 5 + j * 3 + (100 - i - j) / 3.0 == 100) {
                    System.out.println("公鸡为数量为：" + i + "母鸡数量为：" + j + "小鸡数量为:" + (100 - i - j));
                }
            }
        }
    }
}
