package day04;

public class Test06 {
    public static void main(String[] args) {
        int rab = 0;
        int che = 0;
        for (;rab < 35; rab++){
            che = 35 - rab;
            if (rab * 4 + che * 2 == 94){
                System.out.println("兔子"+rab+"\n鸡"+che);
                break;
            }else {
            }
        }
    }
}
