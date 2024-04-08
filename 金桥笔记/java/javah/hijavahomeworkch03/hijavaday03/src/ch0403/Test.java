package ch0403;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setBrand("联想");
        computer.setColor("black");
//利用这个电脑对象创建鼠标
        Computer.Mouse mouse = computer.new Mouse();
        mouse.setBrand("罗技");
        mouse.setType("M05");

        computer.show();
        mouse.show();
    }
}
