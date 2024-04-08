package ch06work01;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/7
 * @Version 1.0
 */

public class Student {
    private String name;
    private String sex;
    private String no;
    private int age;

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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, String sex, String no, int age) {
        this.name = name;
        this.sex = sex;
        this.no = no;
        this.age = age;
    }

    public void showinfo() {
        System.out.println("名字" + name + "学号" + no + "性别" + sex + "年龄" + age);
    }
}
