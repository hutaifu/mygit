package ch04prc04;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog(32,23);
        Cat cat = new Cat(23,43);
        Penguin penguin = new Penguin(23,43);
        dog.feed();
        dog.play();
        cat.feed();
        penguin.play();
    }
}
