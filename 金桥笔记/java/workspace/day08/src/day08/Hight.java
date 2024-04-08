package day08;

/**
 * @ClassName Hight
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/20
 * @Version 1.0
 */

public class Hight {
    public void add(String num,double height,Student[] students){
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null){
                students[i].num = num;
                students[i].heingt = height;
            }
        }
    }
    public String findMax(double heinght,Student[] students){
        String sr = "";

        for (int i = 0; i < students.length; i++) {
            if (students[i].heingt == heinght){
               sr = students[i].num;
            }

        }
        return sr;
    }
}
