package com.jxd.stu.service.impl;

import com.jxd.stu.dao.IStudentDao;
import com.jxd.stu.dao.impl.StudentDaoImpl;
import com.jxd.stu.model.Student;
import com.jxd.stu.service.IStudentService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author lixiaoru
 * @Date 2022/8/29
 * @Version 1.0
 */
public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao = new StudentDaoImpl();


    @Override
    public List<Student> getStuBySname(String sname) {
        return studentDao.selectStuBySname(sname);
    }

    @Override
    public List<Student> getStuByPage(String sname, int page, int limit) {
        return studentDao.selectStuByPage(sname,page,limit);
    }

    @Override
    public Student getOneBySno(int sno) {
        return studentDao.selectOneBySno(sno);
    }

    @Override
    public List<Map<String, Object>> getStuWithCls(String sname, int page, int limit) {
        return studentDao.selectStuWithCls(sname, page, limit);
    }
}
