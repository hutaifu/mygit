package com.jxd.emp.dao;

import com.jxd.emp.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmpDao {

    /**
     * 获取所有的员工信息
     * @return 员工集合
     */
    List<Emp> getAllEmp();

}
