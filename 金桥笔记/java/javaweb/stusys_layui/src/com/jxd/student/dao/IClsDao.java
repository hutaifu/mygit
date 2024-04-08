package com.jxd.student.dao;

import com.jxd.student.model.Cls;

import java.util.List;

public interface IClsDao {

    /**
     * 获取所有的班级信息
     * @return
     */
    List<Cls> selectAllCls();
}
