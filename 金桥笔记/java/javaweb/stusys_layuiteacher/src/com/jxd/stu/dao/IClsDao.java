package com.jxd.stu.dao;

import com.jxd.stu.model.Cls;

import java.util.List;

/**
 * @ClassName IClsDao
 * @Description TODO
 * @Author lixiaoru
 * @Date 2022/9/1
 * @Version 1.0
 */
public interface IClsDao{
    /**
     * 获取所有的班级信息
     * @return
     */
    List<Cls> selectAllCls();
}
