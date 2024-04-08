package com.jxd.stu.dao;

import com.jxd.stu.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {

    /**
     * 查询全部或者按照姓名模糊查询
     * @param sname 查询添加
     * @return
     */
    List<Student> selectStuBySname(String sname);

    /**
     * 分页查询
     * @param sname  过滤条件
     * @param page  当前页码
     * @param limit  每页显示条数
     * @return
     */
    List<Student> selectStuByPage(String sname,int page,int limit);

    /***
     * 根据学号获取一个学生信息
     * @param sno
     * @return
     */
    Student selectOneBySno(int sno);

    boolean addStu(Student student);

    boolean updateStu(Student student);

    List<Map<String,Object>> selectStuWithCls(String sname,int page,int limit);

}
