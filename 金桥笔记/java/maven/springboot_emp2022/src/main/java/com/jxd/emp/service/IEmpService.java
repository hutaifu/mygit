package com.jxd.emp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.emp.model.Emp;

import java.util.List;
import java.util.Map;

public interface IEmpService extends IService<Emp> {
    Map<String, Object> getAllEmpList(Map<String,String> map);

    List<Emp> getMgrList(String empno);
}
