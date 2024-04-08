package day09;

/**
 * @ClassName Happennum
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Happennum {
    public void happenNum(String string,String str1){
        int num = 0;
        int bgeanin = 0;
        do {
            bgeanin = string.indexOf(str1,bgeanin);
            if (bgeanin != - 1){
                num++;
                bgeanin += 1;
            }
        }while (bgeanin !=  -1);
        System.out.println( string + "中包含" + num + "个" + str1);
    }
}
