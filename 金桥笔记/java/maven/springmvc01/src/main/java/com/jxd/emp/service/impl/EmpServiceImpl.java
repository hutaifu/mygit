package com.jxd.emp.service.impl;

import com.jxd.emp.dao.IEmpDao;
import com.jxd.emp.model.Emp;
import com.jxd.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/9
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    IEmpDao empDao;



    @Override
    public List<Emp> getAllEmp() {
        return empDao.getAllEmp();
    }



}
