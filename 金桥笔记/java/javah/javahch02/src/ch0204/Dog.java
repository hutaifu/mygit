package ch0204;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Dog extends Pet {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Dog() {
    }

    public Dog(String name, int health, int love, String type) {
        super(name, health, love);
        this.type = type;
    }

    //方法重写，从父类继承来的方法，无法满足子类的功能需求了，
    //那么子类可以重新覆盖这个方法
    @Override
    public void showinfo(){
        System.out.println("昵称是" + getName() + "\n品种是" + type + "\n健康值是" +
                getHealth() + "\n亲密度是" + getLove());

    }
}
