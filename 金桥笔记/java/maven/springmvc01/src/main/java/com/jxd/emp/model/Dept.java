package com.jxd.emp.model;

import java.util.List;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/7
 * @Version 1.0
 */

public class Dept {
    private Integer deptno;
    private String dname;
    private List<Emp> emps;

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

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
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
                ", emps=" + emps +
                '}';
    }
}
