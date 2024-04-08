package com.jxd.student.test;

import com.jxd.student.model.Student;
import com.jxd.student.service.IStudentService;
import com.jxd.student.service.impl.StudentServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/28
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
      IStudentService studentService = new StudentServiceImpl();
      List<Student> list = studentService.selectAll("云");
        System.out.println(list.get(0).getSname());

    }
}
