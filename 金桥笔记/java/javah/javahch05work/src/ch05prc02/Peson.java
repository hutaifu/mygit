package ch05prc02;

/**
 * @ClassName Peson
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/4
 * @Version 1.0
 */

public class Peson {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age <= 100 && age >= 1){
            this.age = age;
        }else {
            throw new Exception();
        }
    }

    public Peson() {
    }

    public Peson(int age) {
        this.age = age;
    }
}
