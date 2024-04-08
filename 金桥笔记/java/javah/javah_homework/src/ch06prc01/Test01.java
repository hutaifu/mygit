package ch06prc01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/5
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        Penguin penguin = new Penguin("大Q");
        List<Penguin> list = new ArrayList<>();

        Collections.addAll(list,new Penguin("小Q"),penguin,new Penguin("中Q"));
        System.out.println(list.size());
        for (Penguin pen : list ) {
            System.out.println(pen.getName());
        }

        list.remove(0);

        if (list.contains(penguin)){
            System.out.println("包含大Q");
        }

        for (Penguin p : list) {
            if (p.getName() == "中Q"){
                p.showinfo();
                break;
            }
        }
    }
}
