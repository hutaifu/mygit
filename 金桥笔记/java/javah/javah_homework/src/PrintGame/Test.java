package PrintGame;

import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/7
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner input = new Scanner(System.in);
        game.setLevelParam(new LevelParam());
        game.setPlayer(new Player());

        for (int i = 0; i < game.getLevelParam().getLevel().length; i++) {
            game.getPlayer().setStartTime(System.currentTimeMillis() / 1000);
            game.getPlayer().setCurrScore(0);
            for (int j = 0; j < game.getLevelParam().getLevel()[game.getPlayer().getLeveLNo()].getStrTime(); j++) {
                String s = game.printStr(game.getLevelParam().getLevel()[game.getPlayer().getLeveLNo()].getStrLength());
                try {
                    String s1 = input.next();
                    game.getPlayer().setElapsedTime((int)((System.currentTimeMillis() / 1000 - game.getPlayer().getStartTime())));
                    game.printResult(s, s1);
                } catch (Exception e) {
                    System.out.println("出现错误");
                    System.exit(1);
                }
            }
            game.getPlayer().setLeveLNo(game.getPlayer().getLeveLNo() + 1);

        }

        System.out.println("恭喜你成功通关");
    }
}
