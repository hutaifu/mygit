package day02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

/**
 * @ClassName TestSeason
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/19
 * @Version 1.0
 */

public class TestSeason {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请用数字输入月份：");
        int num = input.nextInt();
        Season season = new Season();
        System.out.println(season.get(num));
    }
}
