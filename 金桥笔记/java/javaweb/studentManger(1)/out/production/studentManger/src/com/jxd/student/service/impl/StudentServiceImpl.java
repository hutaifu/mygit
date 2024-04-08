package com.jxd.student.service.impl;

import com.jxd.student.dao.IStudentDao;
import com.jxd.student.dao.impl.StudentDaoImpl;
import com.jxd.student.model.Student;
import com.jxd.student.service.IStudentService;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/25
 * @Version 1.0
 */

public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao = new StudentDaoImpl();
    /**
     * 查询学生信息
     *
     * @return 学生列表
     */
    @Override
    public List<Student> selectAll(String key) {
        return studentDao.selectAll(key);
    }

    /**
     * 增加学生
     *
     * @param student 增加的学生对象
     * @return 是否成功
     */
    @Override
    public boolean add(Student student) {
        return studentDao.insert(student);
    }

    /**
     * 删除学生信息
     *
     * @param nums 删除学生学号数组
     * @return 是否成功
     */
    @Override
    public boolean del(int[] nums) {
        return studentDao.delet(nums);
    }

    /**
     * 修改学生信息
     *
     * @param student 修改后的学生
     * @return 是否成功
     */
    @Override
    public boolean upd(Student student) {
        return studentDao.set(student.getSno(),student);
    }
}
