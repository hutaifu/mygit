package com.jxd.student.dao;

import com.jxd.student.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    /**
     * 分页查询
     * @param sname 条件
     * @param count 当前页码
     * @param limit 每页显示条数
     * @return
     */
    List<Map<String,Object>> selectByPage(@Param("sname") String sname, @Param("count") int count, @Param("limit") int limit);

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
