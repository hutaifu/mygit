package com.jxd.ch09.model;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Student {
    //实体类和表结构一一对应
    private int stuno;
    private String sname;
    private String ssex;
    private String birthday;

    public int getStuno() {
        return stuno;
    }

    public void setStuno(int stuno) {
        this.stuno = stuno;
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

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Student() {
    }

    public Student(int stuno, String sname, String ssex, String birthday) {
        this.stuno = stuno;
        this.sname = sname;
        this.ssex = ssex;
        this.birthday = birthday;
    }
}
