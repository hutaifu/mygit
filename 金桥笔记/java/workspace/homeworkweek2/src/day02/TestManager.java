package day02;

/**
 * @ClassName TestManager
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestManager {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.pwt = "0000";
        manager.name = "jadebird";
        System.out.println(manager.show());
    }
}
