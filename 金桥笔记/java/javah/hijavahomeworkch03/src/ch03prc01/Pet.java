package ch03prc01;

/**
 * @ClassName ch03prc01.Pet
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public abstract class Pet {
    private int health;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Pet() {
    }

    public Pet(int health) {
        this.health = health;
    }

    protected abstract void eat();
}
