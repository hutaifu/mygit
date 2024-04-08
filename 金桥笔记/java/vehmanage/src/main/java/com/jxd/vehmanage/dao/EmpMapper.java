package com.jxd.vehmanage.dao;

import com.jxd.vehmanage.model.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {

    /**
     * 查询单个员工
     * @param empno 员工编号
     * @return 员工对象
     */
    Emp selectEmp(@Param("empno") int empno);
}
