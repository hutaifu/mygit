package com.jxd.ch09.dao;

import com.jxd.ch09.model.Student;

import java.util.List;

public interface IStudentDao {
    /**
     * 新增学生
     * @param student   学生对象
     * @return 是否新增成功
     */
    boolean insert(Student student);

    /**
     * 查询全部学生信息
     * @return
     */

    List<Student> selectAll();

    /**
     * 更新学生信息
     * @param student 学生全部信息
     * @return
     */
    boolean update(Student student);

    /**
     * 根据主键删除员工信息
     * @param stuno
     * @return
     */
    boolean delete(int stuno);

    /**
     * 批量删除
     * @param stunos 多个学号信息
     * @return
     */
    boolean deleteBatch(int[] stunos);
}
