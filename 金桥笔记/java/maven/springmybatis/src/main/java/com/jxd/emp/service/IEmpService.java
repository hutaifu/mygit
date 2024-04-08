package com.jxd.emp.service;

import com.jxd.emp.model.Emp;

import java.util.List;

public interface IEmpService {

    /**
     *
     * @param emp
     * @return
     */
    boolean addEmp(Emp emp);
    List<Emp> getAllEmp();
}
