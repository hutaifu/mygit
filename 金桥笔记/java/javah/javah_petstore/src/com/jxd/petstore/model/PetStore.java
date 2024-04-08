package com.jxd.petstore.model;

/**
 * @ClassName PetStore
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class PetStore {
    private int id;
    private String name;
    private String passwore;
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswore() {
        return passwore;
    }

    public void setPasswore(String passwore) {
        this.passwore = passwore;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PetStore() {
    }

    public PetStore(int id, String name, String passwore, double balance) {
        this.id = id;
        this.name = name;
        this.passwore = passwore;
        this.balance = balance;
    }
}
