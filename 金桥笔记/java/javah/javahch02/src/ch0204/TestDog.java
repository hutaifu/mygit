package ch0204;

/**
 * @ClassName TestDog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class TestDog {
    public static void main(String[] args) {
        Dog dog = new Dog("大毛",89,89,"金毛");
        dog.showinfo();

        Cat cat = new Cat();
        cat.setName("买猫");
        cat.setHealth(38);
        cat.setLove(23);
    }
}
