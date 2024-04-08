package ch04prc03;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        ISound iSound = new Dog();
        ISound iSound1 = new Cat();
        ISound iSound2 = new Pig();
        iSound.cry();
        iSound1.cry();
        iSound2.cry();
    }
}
