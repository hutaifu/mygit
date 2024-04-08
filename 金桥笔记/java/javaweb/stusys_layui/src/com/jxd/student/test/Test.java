package com.jxd.student.test;

import com.jxd.student.dao.IClsDao;
import com.jxd.student.dao.impl.ClsDaoImpl;
import com.jxd.student.model.Cls;

import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/1
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        IClsDao clsDao = new ClsDaoImpl();
        List<Cls> list = clsDao.selectAllCls();
    }
}
