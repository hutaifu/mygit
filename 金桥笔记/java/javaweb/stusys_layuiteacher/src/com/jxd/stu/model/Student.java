package com.jxd.stu.model;

/**
 * @ClassName Student
 * @Description TODO
 * @Author lixiaoru
 * @Date 2022/8/25
 * @Version 1.0
 */
public class Student {
    private int sno;
    private String sname;
    private String ssex;
    private int sage;
    private String address;
    private String birthday;

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

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
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

    public Student() {
    }

    public Student(int sno, String sname, String ssex, int sage, String address,String birthday) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.address = address;
        this.birthday = birthday;
    }
}
