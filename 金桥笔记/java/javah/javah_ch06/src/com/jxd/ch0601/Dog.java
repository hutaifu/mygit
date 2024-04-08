package com.jxd.ch0601;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class Dog {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Dog() {
    }

    public Dog(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
