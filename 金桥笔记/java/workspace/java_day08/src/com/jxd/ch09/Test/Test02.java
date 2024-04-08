package com.jxd.ch09.Test;

import com.jxd.ch09.model.Student;
import com.jxd.ch09.service.IStudentService;
import com.jxd.ch09.service.impl.StudentServiceImpl;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        String name = "关羽";
        String sex = "男";
        String birthday = "1900-01-02";

        Student stu = new Student();
        stu.setSname(name);
        stu.setSsex(sex);
        stu.setBirthday(birthday);

        //注册工具
        //创建业务逻辑层对象
        IStudentService studentService = new StudentServiceImpl();
        boolean isSuccess = studentService.register(stu);
        if (isSuccess){
            System.out.println("注册成功");
        }

    }
}
