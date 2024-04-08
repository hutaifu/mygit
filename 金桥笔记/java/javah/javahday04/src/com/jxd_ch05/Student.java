package com.jxd_ch05;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Student {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws Exception {
        if ("男".equals(sex) || "女".equals(sex)){
            this.sex = sex;
        } else {
            //创建自定义的异常对象，定义堆栈信息
            //并抛出异常对象
            throw new Exception("性别只能是男或者女");
        }

    }
}
