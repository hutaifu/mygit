package ch06prc01;

/**
 * @ClassName Penguin
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class Penguin {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Penguin() {
    }

    public Penguin(String name) {
        this.name = name;
    }

    public void showinfo() {
        System.out.println("我的名字是" + name);
    }
}
