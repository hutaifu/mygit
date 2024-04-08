package com.jxd.student.service;

import com.jxd.student.model.Cls;

import java.util.List;

public interface IClsService {

    /**
     * 获取班级列表
     * @return
     */
    List<Cls> getClsList();
}
