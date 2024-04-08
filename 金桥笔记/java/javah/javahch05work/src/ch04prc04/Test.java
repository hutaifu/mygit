package ch04prc04;

import org.apache.log4j.Logger;

import java.util.Random;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Test {
    public static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[1] = "ab";
        strings[2] = "ab";
        Random random = new Random();
        int num = random.nextInt(5);
        logger.info("产生的随机数是" + num);

        try{
            if (strings[num].equals("ab")){
                if (strings[num+1].equals("ab")){
                    Animal dog = new Dog();
                    ((Cat)dog).equals("");
                }else {
                    throw new ClassNotFoundException("能到这一步，你运气真好！");
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            logger.error("超出数组长度");
            logger.error(e.getMessage());
            e.printStackTrace();
        }catch (NullPointerException e){
            logger.error("调用了空对象的属性或方法");
            logger.error(e.getMessage());
            e.printStackTrace();
        }catch (ClassCastException e){
            logger.error("数据类型转换错误");
            logger.error(e.getMessage());
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            logger.error("自动抛出这个异常");
            logger.error(e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            logger.error("出现未考虑错误");
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("感谢使用本程序");
        }
    }
}
