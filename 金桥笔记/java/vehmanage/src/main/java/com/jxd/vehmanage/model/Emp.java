package com.jxd.vehmanage.model;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/27
 * @Version 1.0
 */

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private String hiredate;
    private int deptno;
    private String sex;

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

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Emp() {
    }

    public Emp(int empno, String ename, String job, String hiredate, int deptno, String sex) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.deptno = deptno;
        this.sex = sex;
    }
}
