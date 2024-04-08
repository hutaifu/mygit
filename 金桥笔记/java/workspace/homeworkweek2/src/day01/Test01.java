package day01;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        Administrator admin1 = new Administrator();
        Administrator admin2 = new Administrator();
        admin1.name ="admin1";
        admin2.name = "admin2";
        admin1.pwt = "111111";
        admin2.pwt = "222222";
        admin1.show();
        admin2.show();
    }
}
