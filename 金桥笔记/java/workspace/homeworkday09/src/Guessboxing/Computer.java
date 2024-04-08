package Guessboxing;

import java.util.Random;

/**
 * @ClassName Computer
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Computer {
    String name;
    int scoer;
    public int getboxing(){
        Random random = new Random();
        int randommun = random.nextInt(3) +1;
        switch (randommun){
            case 1:
                System.out.println("电脑出拳：剪刀");
                break;
            case 2:
                System.out.println("电脑出拳：石头");
                break;
            case 3:
                System.out.println("电脑出拳：布");
                break;
        }
        return randommun;
    }
}
