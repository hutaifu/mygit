package com.jxd.petstore.model;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class Pet {
    private int id;
    private String name;
    private String typename;
    private int health;
    private int love;
    private String birthday;
    private int owner_id;
    private int store_id;
    private int type;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet() {
    }

    public Pet(int id, String name, String typename, int health, int love, String birthday, int owner_id, int store_id, int type, double balance) {
        this.id = id;
        this.name = name;
        this.typename = typename;
        this.health = health;
        this.love = love;
        this.birthday = birthday;
        this.owner_id = owner_id;
        this.store_id = store_id;
        this.type = type;
        this.balance = balance;
    }
}
