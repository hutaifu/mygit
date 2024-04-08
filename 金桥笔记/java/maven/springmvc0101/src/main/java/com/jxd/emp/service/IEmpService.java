package com.jxd.emp.service;

import com.jxd.emp.model.Emp;

import java.util.List;

public interface IEmpService {

    List<Emp> getAllEmp();

    List<Emp> getAllEmpByPage(int pageindex, int pageSize);
}
