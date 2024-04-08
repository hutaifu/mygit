package ch03prc01;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Pet pet1 = new Dog(34);
        Pet pet2 = new Cat(35);
        Master master = new Master();
        master.feed(pet1);
        master.feed(pet2);
    }
}
