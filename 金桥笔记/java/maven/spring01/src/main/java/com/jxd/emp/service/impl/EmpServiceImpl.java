package com.jxd.emp.service.impl;

import com.jxd.emp.dao.IEmpDao;
import com.jxd.emp.dao.impl.EmpDaoImpl;
import com.jxd.emp.model.Emp;
import com.jxd.emp.service.IEmpService;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/8
 * @Version 1.0
 */

public class EmpServiceImpl implements IEmpService {
//  private IEmpDao empDao = new EmpDaoImpl();
    private IEmpDao empDao;


    /**
     * @param emp
     * @return
     */
    @Override
    public boolean addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }

    public IEmpDao getEmpDao() {
        return empDao;
    }

    public void setEmpDao(IEmpDao empDao) {
        this.empDao = empDao;
    }
}
