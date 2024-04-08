package com.jxd.student.service.impl;

import com.jxd.student.dao.IStudentDao;
import com.jxd.student.model.Student;
import com.jxd.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StuentServiceimpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/29
 * @Version 1.0
 */
@Service
public class StuentServiceimpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;


    @Override
    public List<Map<String, Object>> getStuByPage(String sname, int page, int limit) {
        return studentDao.selectByPage(sname,(page - 1) * limit,limit);
    }

    /**
     * 根据主键获取学生信息
     *
     * @param sno
     * @return
     */
    @Override
    public Student getOneBySno(int sno) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getStrwithCls(String sname, int page, int limit) {
        return null;
    }
}
