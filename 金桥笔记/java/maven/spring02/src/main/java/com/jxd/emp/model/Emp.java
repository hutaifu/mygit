package com.jxd.emp.model;

import org.springframework.stereotype.Component;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/8
 * @Version 1.0
 */
//<bean id = "emp" class = "com.jxd.emp.model.Emp">
//    Component  用于控制反转，这个注解加在非dao，service，controller层类上。
//    参数是对像名，默认首字母小写
@Component("emp")
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private String hiredate;

    public Emp() {
    }

    public Emp( Integer empno, String ename, String job, String hiredate) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
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
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate='" + hiredate + '\'' +
                '}';
    }
}
