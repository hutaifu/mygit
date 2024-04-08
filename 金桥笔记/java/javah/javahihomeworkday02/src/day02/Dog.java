package day02;

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

    public void setType(int num) {
        switch (num){
            case 1:
                this.type = "拉布拉多犬";
                break;
            case 2:
                this.type = "雪纳瑞";
                break;
            default:
                System.out.println("输入错误");
        }
    }

    public Dog() {
    }

    public Dog(String name, int love, int health, String type) {
        super(name, love, health);
        this.type = type;
    }

    public void print() {
        System.out.println("宠物的自白：");
        System.out.println("我的昵称是" + getName());
        System.out.println("我的健康值为" + getHealth());
        System.out.println("我的亲密度为" + getLove());
        System.out.println("我的品种为" + type);

    }


}
