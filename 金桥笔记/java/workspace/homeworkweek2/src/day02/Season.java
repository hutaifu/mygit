package day02;

/**
 * @ClassName Season
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class Season {
    public String get(int month){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return "这个月有31天";
            case 4:
            case 6:
            case 9:
            case 11:
                return "这个月有30天";
            case 2:
                return "这个月有29或者28天";
            default:
                return "输入错误";
        }
    }
}
