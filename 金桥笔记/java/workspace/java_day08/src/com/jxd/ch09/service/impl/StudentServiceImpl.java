package com.jxd.ch09.service.impl;

import com.jxd.ch09.dao.IStudentDao;
import com.jxd.ch09.dao.impl.StudentImpl;
import com.jxd.ch09.model.Student;
import com.jxd.ch09.service.IStudentService;

/**
 * @ClassName StudentServicelmpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao = new  StudentImpl();

    @Override
    public boolean register(Student student) {
        //创建dao层对象，调用方法，传参，接收返回值
        IStudentDao studentDao = new StudentImpl();
        boolean isSuccesss = studentDao.insert(student);
        return isSuccesss;
    }

    @Override
    public boolean deleteStu(int stuno) {
        return studentDao.delete(stuno);
    }
}
