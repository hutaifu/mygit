package ch03prc03and04;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Test {
    public static void main(String[] args) {
        double totalRent = 0;
        MotoVehicle[] motos = new MotoVehicle[4];

        motos[0] = new Car("京NY28588","宝马");
        motos[1] = new Car("京NNN328","宝马");
        motos[2] = new Car("京NY28588","别克林荫大道");
        motos[3] = new Bus("金龙",34);

        for (int i = 0; i < motos.length; i++) {
            totalRent += motos[i].calcRent(5);

        }
        System.out.println("租金一共为：" + totalRent);


    }
}
