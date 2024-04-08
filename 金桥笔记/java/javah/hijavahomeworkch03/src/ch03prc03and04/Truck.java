package ch03prc03and04;

/**
 * @ClassName Truck
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Truck extends MotoVehicle {
    private int ton;

    public int getTon() {
        return ton;
    }

    public void setTon(int ton) {
        this.ton = ton;
    }

    public Truck() {
    }

    public Truck(String no, String brand, String color, double mileage, int ton) {
        super(no, brand, color, mileage);
        this.ton = ton;
    }

    @Override
    public double calcRent(int days) {
        return 50 * ton * days;
    }
}
