package ch03prc02;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Pet pet = new Dog(34,53);
        Master master = new Master();
        master.paly(pet);
    }
}
