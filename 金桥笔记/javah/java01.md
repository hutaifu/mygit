## 抽象和封装

## 01-类和对象

+ Java，面向对象的语言
+ 对象就是实际问题中的实体，或者个体，万物皆对象。
  + 属性，对象的固有特征，使用变量表示，姓名，性别。
  + 方法，对象的功能，动态的特征。可以用来做什么。
+ 类是具有相同属性和方法的对象的集合。
  + 类是一个模板，规定了属于这个类的对象应该具有的属性和方法。
  + 类是抽象的，对象是具体的，是实例。
+ 面向对象的思想中，所有的属性和功能都是属于某个对象的，都是由对象进行处理的。
+ 类和对象的创建。

## 02-构造方法

+ 构造方法或者构造器的主要作用
  + 创建对象
  + 给对象的属性赋初值
+ 构造方法语法及特点

```java
public class Dog {
    String name;
    String type;
    int health;
    int love;



    public  void showinfor(){
        System.out.println("昵称是" + name);
        System.out.println("品种是" + type);
        System.out.println("健康值是"+ health);
        System.out.println("亲密度是" + love);
    }

    //构造方法，创建对象的同时给属性赋初值。
    public Dog(){
        name = "二毛";
        type = "金毛";
        health = 180;
        love = 50;
    }

    //带参数的构造方法
    public Dog(String name,String type,int health,int love){
        this.name = name;
        this.type = type;
        if (health > 0 && health <= 100) {
            this.health = health;
        }else {
            this.health = 60;
        }
        this.love = love;
    }
}

```

+ 没有返回值，也没有void关键字
+ 方法名必须和类名完全相同，包括大小写。
+ 可以由参数
+ 通过new关键字调用，调用一次代表创建一个对象
+ 可以出现多个构造方法，只能通过参数区分
  + 参数必须再类型上，顺序上以及个数上不同才行
  + 和参数名称没有任何关系
  + 在一个类中出现多个重名的方法，我没称之为方法重载。
+ 类一定有构造方法。
  + ​	
+ 构造方法的分类
  + 隐式的构造方法
    + 默认情况下，java虚拟机会给类一个无参的构造方法
      + public Dog(){}
  + 显式的构造方法
    + 我们自己编写的构造方法
    + 一旦我们提供了显式构造，那么虚拟机将不再提供默认的构造方法
    + 注意给类添加无参构造方法

## 03-方法重载

+ 在一个类中出现多个重名的方法，这就是方法重载。

+ 重载的要求：

  + 方法名必须相同
  + 参数列表必须是不同的
    + 个数上，顺序上以及类型上完全不同
    + 和参数名称没有关系
  + 和方法的返回值以及访问修饰符无关
  + 根据实参确定调用哪一个方法

+ ```java
   public Cat() {
      }

      public Cat(String name, String type, int health) {
          this.name = name;
          this.type = type;
          this.health = health;
      }

      public void  eat(){
          System.out.println("没有任何食物");
      }

      public void  eat(String food){
          System.out.println(name + "可以吃这个" + food);
      }

      public void eat(double money){
          System.out.println("可以花钱买猫粮");
      }

      public static void main(String[] args) {
          Cat cat = new Cat();
          cat.name = "猫宁";
   ```


          cat.eat(19);
          cat.eat();
          cat.eat("");
    
          //java提供的重载
          String str = "hello";
          str.substring(1);
          str.substring(1,3);//左闭右开

  //        Arrays.sort();

      }
 

## 04-static

+ 静态的

  + 用于修饰类的成员，比如类的属性和方法（不包括构造）
  + 使用static修饰的变量或者方法会成为一个类级别的属性或者方法
  + 类级别属性是随着类的加载而加载，优于对象存在的
  + 静态变量只在内存中存储一份，所有的对象共享这个变量
  + 静态变量的访问，可以直接通过类名.静态变量的方式访问，也可以通过对象名.静态变量的方式访问，不论哪个方式都在访问同一个变量
  + 静态方法是属性类的方法，随着类的加载而加载，可以直接通过类名.方法名调用
  + 静态方法中，只能去访问静态成员，不可以访问普通成员。
  + 普通方法中可以访问静态成员。

+ ```
  public class Student {
      //对象级别的变量，随着对象的创建而申请空间
      String name;
      int age;
      double javaScore;

  //    静态变量
  //    属于整个类，随着类的加载而申请空间，
      static double avgScore;

      //类级别的方法
      public static void showAvg(){
          System.out.println(avgScore);
          //静态方法中不可以访问普通的变量，因为对象未知
          //System.out.println(javaScore);
          //showScore();
      }

      //普通方法随着对象的创建而加载的
      //必须通过对象.方法的方式进行访问
      //打印的成绩正在调用改方法的对象的成绩
      public void showScore(){
          System.out.println(javaScore);
      }

      public Student(String name){
          this.name = name;
      }

      public Student(String name, int age) {
          this.name = name;
          this.age = age;
      }

      public Student(int age) {
          this.age = age;
      }
  ```



      public Student(){}

      public static void main(String[] args) {
          //对象创建之前类最先加载，同时初始化了静态变量
          Student.avgScore = 30;
          Student.showAvg();
    
          Student student = new Student();
          Student student1 = new Student(20);
          student1.name = "张三";
          student1.age = 18;
          student1.javaScore = 90;
    
          //静态对象的访问:通过类名直接访问
          Student.avgScore = 90;
          student1.javaScore = 99;
          System.out.println(student.avgScore);
      }
  }

  + 静态成员属于类的，普通成员是属于对象的
  + 静态成员先加载，普通成员是随着对象加载，后加载
  + 静态成员只有一份，普通成员对象有多少，就有多少份
  + 静态成员可以通过类和对象访问，普通成员必须依赖对象


