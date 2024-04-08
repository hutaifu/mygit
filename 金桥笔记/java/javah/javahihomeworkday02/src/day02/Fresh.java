package day02;

/**
 * @ClassName Fresh
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Fresh extends Animal {
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Fresh() {
    }

    public Fresh(int age, double weight) {
        super(age);
        this.weight = weight;
    }

    @Override
    public void showinfo() {
        System.out.println("年龄" + getAge() + "重量" + weight);

    }
}
