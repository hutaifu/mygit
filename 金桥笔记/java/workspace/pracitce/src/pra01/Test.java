package pra01;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Test {
    static void p(ArrayList al){
        al.add(2);
        for (Object b:al) {
            System.out.println(b);
        }
        al = new ArrayList();
        al.add(3);
        al.add(4);
        for (Object b:al) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        ArrayList al = new ArrayList();
        al.add(1);
        for (Object b:al) {
            System.out.println(b);
        }
        p(al);
        for (Object b:al) {
            System.out.println(b);
        }
        System.out.println(al.get(0));
    }

}
