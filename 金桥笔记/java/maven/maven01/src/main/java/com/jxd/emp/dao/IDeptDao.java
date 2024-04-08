package com.jxd.emp.dao;

import com.jxd.emp.model.Dept;

import java.util.List;

public interface IDeptDao {

    /**
     * 查询所有部门 部门与员工是1对多的关系，员工集合作为部门的属性
     * @return
     */
    List<Dept> getAllDept();

    /**
     * 查询部门根据编号
     * @param deptno
     * @return 部门
     */
    Dept getDeptByDno(int deptno);
}
