package com.jxd.student.model;

/**
 * @ClassName Cls
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/1
 * @Version 1.0
 */

public class Cls {
    private int cno;
    private String cname;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Cls() {
    }

    public Cls(int cno, String cname) {
        this.cno = cno;
        this.cname = cname;
    }
}
