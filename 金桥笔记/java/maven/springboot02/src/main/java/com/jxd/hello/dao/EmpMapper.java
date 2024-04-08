package com.jxd.hello.dao;

import com.jxd.hello.model.Emp;

import java.util.List;

public interface EmpMapper {
    /**
     * 获取全部的员工信息
     * @return
     */
    List<Emp> selectAll();
}
