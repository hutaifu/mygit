package com_jxdch10;

/**
 * @ClassName School
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class School {
    String name ;
    int classroomcount ;
    int labCount;
    public void showInfo(){
        System.out.println("学校名称是："+name);
        System.out.println("教室数量为："+classroomcount);
        System.out.println("机房数量为:"+labCount);
    }
}
