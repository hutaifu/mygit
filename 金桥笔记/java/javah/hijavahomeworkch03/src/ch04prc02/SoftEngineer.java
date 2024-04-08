package ch04prc02;

/**
 * @ClassName SoftEngineer
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class SoftEngineer extends Person implements IBizAgent,IProgrammer {

    public SoftEngineer() {
    }

    public SoftEngineer(String name) {
        super(name);
    }

    @Override
    public void giveBizSpeech() {
        System.out.println("我会讲业务");
    }

    @Override
    public void writeProgram() {
        System.out.println("我会写代码");
    }

    public void showinfo(){
        System.out.println("我是一名软件工程师，");
        show();
        writeProgram();
        giveBizSpeech();
    }
}
