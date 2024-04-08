package com.jxd.student.service;


import com.jxd.student.model.Student;

import java.util.List;

public interface IStudentService {

    /**
     * 查询全部学生信息
     * @return
     */
    List<Student> selectAll(String key);

    /**
     * 增加学生
     * @param student 增加的学生对象
     * @return 是否成功
     */
    boolean add(Student student);

    /**
     * 删除学生信息
     * @param nums 删除学生学号数组
     * @return 是否成功
     */
    boolean del(int[] nums);

    /**
     * 修改学生信息
     * @param student 修改后的学生
     * @return 是否成功
     */
    boolean upd(Student student);



}
