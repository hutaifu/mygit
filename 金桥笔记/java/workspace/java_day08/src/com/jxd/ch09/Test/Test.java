package com.jxd.ch09.Test;

import com.jxd.ch09.model.Student;
import com.jxd.ch09.dao.IStudentDao;
import com.jxd.ch09.dao.impl.StudentImpl;

import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        /*String sname = "张飞";
        String ssex = "男";
        String birthday = "1999-01-03";

        //封装对象
        Student stu = new Student();
        stu.setSname(sname);
        stu.setSsex(ssex);
        stu.setBirthday(birthday);*/

        IStudentDao studentDao = new StudentImpl();
      /*  boolean isSuccess = studentDao.insert(stu);
        if (isSuccess){
            System.out.println("新增成功");*/
      List<Student> list = studentDao.selectAll();
        for (Student s: list) {
            System.out.println(s.getSname());
        }
        int[] stuno = {1,2};
        boolean isSuccess = studentDao.deleteBatch(stuno);



    }
}
