package com.jxd.plus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.plus.model.Emp;

import java.util.List;
import java.util.Map;

public interface IEmpService extends IService<Emp> {


    IPage<Map<String,Object>> getEmpWithDept(IPage<Map<String,Object>> page);
}
