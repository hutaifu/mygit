package Guessboxing;

/**
 * @ClassName Game
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Game {
    public void initial(){
        System.out.println("*********************欢迎进入游戏世界*******************\n\n\n");
        System.out.println("*******************");
        System.out.println("**   猜拳，开始  **");
        System.out.println("*******************\n\n\n");
    }
    public String starGame(int num){
        String str2 = "";
        switch (num){
            case 1:
                str2 = "刘备";
                System.out.println("你选择了刘备对战");
                break;
            case 2:
                str2 = "孙权";
                System.out.println("你选择了孙权对战");
                break;
            case 3:
                str2 = "曹操";
                System.out.println("你选择了曹操对战");
                break;
            default:
                System.out.println("选择错误");
        }
        return str2;
    }

}
