package day08;

/**
 * @ClassName Utility
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Utility {
    public void is(int num){
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                System.out.println("是素数");
            }else {
                System.out.println("不是素数");
            }

        }


    }
}
