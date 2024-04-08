package day02;

import java.util.Scanner;
import java.util.jar.JarEntry;

/**
 * @ClassName Menu
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class Menu {
//        各级菜单的返回
//        几个菜单，几个方法
    public String getOneMenu(){
        String menu = "****欢迎登录*****\n";
                menu += "1.登录\n2.注册\n";
                return menu;
    }
    public String getTwomenu(){
        String menu = "";
                menu += "";
                return menu;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
//        输出初始菜单
        String menuone = menu.getOneMenu();
        System.out.println(menuone);
        System.out.println("请选择菜单");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                String menTwo = menu.getTwomenu();
        }

    }

}



