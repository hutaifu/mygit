package ch03prc01;

/**
 * @ClassName ch03prc01.Dog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Dog extends Pet {

    public Dog() {
    }

    public Dog(int health) {
        super(health);
    }

    @Override
    protected void eat() {
        System.out.println("狗狗吃了狗粮");
        setHealth(getHealth()+3);
    }
}
