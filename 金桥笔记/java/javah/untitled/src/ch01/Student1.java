package ch01;

/**
 * @ClassName Student1
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Student1 {
    private String name;
    private  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 16) {
            this.age = age;
        }else {
            System.out.println("年龄不能小于16岁");
        }
    }

    public Student1() {
    }

    public Student1(String name, int age) {
        this.name = name;
        if (age >= 16) {
            this.age = age;
        }else {
            System.out.println("年龄不能小于16岁");
        }
    }

    public void showself(){
        System.out.println("我的姓名是" + name + "我的年龄是" + age);
    }
}
