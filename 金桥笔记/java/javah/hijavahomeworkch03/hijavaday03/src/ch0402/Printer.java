package ch0402;

/**
 * @ClassName Printer
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/3
 * @Version 1.0
 */

public class Printer {
    public void print(IInk ink,IPage iPage){
        System.out.println("利用" + iPage.standardpage() + "打印了" + ink.standardInk() + "文件");
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        //声明接口类型，创建的实现类类型
        IInk ink = new ColorInk();
        IPage page = new A4Paper();
        printer.print(ink,page);
    }
}
