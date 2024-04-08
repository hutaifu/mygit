package day02;

/**
 * @ClassName ScoreCalc
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class ScoreCalc {
    double a;
    double b;
    double c;
    public String sum(){
        return "总成绩是:" + (a + b + c);
    }
    public String ava(){
        return "平均成绩是："+(a + b +c) / 3;
    }
}
