package day09;

/**
 * @ClassName Vip
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Vip {
    public boolean firm(String id,String phonum, String localnum){
        boolean boo1 = true;
        boolean boo2 = true;
        boolean boo3 = true;

        if (id.length() != 16 && id.length() != 18){
            System.out.print("身份证号必须是16位或18位");
            boo1 = false;
        }
        if (phonum.length() != 11){
            System.out.println("手机号必须是11位");
            boo2 = false;
        }
        if (localnum.indexOf("-") != 4 && localnum.length() != 11){
            System.out.println("座机号码区号必须为4位，电话号码必须是7位！");
            boo3 = false;
        }
        return boo1 && boo2 && boo3;
    }
}
