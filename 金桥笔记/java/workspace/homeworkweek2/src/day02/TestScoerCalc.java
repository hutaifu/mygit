package day02;

/**
 * @ClassName TestScoerCalc
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestScoerCalc {
    public static void main(String[] args) {
    ScoreCalc scoreCalc = new ScoreCalc();
    scoreCalc.a = 90;
    scoreCalc.b = 65;
    scoreCalc.c = 75;
        System.out.print(scoreCalc.sum());
        System.out.println(scoreCalc.ava());
    }
}
