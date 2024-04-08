package com.jxd_ch03;

/**
 * @ClassName Penguin
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Penguin extends Pet {
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Penguin() {
    }

    public Penguin(String name, int health, int love, String sex) {
        super(name, health, love);
        this.sex = sex;
    }

    @Override
    public void showinfo(){
        System.out.println("昵称是" + getName() + "\n品种是" + "\n健康值是" +
                getHealth() + "\n亲密度是" + getLove() + "\n性别是" + sex);
    }

    @Override
    public void cure() {
        System.out.println("生病需要吃药");
    }

    public void swim(){
        System.out.println("小企鹅擅长游泳");
    }
}
