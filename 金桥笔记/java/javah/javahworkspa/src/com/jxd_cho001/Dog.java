package com.jxd_cho001;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Dog {
    private String name;
    private String type;
    private int health;
    private int love;

    public void setName(String name){
        this.name = name;
    }

    public void setType(){
        this.type = name;
    }

    public String getName(){
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0 && health <= 100) {
            this.health = health;
        }else {
            this.health = 60;
        }
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public Dog() {
    }

    public Dog(String name, String type, int health, int love) {
        this.name = name;
        this.type = type;
        if (health >= 0 && health <= 100) {
            this.health = health;
        }else {
            this.health = 60;
        }
        this.love = love;
    }
}
