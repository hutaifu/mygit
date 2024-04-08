package day02;

/**
 * @ClassName CustomerBiz
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class CustomerBiz {
    String[] names = new String[10];
    public void addName(String name){
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null){
                names[i] = name;
                break;
            }
        }
    }
    public void showNames(){
        System.out.println("客户姓名列表：");
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null){
                System.out.print(names[i]+"\t\t");
            }

        }
    }
    public void findname(String name){
        for (int i = 0; i < names.length; i++) {
            if (name.equals(names[i])){
                System.out.println("查找结果");
                System.out.println("找到了");
            }
        }
    }
}
