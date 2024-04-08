package PrintGame;

/**
 * @ClassName Level
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/7
 * @Version 1.0
 */

public class Level {
    private int leveNo;
    private int strLength;
    private int strTime;
    private int timeLimit;
    private int perScore;

    public int getLeveNo() {
        return leveNo;
    }

    public void setLeveNo(int leveNo) {
        this.leveNo = leveNo;
    }

    public int getStrLength() {
        return strLength;
    }

    public void setStrLength(int strLength) {
        this.strLength = strLength;
    }

    public int getStrTime() {
        return strTime;
    }

    public void setStrTime(int strTime) {
        this.strTime = strTime;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getPerScore() {
        return perScore;
    }

    public void setPerScore(int perScore) {
        this.perScore = perScore;
    }

    public Level() {
    }

    public Level(int leveNo, int strLength, int strTime, int timeLimit, int perScore) {
        this.leveNo = leveNo;
        this.strLength = strLength;
        this.strTime = strTime;
        this.timeLimit = timeLimit;
        this.perScore = perScore;
    }
}
