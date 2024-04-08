package ch03prc02;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Dog extends Pet {

    public Dog() {
    }

    public Dog(int health, int love) {
        super(health, love);
    }

    public void catchingFlyDisc(){
        setHealth(getHealth() - 10);
        setLove(getLove() + 5);
        System.out.println("主人和狗狗玩接飞盘游戏，狗狗健康值减少10，与主人亲密度增加5");
    }
}