## 05-final

+ 最终的

+ 可以修饰变量，包括成员变量和局部变量

+ 可以修饰方法，类中的方法（不包括构造方法）

+ ```
  public class Penguin {
      String name;
      String sex;
      int health;
      final String type = "帝企鹅";
      
      public  void show(){
          System.out.println(name + sex + health);
      }

      public static void main(String[] args) {
          Penguin penguin = new Penguin();
          
          final String sexBoy = "boyu";
          final String sexGirl = "gril";
          penguin.sex = sexGirl;
          
          final int num = 10;
          //final修饰对象或者数组
          final Penguin penguin1 = new Penguin();
          penguin1.name = "QQ";
          penguin1.name = "Q仔";
          System.out.println(penguin1);
          //代表地址不可被更改
          //
          
      }
  }

  ```

  + final 修饰简单类型的变量，基本数据和String，代表这个变量的值一旦被赋值后不可被更改，
  + 修饰数组或者对象，代表的是地址不可被更改，但是对象的属性和数组的元素值可以修改

+ 可以修饰方法，类中的方法（不包括构造方法）

  + 代表方法不可被重写

+ 可以修饰类

  + 代表类不可被继承

+ final 和 static一起用于修饰常量

  + ```java
        //常量的定义
        public final static double PI = 3.14;
        
        public final static String SEX_BOY = "男";
        public final static String SEx_GIRL = "女";
       
    ```

  + 常量名全是大写

  + 常量声明在类的下方

  + 常量可以直接通过类名访问



## 06-this

+ 可以以this.属性或者this.方法出现在类的方法中

  + 出现在构造方法中，用于区分成员变量和局部变量，代表的是当前正在被创建的那个对象

  + ```java
    public Cat(String name, String type, int health) {
            this.name = name;
            this.type = type;
            this.health = health;
        }

    ```

  + 出现在普通方法中，代表的是当前正在调用方法的对象

  + ```java
    public  void show(){
            System.out.println(name + sex + health);
            String food = this.getfood();
        }
        
        Peguin penguin = new Penguin();
        penguin.show();//th值当前这个对象
    ```

    + this后可以访问属性，也可以访问方法

+ 以this()的形式出现在类的构造方法中

  + this()出现在构造方法的第一句上，用于调用当前类的其他构建方法

    + 根据()中的实参，自动匹配调用构造方法

  + ```
    public class Course {
        int courseno;
        String coursename;
        String remark;

        public Course() {
        }

        public Course(String coursename) {
            this();
            this.coursename = coursename;
        }

        public Course(int courseno, String coursename, String remark) {
            //调用其他的构造方法
            this(coursename);//必须放在第一句
            this.courseno = courseno;
            this.remark = remark;
        }
    }

    ```

## 07-封装

+ 面向对象三大特征

  + 封装.继承，多态

+ 封装

  + 属性的封装

    + 将属性设置为私有的private

      + 设置为私有之后，只能在当前类中可以直接访问，在类之外无法直接访问

    + 在类中，提供public的get和set方法

      + set方法用于赋值
      + get方法用于取值
      + 在类之外，通过调用set和get方法实现属性的赋值和取值

    + 在get或者set方法中实现合理性的判断

    + ```java
      public class Dog {
          private String name;
          private String type;
          private int health;
          private int love;

          public void setName(String name){
              this.name = name;
          }

          public void setType(){
              this.type = name;
          }

          public String getName(){
              return name;
          }

          public String getType() {
              return type;
          }

          public void setType(String type) {
              this.type = type;
          }

          public int getHealth() {
              return health;
          }

          public void setHealth(int health) {
              if (health >= 0 && health <= 100) {
                  this.health = health;
              }else {
                  this.health = 60;
              }
          }

          public int getLove() {
              return love;
          }

          public void setLove(int love) {
              this.love = love;
          }

          public Dog() {
          }

          public Dog(String name, String type, int health, int love) {
              this.name = name;
              this.type = type;
              if (health >= 0 && health <= 100) {
                  this.health = health;
              }else {
                  this.health = 60;
              }
              this.love = love;
          }
      }

      ```

+ 访问修饰符

  + public公有的，没有任何的访问限制
  + 默认的，不加访问修饰符的，friendly
  + protected，受保护的，限制部分成员可以访问
  + private私有的，只能在类中使用

+ 封装的其他体现

  + 方法的封装，我们调用任何方法都不需要关注底层实现
  + 类的封装，将属性和方法封装在类中

## 08-初始化块

+ 出现在类中，属于类的一种成员

+ 类中的成员：前三种可以是静态的成员

  + 成员变量
  + 成员方法
  + 初始化块
  + 构造方法

+ 普通初始化块

+ ```
  public class Person {
      private String name;
      private int age;

      //初始化块：对构造方法的补充，用于完善对象的初始化
      {//随着对象的加载而加载执行
          age =1;
          System.out.println(name);
      }
      
      {//初始化块可以有多个，从上往下依此执行
          System.out.println(age);
      }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public int getAge() {
          return age;
      }

      public void setAge(int age) {
          this.age = age;
      }

      public Person() {
      }
  ```


  }

  ```

  + {}不可以接受参数，不可以有返回值
  + 随着对象的创建而加载执行，所以在初始化块中可以直接访问属性
  + 一般用于作为构造方法的补充

+ 静态初始化块

+ ```java
   static double avgAge;

      //初始化块：对构造方法的补充，用于完善对象的初始化
      {//随着对象的加载而加载执行
          age =1;
          System.out.println(name);
      }

      static {//静态初始化块
          //不能访问普通变量，但是可以访问静态变量
          System.out.println(avgAge);
      }
  ```

  + 静态初始化块只执行一次

  + 只能访问静态成员	

  ​





