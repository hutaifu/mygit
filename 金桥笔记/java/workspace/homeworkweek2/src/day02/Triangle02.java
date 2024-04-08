package day02;

/**
 * @ClassName Triangle02
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class Triangle02 {
    double a;
    double b;
    double c;
    public void isTriangle(){
        double max;
        double min;
        double mid;
        if (a > b){
            max = a;
            min = b;
            if (c > a){
                max = c;
                min = b;
                mid = a;
            }else if (c < b){
                max = a;
                mid = b;
                min = c;
            }else {
                mid = c;
            }
        }else if (c > b){
            max = c ;
            mid = b;
            min = a;
        }else if (c< a){
            max = b;
            mid = a;
            min = c;

        }else {
            max = b;
            mid = c;
            min = a;
        }
        if ((min + mid > max) && (mid < max - min) && (max < mid - min) && (min < max - mid)){
            System.out.println("能够组成三角形");
            if (max == min){
                System.out.println("等边三角形");
            }else if ((max == mid) ||(mid == min)){
                System.out.println("等腰三角形");
            }else if (min * min + mid * mid == max *max){
                System.out.println("直角三角形");
            }else if (min * min + mid * mid < max *max){
                System.out.println("钝角三角形");
            }else {
                System.out.println("锐角三角形");
            }
        }
    }
}
