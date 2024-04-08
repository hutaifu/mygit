## 接口

### 01-为什么使用接口

+ 因为java是单继承的语言，一个类只能有一个父类，因为使用继承必须存在is-a关系

+ 当某个对象同时具备了不同父类中的功能时候，继承无法满足

+ 就可以使用接口interface替代父类。

+ 子类可以去同时实现多个接口。

+ 接口主要就是弥补了Java单继承的语法缺陷。

+ ```java
  public interface IFather {
      public abstract void buycar();
  }
  public interface IMather {
      public abstract void buyBag();
  }

  public class Child implements IFather,IMather {
      @Override
      public void buycar() {
          System.out.println("给爸爸卖车");
      }

      @Override
      public void buyBag() {
          System.out.println("给妈妈买包");
      }
  }
  ```

### 02-接口定义

+ 接口通过interface关键字定义

+ 只能声明常量和抽象方法

+ 没有构造方法，没有普通的属性和成员方法

+ ```java
  public interface IFather {
      //String name;
      //接口中之能声明常量；
      public final static String NAME = "HELLO";

      //接口中没有构造方法
      


      public abstract void buycar();
      //抽象方法可以省略访问修饰符和abstract
      void show();
      //java8支持
      /*static void showinfo(){

      }*/
      //java9支持私有方法



  ```

  + 常量前的public final static可以省略
    + int MAX_VALUE= 100；
  + 抽象方法前的public abstract可以省略
    + void show（）

+ 接口中一般都是用来定义方法的，所有接口可以看出是一系列方法的声明。

+ 实现类通过implements实现接口，同时可以实现多个接口，用逗号隔开

  + public class Child implements IFather,IMother{}

+ 实现类要重写所有接口中的所有抽象方法

+ 实现类还可以继承一个父类的同时，再去实现多个接口

  + public class Child extends People implements IFater,IMather{}j

+ 接口和接口直间也可以存在继承关系，而且可以多继承。

### 03-接口的概念和特点

+ 接口是继承体系之外，不代表任何实体，

+ 接口可以看成是一种能力，具备这个能力的子类就可以实现这个接口。一系列方法的声明，具备多种能力就可以实现多种接口。

+ 接口无法创建对象的，也没有构造方法，

+ 不同类型的实体类，可以去实现同一个接口，比如游泳是一个接口，人可以实现，企鹅也一样可以实现

+ 实现类和这个接口属于实现关系，或者拥有关系。

+ 接口还可以看成是一种约定，或者标准

  + 电脑的U口可以看成是一种标准，连接电脑的标准、
  + 所有符合标准这个设备，都可以通过这个U口连接电脑
  + 不同的设备连接电脑后，可以有完全不同的功能实现。

+ ```java

  public interface IUstinterface {
      void connectComputer();
  }

  public class Mouse implements IUstinterface {
      @Override
      public void connectComputer() {
          System.out.println("鼠标连接电脑后可以操作电脑");
      }
  }
  ```

+ 接口可以看成是一种标准，比如生成标准

+ ```java
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

  ```

### 04-接口和抽象类的区别

+ 语法：
  + 抽象类，具有普通的成员变量和成员方法，也可以有抽象方法
    + 具有构造方法，但是不能创建对象
  + 接口中只能有常量和抽象方法
    + 没有构造方法 也不能创建对象
+ 实现：
  + 一个类之能继承一个抽象父类，存在属于关系
  + 一个类可以同时实现多个接口，
+ 应用：
  + 继承抽象父类要符合is-a关系，是分类的一种体现
  + 实现接口，只考虑是否具备这种能力既可。

### 05-内部类

+ 类的成员

  + 成员变量
  + 成员方法
  + 构造方法
  + 初始化块
  + 内部类

+ ```java
  public class OutClass {
      private String name;
      
      //内部类
      public class InnerClass{
          private String name;
      }
  }

  ```

+ 内部类的应用场景

  + 如果一类实体要依附于另外一类实体才具有意义，那么就可以声明为内部类。
  + 比如鼠标和电脑，鼠标可以作为电脑的内部类

```java
public class Computer {
    private String brand;
    private String color;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void show(){
        System.out.println(brand + color);
    }

    public class Mouse{
        private String brand;
        private String type;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void show(){
            System.out.println(brand + type);
            //访问外部类的属性
            System.out.println(Computer.this.brand);
            //this,鼠标的电脑对象
        }
    }
}



public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setBrand("联想");
        computer.setColor("black");
//利用这个电脑对象创建鼠标
        Computer.Mouse mouse = computer.new Mouse();
        mouse.setBrand("罗技");
        mouse.setType("M05");

        computer.show();
        mouse.show();
    }
}

```



