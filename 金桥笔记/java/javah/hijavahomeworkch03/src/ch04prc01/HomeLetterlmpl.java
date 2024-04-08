package ch04prc01;

/**
 * @ClassName Letter
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class HomeLetterlmpl implements IHomeLetter {
    @Override
    public String writeTitle() {
        return "亲爱的爸爸，妈妈：";
    }

    @Override
    public String writeHello() {
        return " 你们好吗？";
    }

    @Override
    public String writeBody() {
        return "\n 我在这边挺好的。\n 我会努力学习的，已经学到java OOP啦！";
    }

    @Override
    public String writeGreeting() {
        return " 您二老保重身体啊!";
    }

    @Override
    public String writeSelft() {
        return "\n 此致\n敬礼\n\t\t\t周杰\n\t2010年6月1日";
    }
}
