package ch12;

/**
 * @ClassName StudentBiz
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class StudentBiz {
//    属性，用于代表小组中的位置
    String[] names = new String[10];
    public void addName(String name){
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null){
                names[i] = name;
                break;
            }

        }

    }
    public void showName(){
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null){
                break;
            }
            System.out.println(names[i]);

        }
    }
//    修改学生姓名
    public void changeName(String oldname,String newname){
        boolean isFind = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null){
                break;
            }
            if (oldname .equals(null)){
                names[i] = newname;
                isFind = true;
                break;
            }
        }
        if (isFind){
            System.out.println("未找到");


        }
    }

}
