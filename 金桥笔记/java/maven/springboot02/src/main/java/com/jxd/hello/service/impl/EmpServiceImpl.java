package com.jxd.hello.service.impl;

import com.jxd.hello.dao.EmpMapper;
import com.jxd.hello.model.Emp;
import com.jxd.hello.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/15
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Emp> getAll() {
        return empMapper.selectAll();
    }
}
