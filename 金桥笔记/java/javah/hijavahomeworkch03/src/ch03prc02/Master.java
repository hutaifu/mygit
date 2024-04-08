package ch03prc02;

/**
 * @ClassName Master
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Master {

    public void paly(Pet pet){
        if (pet instanceof Dog){
            Dog dog = (Dog)pet;
            dog.catchingFlyDisc();
        }else {
            Penguin penguin = (Penguin)pet;
            penguin.swimming();
        }
    }
}
