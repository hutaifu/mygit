package day03;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class test05 {
    public static void main(String[] args) {
        int  num1 = 10;

        if (num1 == 10){
            int num2 = 20;
            System.out.println(num2);
            System.out.println(num1);
        }
        //在一个大括号中声明的变量，在大括号结束之后，会被回收
        System.out.println();//num2以及被回收，无法访问
        System.out.println(num1);
    }

}
