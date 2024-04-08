package com.jxd.student.model;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/25
 * @Version 1.0
 */

public class Student {
    private int sno;
    private String sname;
    private String ssex;
    private int age;
    private String address;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSex(String sex) {
        this.ssex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
    }

    public Student(int sno, String sname, String ssex, int age, String address) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.age = age;
        this.address = address;
    }

    public Student(String sname, String ssex, int age, String address) {
        this.sname = sname;
        this.ssex = ssex;
        this.age = age;
        this.address = address;
    }
}
