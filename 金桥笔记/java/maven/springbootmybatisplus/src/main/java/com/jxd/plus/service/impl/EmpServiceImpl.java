package com.jxd.plus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.plus.dao.EmpMapper;
import com.jxd.plus.model.Emp;
import com.jxd.plus.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/16
 * @Version 1.0
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

    @Autowired
    EmpMapper empMapper;


    @Override
    public IPage<Map<String,Object>> getEmpWithDept(IPage<Map<String,Object>> page) {
        return empMapper.getEmpWithDept(page);
    }
}
