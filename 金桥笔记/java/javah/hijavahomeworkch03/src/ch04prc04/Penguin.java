package ch04prc04;

/**
 * @ClassName Penguin
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Penguin implements IPlay {
    private int health;
    private int love;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public Penguin() {
    }

    public Penguin(int health, int love) {
        this.health = health;
        this.love = love;
    }

    @Override
    public void play() {
        setHealth(getHealth() - 10);
        setLove(getLove() + 5);
        System.out.println("主人和企鹅玩游泳有游戏，企鹅健康值减少10，与主人亲密度增加5");
    }
}
