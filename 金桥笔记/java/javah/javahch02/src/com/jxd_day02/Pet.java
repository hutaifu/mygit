package com.jxd_day02;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Pet {
    private String name;
    private int health;
    private int love;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Pet(String name, int health, int love) {
        this.name = name;
        this.health = health;
        this.love = love;
    }
}
