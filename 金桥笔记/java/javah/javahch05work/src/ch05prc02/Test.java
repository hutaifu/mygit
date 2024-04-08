package ch05prc02;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Peson peson = new Peson();
        try{
            peson.setAge(444);
        }catch (Exception e){
            System.out.println("年龄异常");
        }
    }
}
