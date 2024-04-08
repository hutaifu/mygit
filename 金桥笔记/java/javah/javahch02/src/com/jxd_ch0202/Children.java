package com.jxd_ch0202;

/**
 * @ClassName Children
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/2
 * @Version 1.0
 */

public class Children extends Father {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Children() {
//       虚拟机默认添加用于调用父类的无参构造
        super();
        System.out.println("子类无参构造");
    }



    public Children(int age,String name){
        //指定调用父类的带参构造方法
        super(age);
        this.name = name;
        System.out.println("子类的带参构造");
    }
}
