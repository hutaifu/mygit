package com.jxd.ch09.emp.dao;

import com.jxd.ch09.emp.vo.EmpWithDeptVO;

import java.util.List;
import java.util.Map;

public interface IEmpDao {
    //员工本身的增删改，只涉及员工表


    //查询员工信息和其所在部门名称
    List<Map<String,Object>> selectEmpwithDept(String name);

    List<EmpWithDeptVO> selectEmpWithDept02();


}
