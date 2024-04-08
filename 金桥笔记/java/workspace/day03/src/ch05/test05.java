package ch05;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class test05 {
    public static void main(String[] args) {
        System.out.println("华氏温度\t摄氏温度");
        double temp= 0.0;
        double temp1 = 0;
        int a = 0;
        do {
            temp1 = temp *9 / 5.0 + 32;
            if (a == 0){
                System.out.println(temp+"\t\t\t"+temp1);

            }else {
                System.out.println(temp + "\t\t" + temp1);
            }
            a ++;
            temp = temp + 20;
        } while (a <= 10 && temp <= 250);
    }
}
