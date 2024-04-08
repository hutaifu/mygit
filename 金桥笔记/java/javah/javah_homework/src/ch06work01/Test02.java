package ch06work01;

import java.util.*;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/7
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
            Student student = new Student("小明","男","001",12);
            Student student1 = new Student("张三","男","002",13);
            Student student2 = new Student("李四","女","003",12);
            Map<String,Student> map = new HashMap<>();
            Scanner input = new Scanner(System.in);

            map.put(student.getNo(),student);
            map.put(student1.getNo(),student1);
            map.put(student2.getNo(),student2);

            System.out.println("请选择操作：（1.添加2.查找3.删除.4.显示）");
            try {
                int num = input.nextInt();
                switch (num) {
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
                        map.put(student3.getNo(), student3);
                        break;
                    case 2:
                        System.out.println("请输入查找学生学号");
                        String s1 = input.next();
                        if (map.containsKey(s1)) {
                            map.get(s1);
                        }
                    case 3:
                        System.out.println("请输入删除学生学号");
                        String s4 = input.next();
                        if (map.containsKey(s4)) {
                            map.remove(s4);
                        }
                    case 4:
                        System.out.println(map);
                        break;
                }
            } catch (Exception e){
                System.out.println("出现错误");
            }finally {
                System.out.println("感谢使用");
            }





        }
    }

