package ch03prc02;

/**
 * @ClassName Penguin
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Penguin extends Pet {

    public Penguin() {
    }

    public Penguin(int health, int love) {
        super(health, love);
    }

    public void swimming(){
        setHealth(getHealth() - 10);
        setLove(getLove() + 5);
        System.out.println("主人和企鹅玩游泳有游戏，企鹅健康值减少10，与主人亲密度增加5");
    }
}
