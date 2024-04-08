package ch06prc01;

import java.util.*;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/7
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        List<Penguin> list = new ArrayList<>();
        LinkedList<Penguin> linkedList = new LinkedList<>();

        Collections.addAll(linkedList,new Penguin("小Q"),new Penguin("中Q"),new Penguin("大Q"));
        Collections.addAll(list,new Penguin("小Q"),new Penguin("中Q"),new Penguin("大Q"));

        Iterator it = linkedList.iterator();
        while (it.hasNext()){
            Penguin penguin = (Penguin)it.next();
            System.out.println(penguin.getName());
        }

        Iterator<Penguin> it1 = list.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next().getName());
        }

    }
}
