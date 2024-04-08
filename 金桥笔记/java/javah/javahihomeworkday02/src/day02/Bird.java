package day02;

/**
 * @ClassName bird
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Bird extends Animal {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Bird() {
    }

    public Bird(int age, String color) {
        super(age);
        this.color = color;
    }

    @Override
    public void showinfo() {
        System.out.println("年龄" + getAge() + "颜色" + color);

    }

}
