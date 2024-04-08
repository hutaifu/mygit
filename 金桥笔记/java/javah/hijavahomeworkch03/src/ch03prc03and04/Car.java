package ch03prc03and04;

/**
 * @ClassName Car
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Car extends MotoVehicle {
    private String Type;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Car() {
    }

    public Car(String type) {
        Type = type;
    }

    public Car(String no, String type){
        super.setNo(no);
        setType(type);
    }

    @Override
    public double calcRent(int days) {
        int num = 0;
        switch (getType()) {
            case "别克商务舱":
                num = days * 600;
                break;
            case "宝马":
                num = days * 500;
                break;
            case "别克林荫大道":
                num = 300 * days;
                break;
        }
        return num;
    }

    public Car(String no, String brand, String color, double mileage, String type) {
        super(no, brand, color, mileage);
        Type = type;
    }
}
