package ch06work01;

import java.util.*;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/7
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        Student student = new Student("小明","男","001",12);
        Student student1 = new Student("张三","男","002",13);
        Student student2 = new Student("李四","女","003",12);
        List<Student> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        Collections.addAll(list,student,student1,student2);

        System.out.println("请选择操作：（1.添加2.查找3.删除.4.显示）");
        try {
            int num = input.nextInt();
            switch (num){
                case 1:
                    Student student3 = new Student();
                    System.out.println("请输入添加学生的姓名");
                    student3.setName(input.next());
                    System.out.println("请输入添加学生的学号");
                    student3.setName(input.next());
                    System.out.println("请输入添加学生的性别");
                    student3.setSex(input.next());
                    System.out.println("请输入添加学生的年龄");
                    student3.setAge(input.nextInt());
                    list.add(student3);
                    break;
                case 2:
                    System.out.println("请输入查找学生学号");
                    String s1 = input.next();
                    for (Student s : list) {
                        if (s.getNo() == s1){
                            System.out.println("找到该学生");
                            s.showinfo();
                            break;
                        }
                    }
                case 3:
                    System.out.println("请输入删除学生学号");
                    String s4 = input.next();
                    for (Student s5: list) {
                        if (s5.getNo() == s4){
                            list.remove(s5);
                        }
                    }
                case 4:
                    for (Student stu: list) {
                        stu.showinfo();
                    }
            }
        } catch (Exception e){
            System.out.println("出现错误");
        }finally {
            System.out.println("感谢使用");
        }





    }
}
