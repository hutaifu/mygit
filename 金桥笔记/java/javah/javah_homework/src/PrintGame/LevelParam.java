package PrintGame;

/**
 * @ClassName LevelParam
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/7
 * @Version 1.0
 */

public class LevelParam {
    private Level[] level= new Level[6];

    public Level[] getLevel() {
        return level;
    }

    public void setLevel(Level[] level) {
        this.level = level;
    }

    {
        for (int i = 0; i < 6; i++) {
            level[i] = new Level();
            level[i].setLeveNo(i);
            level[i].setStrTime((i + 1) * 10);
            level[i].setPerScore(i+1);
            level[i].setStrLength(i+1);
            level[i].setTimeLimit(30- i);
        }
    }

    public LevelParam() {
    }

    public LevelParam(Level[] level) {
        this.level = level;
    }
}
