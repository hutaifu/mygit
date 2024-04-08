package com.jxd.emp.dao.impl;

import com.jxd.emp.dao.IEmpDao;
import com.jxd.emp.model.Emp;
import org.springframework.stereotype.Repository;

/**
 * @ClassName EmpDaoImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/8
 * @Version 1.0
 */



/*
* 注解在dao层实现类上，用不上
*
* */
@Repository
public class EmpDaoImpl implements IEmpDao {
    @Override
    public boolean addEmp(Emp emp) {
        return true;
    }
}
