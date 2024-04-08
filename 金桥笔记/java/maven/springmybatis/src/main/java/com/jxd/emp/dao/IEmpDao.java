package com.jxd.emp.dao;

import com.jxd.emp.model.Emp;

import java.util.List;

public interface IEmpDao {

    boolean addEmp(Emp emp);


    /**
     * 获取所有的员工信息
     * @return 员工集合
     */
    List<Emp> getAllEmp();

}
