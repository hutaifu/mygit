package ch12;

/**
 * @ClassName TestStu
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestStu {
    public static void main(String[] args) {
        StudentBiz studentBiz = new StudentBiz();
        studentBiz.addName("张三");
        studentBiz.addName("李四");
        studentBiz.changeName("张三","王五");
//        展示学生信息
        studentBiz.showName();
        StudentBiz studentBiz101 = new StudentBiz();
        studentBiz101.addName("刘备");
        studentBiz101.addName("关羽");

    }
}
