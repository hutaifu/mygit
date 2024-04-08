package day02;

/**
 * @ClassName MotoVehicle
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public abstract class MotoVehicle {
    private String no;
    private String brand;
    private String color;
    private double mileage;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public MotoVehicle() {
    }

    public MotoVehicle(String no, String brand, String color, double mileage) {
        this.no = no;
        this.brand = brand;
        this.color = color;
        this.mileage = mileage;
    }

    public abstract double calcRent(int days);
}
