package day02;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public abstract class Pet {
    private String name;
    private int love;
    private int health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0 && health <= 100) {
            this.health = health;
        }else {
            System.out.println("健康值应该在1和100之间，默认是60");
            this.health = 60;
        }
    }

    public Pet() {
    }

    public Pet(String name, int love, int health) {
        this.name = name;
        this.love = love;
        this.health = health;
    }

    public abstract void print();
}
