package com.jxd.stu.model;

/**
 * @ClassName Stu
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/5
 * @Version 1.0
 */

public class Stu {
    private int sno;
    private String sname;
    private String ssex;
    private  int age;
    private String address;
    private String birthday;
    private int cno;

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

    public void setSsex(String ssex) {
        this.ssex = ssex;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public Stu() {
    }

    public Stu(int sno, String sname, String ssex, int age, String address, String birthday, int cno) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
        this.cno = cno;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", cno=" + cno +
                '}';
    }
}
