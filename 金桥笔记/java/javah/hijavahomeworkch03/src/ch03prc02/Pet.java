package ch03prc02;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Pet {
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

    public Pet() {
    }

    public Pet(int health, int love) {
        this.health = health;
        this.love = love;
    }
}
