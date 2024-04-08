package com.jxd.emp.model;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/8
 * @Version 1.0
 */

public class Dept {
    private Integer deptno;
    private  String dname;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Dept() {
    }

    public Dept(Integer deptno, String dname) {
        this.deptno = deptno;
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                '}';
    }
}
