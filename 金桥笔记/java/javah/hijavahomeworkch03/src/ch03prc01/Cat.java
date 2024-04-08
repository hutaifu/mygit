package ch03prc01;

/**
 * @ClassName ch03prc01.Cat
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Cat extends Pet {

    public Cat() {
    }

    public Cat(int health) {
        super(health);
    }

    @Override
    protected void eat() {
        System.out.println("猫猫吃了猫粮");
        setHealth(getHealth() + 6);
    }
}
