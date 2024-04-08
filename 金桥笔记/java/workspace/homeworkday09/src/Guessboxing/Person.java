package Guessboxing;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Person {
    String name;
    int score;
    public void showboxing(int num){
        switch (num){
            case 1:
                System.out.println("你出拳：剪刀");
                break;
            case 2:
                System.out.println("你出拳：石头");
                break;
            case 3:
                System.out.println("你出拳：布");
                break;
            default:
                System.out.println("错误");
        }
    }
}
