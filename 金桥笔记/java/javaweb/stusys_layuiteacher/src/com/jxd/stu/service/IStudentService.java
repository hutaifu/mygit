package com.jxd.stu.service;

import com.jxd.stu.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    /**
     * 通过姓名获取学生信息
     * @param sname
     * @return
     */
    List<Student> getStuBySname(String sname);

    /**
     * 分页查询
     * @param sname
     * @param page
     * @param limit
     * @return
     */
    List<Student> getStuByPage(String sname,int page,int limit);

    /**
     * 根据主键获取学生信息
     * @param sno
     * @return
     */
    Student getOneBySno(int sno);

    /***
     * 查询所有的学生信息及其班级名称
     * @param sname
     * @param page
     * @param limit
     * @return
     */
    List<Map<String,Object>> getStuWithCls(String sname,int page,int limit);
}
