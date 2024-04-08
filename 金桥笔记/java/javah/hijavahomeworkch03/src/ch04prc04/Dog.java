package ch04prc04;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Dog implements IFeed,IPlay {
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

    public Dog() {
    }

    public Dog(int health, int love) {
        this.health = health;
        this.love = love;
    }

    @Override
    public void feed() {
        System.out.println("狗狗吃了狗粮");
        setHealth(getHealth()+3);
    }

    @Override
    public void play() {
        setHealth(getHealth() - 10);
        setLove(getLove() + 5);
        System.out.println("主人和狗狗玩接飞盘游戏，狗狗健康值减少10，与主人亲密度增加5");
    }
}
