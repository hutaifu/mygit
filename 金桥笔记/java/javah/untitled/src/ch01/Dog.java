package ch01;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Dog {
    private String name;
    private int health;
    private String type;
    private int loves;

    {
        loves = 20;
    }

    public String getName() {
        return name;
    }


    void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    void setHealth(int health) {
        if (health >= 0 && health <= 100) {
            this.health = health;
        }else {
            System.out.println("健康值应该在1和100之间，默认是60");
            this.health = 60;
        }
    }

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

    public int getLoves() {
        return loves;
    }

    public void setLoves(int loves) {
        this.loves = loves;
    }

    Dog(){
    }

    public Dog(String name, int health, int loves,String type) {
        this.name = name;
        if (health >=1 && health <= 100) {
            this.health = health;
        }else {
            System.out.println("输入无效健康值！");
            this.health = 60;
        }
        this.type = type;
        this.loves = loves;
    }

    public void showinfo(){
        System.out.println("宠物的自白：");
        System.out.println("我的昵称是" + name);
        System.out.println("我的健康值为" + health);
        System.out.println("我的亲密度为" + loves);
        System.out.println("我的品种为" + type);
    }
}
