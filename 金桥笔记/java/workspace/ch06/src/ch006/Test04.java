package ch006;

public class Test04 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 100 ; i++) {
            if (i % 3== 0){
                continue;
            }else {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
