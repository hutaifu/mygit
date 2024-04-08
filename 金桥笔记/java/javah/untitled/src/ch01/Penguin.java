package ch01;

/**
 * @ClassName Penguin
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Penguin {
    private String name;
    private int health;
    private String sex;
    private int loves;

    static String SEX_MALE= "Q仔";
    static String SEX_FEMALE = "Q妹";

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

    public String getSex() {
        return sex;
    }

    public void setSex(int num) {
        switch (num){
            case 1:
                this.sex = "雄";
                break;
            case 2:
                this.sex = "雌";
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

    Penguin(){
    }

    public Penguin(String name, int health, int loves,String sex) {
        this.name = name;
        if (health >=1 && health <= 100) {
            this.health = health;
        }else {
            System.out.println("输入无效健康值！");
            this.health = 60;
        }
        this.sex = sex;
        this.loves = loves;
    }

    void showinfo(){
        System.out.println("宠物的自白：");
        System.out.println("我的昵称是" + name);
        System.out.println("我的健康值为" + health);
        System.out.println("我的亲密度为" + loves);
        System.out.println("我的性别为" + sex);
    }
}
