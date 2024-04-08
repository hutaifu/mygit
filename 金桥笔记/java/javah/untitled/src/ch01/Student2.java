package ch01;

/**
 * @ClassName Student2
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/1
 * @Version 1.0
 */

public class Student2 {
    private String name;
    private String sex;
    private int age;
    private String major;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Student2() {
    }

    public Student2(String name) {
        this.name = name;
    }

    public Student2(int age) {
        this.age = age;
    }

    public Student2(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Student2(String name, String sex, int age, String major) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
    }
}
