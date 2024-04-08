package day09;

/**
 * @ClassName Register
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/21
 * @Version 1.0
 */

public class Register {
    public boolean verify(String name,String pwt01,String pwt02){
        if (name.length() >= 3 && pwt01 .equals(pwt02) && pwt01.length() >= 6){
            System.out.println("注册成功！请牢记用户名和密码。");
            return true;
        }else if (name.length() < 3){
            System.out.print("用户名长度不能小于3，");
        }
        if (!pwt01.equals(pwt02)){
            System.out.print("两次输入的密码不相同！");
        }else if (pwt01.length() < 6){
            System.out.print("密码长度不能小于6");
        }
        return false;
    }
}
