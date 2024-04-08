package ch04prc03;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Cat implements ISound {
    @Override
    public void cry() {
        System.out.println("发出猫叫");

    }
}
