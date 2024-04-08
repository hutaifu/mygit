package PrintGame;

/**
 * @ClassName Player
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/7
 * @Version 1.0
 */

public class Player {
    private int leveLNo;
    private int currScore;
    private long startTime;
    private int elapsedTime;

    public int getLeveLNo() {
        return leveLNo;
    }

    public void setLeveLNo(int leveLNo) {
        this.leveLNo = leveLNo;
    }

    public int getCurrScore() {
        return currScore;
    }

    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Player() {
    }

    public Player(int leveLNo, int currScore, long startTime, int elapsedTime) {
        this.leveLNo = leveLNo;
        this.currScore = currScore;
        this.startTime = startTime;
        this.elapsedTime = elapsedTime;
    }

    public void play(){

    }
}
