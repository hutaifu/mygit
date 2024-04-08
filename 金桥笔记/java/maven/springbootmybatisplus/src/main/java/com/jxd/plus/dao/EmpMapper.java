package com.jxd.plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.plus.model.Emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper extends BaseMapper<Emp> {
//该接口继承了MP提供的BaseMapper接口，就直接拥有了常用的增删改查抽象方法，都是从父接口继承过来的


/*    *//**
     * 查询员工及其所在部门名称
     * @return
     *//*
    List<Map<String,Object>> getEmpWithDept();*/
    IPage<Map<String,Object>> getEmpWithDept(IPage<Map<String,Object>> page);
}
