package com.jxd.petstore.model;

/**
 * @ClassName PetOwner
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/14
 * @Version 1.0
 */

public class PetOwner {
    private int id;
    private String name;
    private String password;
    private double meney;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMeney() {
        return meney;
    }

    public void setMeney(double meney) {
        this.meney = meney;
    }

    public PetOwner() {
    }

    public PetOwner(int id, String name, String password, double meney) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.meney = meney;
    }
}
