package com.jxd.student.dao;

import com.jxd.student.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {

    /**
     * 查询全部或者按照姓名模糊查询
     * @param sname 查询添加
     * @return
     */
    List<Student> selectStuSname(String sname);

    /**
     * 分页查询
     * @param sname 条件
     * @param page 当前页码
     * @param limit 每页显示条数
     * @return
     */
    List<Student> selectByPage(String sname,int page,int limit);

    /**
     * 根据学号获取学生信息
     * @param sno
     * @return
     */
    Student selectOneBySno(int sno);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    boolean addStu(Student student);

    List<Map<String,Object>> selectStuWithCls(String name, int page, int limit);
}
