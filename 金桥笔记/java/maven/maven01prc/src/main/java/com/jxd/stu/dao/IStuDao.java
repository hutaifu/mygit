package com.jxd.stu.dao;

import com.jxd.stu.model.Stu;

import java.util.List;

public interface IStuDao {

    /**
     * 查询所有学生信息
     * @return 学生集合
     */
    List<Stu> getAllStu();
}
