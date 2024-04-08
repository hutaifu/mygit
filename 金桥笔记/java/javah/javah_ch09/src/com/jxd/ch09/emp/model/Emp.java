package com.jxd.ch09.emp.model;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private double sal;
    private int deptno;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
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

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public Emp() {
    }

    public Emp(int empno, String ename, String job, double sal, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.deptno = deptno;
    }
}
