package com.jxd.student.service;


import com.jxd.student.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {


    List<Map<String,Object>> getStuByPage(String sname, int page, int limit);

    /**
     * 根据主键获取学生信息
     * @param sno
     * @return
     */
    Student getOneBySno(int sno);

    List<Map<String,Object>> getStrwithCls(String sname, int page, int limit);
}
