package com.jxd.emp.model;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/8
 * @Version 1.0
 */

public class Emp {
    private Dept dept;
    private Integer empno;
    private String ename;
    private String job;
    private String hiredate;

    public Emp() {
    }

    public Emp(Dept dept, Integer empno, String ename, String job, String hiredate) {
        this.dept = dept;
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate='" + hiredate + '\'' +
                '}';
    }
}
