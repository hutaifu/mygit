package com.jxd.student.service.impl;

import com.jxd.student.dao.IClsDao;
import com.jxd.student.model.Cls;
import com.jxd.student.service.IClsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ClsServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/1
 * @Version 1.0
 */
@Service
public class ClsServiceImpl implements IClsService {
    @Autowired
    private IClsDao clsDao;
    /**
     * 获取班级列表
     *
     * @return
     */
    @Override
    public List<Cls> getClsList() {
        return clsDao.selectAllCls();
    }
}
