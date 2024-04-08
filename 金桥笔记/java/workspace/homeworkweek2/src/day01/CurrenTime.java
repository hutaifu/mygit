package day01;

import java.sql.Timestamp;

/**
 * @ClassName CurrenTime
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/18
 * @Version 1.0
 */

public class CurrenTime {
    public void show(){
        long startTime = System.currentTimeMillis();
        Timestamp now1 = new Timestamp(startTime);
        System.out.println("now1:" + now1);
    }

}
