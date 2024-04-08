package day04;

public class Test08 {
    public static void main(String[] args) {
        for (int i = 2,j = 5; i <=50 && j <= 100 ; i *=2,j*=2) {
            System.out.println(i + "*" + j + "=" + i*j);
        }
    }
}
