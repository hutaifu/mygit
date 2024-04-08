package com.jxd.ch09.emp.service.impl;

import com.jxd.ch09.emp.dao.IEmpDao;
import com.jxd.ch09.emp.dao.impl.EmpDaoImpl;
import com.jxd.ch09.emp.service.IEmpService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class EmpServiceImpl implements IEmpService {
    /**
     * 查询员工信息和其部门名称
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> selectEmpinfo(String name) {
        IEmpDao empDao = new EmpDaoImpl();
        return empDao.selectEmpwithDept(name);
    }
}
