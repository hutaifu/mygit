package com.jxd.plus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/16
 * @Version 1.0
 */
//使得数据库表面和类名能够对应起来
    //value属性值就是数据库的表面
@Data
//@TableName(value = "emp_info")
public class Emp {
    //用于标识主键列，保证删除和更新功能能够正常运行
    //type用于指定主键的生成策略，IdType.AUTO代表执行MP新增功能时，
    //主键使用数据库的自增功能
    //value属性用于对应数据库中的主键列名
    @TableId(value = "empno",type = IdType.AUTO)
    private int empno;
    @TableField(value = "ename")
    private String ename;
    private String job;
    private String hiredate;

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

    public Emp() {
    }

    public Emp(int empno, String ename, String job, String hiredate) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
    }
}
