package com.jxd.emp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.emp.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper extends BaseMapper<Emp> {
    IPage<Map<String,Object>>  getAllEmpList(IPage<Emp> page,@Param("ename") String ename,@Param("deptno") int deptno);

    List<Emp> getMgrList(@Param("empno") Integer empno);
}
