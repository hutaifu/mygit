package com.jxd.ch09.emp.vo;

/**
 * @ClassName EmpWithDept
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class EmpWithDeptVO {
    private int empno;
    private String ename;
    private String job;
    private String hirdate;
    private double sal;
    private String dename;

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

    public String getHirdate() {
        return hirdate;
    }

    public void setHirdate(String hirdate) {
        this.hirdate = hirdate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }
}
