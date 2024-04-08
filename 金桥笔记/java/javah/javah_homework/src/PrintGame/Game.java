package PrintGame;

import java.util.Random;



/**
 * @ClassName Game
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/7
 * @Version 1.0
 */

public class Game {
    private Player player;
    private LevelParam levelParam;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LevelParam getLevelParam() {
        return levelParam;
    }

    public void setLevelParam(LevelParam levelParam) {
        this.levelParam = levelParam;
    }

    public Game() {
    }

    public Game(Player player, LevelParam levelParam) {
        this.player = player;
        this.levelParam = levelParam;
    }

    public Game(Player player) {
        this.player = player;
    }

    public String printStr(int n) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();//创建random对象
        StringBuffer buff = new StringBuffer();//StringBuffer
        for (int i = 0; i < n; i++) {
            int it = r.nextInt(62);//使用random生成[0,62)之间的随机数,不包括62
            buff.append(str.charAt(it));// 把int下标 转为 str中随机字符(数字，大写字母或者小写字母)
        }
        System.out.println(buff.toString());
        return buff.toString();
    }

    public void printResult(String out,String in){
        if (out.equals(in) && player.getElapsedTime() < levelParam.getLevel()[player.getLeveLNo()].getTimeLimit()){
            player.setCurrScore(player.getCurrScore() + levelParam.getLevel()[player.getLeveLNo()].getPerScore());
            System.out.println("输入正确,你的级别为：" + player.getLeveLNo() + "你的积分为" + player.getCurrScore() +
                    "已用时" + player.getElapsedTime() + "秒");
        } else if (player.getElapsedTime() > levelParam.getLevel()[player.getLeveLNo()].getTimeLimit()){
            System.out.println("你输入太慢了，已经超时，退出！");
            System.exit(0);
        }else {
            System.out.println("输入错误，退出！");
            System.exit(1);
        }
    }
}
