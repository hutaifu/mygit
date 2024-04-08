package ch03prc03and04;

import java.util.Scanner;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        Car car = new Car();
        Bus bus = new Bus();
        Truck truck = new Truck();
        do {
            System.out.println("请输入机动车类型：（轿车、客车、卡车）");
            Scanner input = new Scanner(System.in);
            String vary = input.next();
            if (vary.equals("轿车")) {
                System.out.println("请输入车型（别克商务舱、宝马、别克林荫大道）：");
                String type = input.next();
                car.setType(type);
                while (true){
                    System.out.println("请输入天数");
                    if (input.hasNextInt()){
                        int days = input.nextInt();
                        System.out.println("租金是" + car.calcRent(days));
                        break;
                    }
                    input.next();
                }
                break;
            } else if (vary.equals("客车")) {
                while (true) {
                    System.out.println("请输入座位数：");
                    if (input.hasNextInt()){
                        int seatCount = input.nextInt();
                        bus.setSeatCount(seatCount);
                        break;
                    }
                    input.next();
                }
                while (true){
                    System.out.println("请输入天数");
                    if (input.hasNextInt()){
                        int days = input.nextInt();
                        System.out.println("租金是" + bus.calcRent(days));
                        break;
                    }
                    input.next();
                }
                break;
            }else if (vary.equals("卡车")){
                while (true) {
                    System.out.println("请吨数：");
                    if (input.hasNextInt()){
                        int ton = input.nextInt();
                        truck.setTon(ton);
                        break;
                    }
                    input.next();
                }
                while (true){
                    System.out.println("请输入天数");
                    if (input.hasNextInt()){
                        int days = input.nextInt();
                        System.out.println("租金是" + truck.calcRent(days));
                        break;
                    }
                    input.next();
                }
                break;
            }
        }while (true);
    }
}