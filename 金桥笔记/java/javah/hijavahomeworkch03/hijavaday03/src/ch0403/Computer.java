package ch0403;

/**
 * @ClassName Computer
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Computer {
    private String brand;
    private String color;

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

    public void show(){
        System.out.println(brand + color);
    }

    public class Mouse{
        private String brand;
        private String type;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void show(){
            System.out.println(brand + type);
            //访问外部类的属性
            System.out.println(Computer.this.brand);
            //this,鼠标的电脑对象
        }
    }
}
