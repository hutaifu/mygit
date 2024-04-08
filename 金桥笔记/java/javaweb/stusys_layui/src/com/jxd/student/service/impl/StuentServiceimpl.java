package com.jxd.student.service.impl;

import com.jxd.student.dao.IStudentDao;
import com.jxd.student.dao.impl.StudentDaoImpl;
import com.jxd.student.model.Student;
import com.jxd.student.service.IStudentService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StuentServiceimpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/29
 * @Version 1.0
 */

public class StuentServiceimpl implements IStudentService {
    private IStudentDao studentDao = new StudentDaoImpl();
    /**
     * 查询学生信息
     *
     * @param sname
     * @return
     */
    @Override
    public List<Student> getStuBySname(String sname) {
        return studentDao.selectStuSname(sname);
    }

    @Override
    public List<Student> getStuByPage(String sname, int page, int limit) {
        return studentDao.selectByPage(sname,page,limit);
    }

    /**
     * 根据主键获取学生信息
     *
     * @param sno
     * @return
     */
    @Override
    public Student getOneBySno(int sno) {
        return studentDao.selectOneBySno(sno);
    }

    @Override
    public List<Map<String, Object>> getStrwithCls(String sname, int page, int limit) {
        return studentDao.selectStuWithCls(sname,page,limit);
    }


}
