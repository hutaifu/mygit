package com.jxd.stu.service.impl;

import com.jxd.stu.dao.IClsDao;
import com.jxd.stu.dao.impl.ClsDaoImpl;
import com.jxd.stu.model.Cls;
import com.jxd.stu.service.IClsService;

import java.util.List;

/**
 * @ClassName ClsServiceImpl
 * @Description TODO
 * @Author lixiaoru
 * @Date 2022/9/1
 * @Version 1.0
 */
public class ClsServiceImpl implements IClsService {
    private IClsDao clsDao = new ClsDaoImpl();
    @Override
    public List<Cls> getClsLsit() {
        return clsDao.selectAllCls();
    }
}
