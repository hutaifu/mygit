package day04;

public class Test07 {
    public static void main(String[] args) {
        for ( int i = 1 ; i < 100; i++){
            System.out.println(i);
            if (i % 3 == 0 && i % 5 == 0){
                System.out.println("FlipFlop");
            }else if (i % 3 == 0){
                System.out.println("Flip");
            }else if (i % 5 == 0){
                System.out.println("Flop");
            }
        }
    }
}
