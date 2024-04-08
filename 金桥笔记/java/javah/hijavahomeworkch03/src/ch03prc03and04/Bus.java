package ch03prc03and04;

/**
 * @ClassName Bus
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Bus extends MotoVehicle {
    private int seatCount;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Bus() {
    }

  public Bus(String brand,int seatCount){
        setBrand(brand);
        this.seatCount = seatCount;
  }


    @Override
    public double calcRent(int days) {
        int num = 0;
        if (seatCount <= 16 && seatCount > 0){
            num = 800 * days;
        }else if (seatCount > 16){
            num = 1500 * days;
        }
        return num;
    }

    public Bus(String no, String brand, String color, double mileage, int seatCount) {
        super(no, brand, color, mileage);
        this.seatCount = seatCount;
    }
}
