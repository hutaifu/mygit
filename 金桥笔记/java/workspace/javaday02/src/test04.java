public class test04 {
    public static void main(String[] args) {
      /*  int num1 = 10;
        int num2 = 20;
        if(num1 > 20 && num2 <30){
            System.out.println("满足条件");
        }
        if (num1 <20 || num2 >30){
            System.out.println("满足条件");
//            一旦第一个条件被满足，第二个条件被短路*/

        int num1 = 1;
        int num2 = 1;
       if (num1++ ==1 || ++num2 ==2){
           num1 =7;
       }
        System.out.println(num1);//7
        System.out.println(num2);//1
    }
}
