package com.jxd.ch09.service;

import com.jxd.ch09.model.Student;

public interface IStudentService {
    //声明业务操作
    boolean register(Student student);

    boolean deleteStu(int stuno);
}
