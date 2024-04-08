package ch04prc01;

/**
 * @ClassName Write
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Write {
    public void show(HomeLetterlmpl letter){
        System.out.println(letter.writeTitle());
        System.out.println(letter.writeHello());
        System.out.println(letter.writeBody());
        System.out.println(letter.writeGreeting());
        System.out.println(letter.writeSelft());
    }
}
