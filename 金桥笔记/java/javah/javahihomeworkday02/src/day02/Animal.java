package day02;

/**
 * @ClassName Animal
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public abstract class Animal {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal() {
    }

    public Animal(int age) {
        this.age = age;
    }

    public abstract void showinfo();
}
