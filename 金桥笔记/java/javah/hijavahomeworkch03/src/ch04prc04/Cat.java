package ch04prc04;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Cat implements IFeed {
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

    public Cat() {
    }

    public Cat(int health, int love) {
        this.health = health;
        this.love = love;
    }

    @Override
    public void feed() {
        System.out.println("猫猫吃了猫粮");
        setHealth(getHealth() + 6);
    }
}
