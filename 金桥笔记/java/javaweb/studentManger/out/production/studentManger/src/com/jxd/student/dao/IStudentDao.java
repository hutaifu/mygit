package com.jxd.student.dao;


import com.jxd.student.model.Student;

import java.util.List;

public interface IStudentDao {

    /**
     * 查询全部学生信息
     * @return 学生对象集合
     */
    List<Student> selectAll(String key);

    /**
     * 增加学生
     * @param student 要增加的学生对象
     * @return 是否成功
     */
    boolean insert(Student student);

    /**
     * 删除学生
     * @param nums 删除学生学号
     * @return 是否成功
     */
    boolean delet(int[] nums);

    /**
     * 修改学生
     * @param num 学号
     * @param student 修改后学生
     * @return 是否成功
     */
    boolean set(int num,Student student);

    /**
     * 查询单个学生
     * @param sno 学号
     * @return 学生
     */
    Student getOne(int sno);

}
