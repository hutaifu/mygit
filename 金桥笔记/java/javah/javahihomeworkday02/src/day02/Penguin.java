package day02;

/**
 * @ClassName Penguin
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Penguin extends Pet{
    private String sex;
    static String SEX_MALE= "Q仔";
    static String SEX_FEMALE = "Q妹";

    {
        setLove(20);
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

    public Penguin() {
    }

    public Penguin(String name, int love, int health, String sex) {
        super(name, love, health);
        this.sex = sex;
    }

    public void print() {
        System.out.println("宠物的自白：");
        System.out.println("我的昵称是" + getName());
        System.out.println("我的健康值为" + getHealth());
        System.out.println("我的亲密度为" + getLove());
        System.out.println("我的性别" + sex);
    }
}
