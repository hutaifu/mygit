## 继承

## 01-什么是继承

+ 将不同的类中相同的属性和方法提取到一个父类中，

+ 然后由子类继承这个父类，继承父类就相当于拥有了父类声明的属性和方法

+ 在创建对象时，可以正常的调用到从父类继承过来的方法

+ ```java
  public class Pet {
      private String name;
      private int health;
      private int love;

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public int getHealth() {
          return health;
      }

      public void setHealth(int health) {
          this.health = health;
      }

      public int getLove() {
          return love;
      }

      public void setLove(int love) {
          this.love = love;
      }

      public Pet() {
      }

      public Pet(String name, int health, int love) {
          this.name = name;
          this.health = health;
          this.love = love;
      }
  }

  ```

+ ```java
  public class Dog extends Pet {
      //会从父类中继承属性和方法
      private String type;

      public String getType() {
          return type;
      }

      public void setType(String type) {
          this.type = type;
      }

      public Dog(){}

      public Dog(String name, String type, int health, int love) {
          //如何给父类继承过来的属性赋值
          this.type = type;

      }
  }
  ```

##02-继承的具体概念和特点

+ 在一个类的基础上，衍生出一个新类

+ 原来的类，我们称之为父类或者超类，

+ 衍生出来的类，我们称之为子类或者派生类，

+ 继承又叫派生

+ java是单继承语言，一个类只能有一个父类，

  + 所有的类按照一种维度去分组

+ 继承的关键字：extends

+ 子类继承父类后，拥有了父类中声明的属性和方法，在子类中，只需要声明特殊的属性及方法

## 03-继承中属性和方法的访问

+ 父类中哪些成员子类不可以继承：

  + 父类的构造方法

  + 私有的属性，可以继承，但是在子类中不可以直接访问

  + 父类中默认访问权限的成员，在不同包的子类中不可以直接访问

  + ```java
    public class Pet {
        private String name;
        private int health;
        private int love;
        int age;
    }
    //同包的可以访问age
    //不同包的子类不可以访问age
    ```

  + ​

+ 在子类中如何访问父类成员

  + 通过super关键字实现

  + ```java
     public void showinfo(){
            //可以直接访问父类中继承的属性和方法（私有除外）
            System.out.println("昵称是" + super.getName());
            System.out.println("品种是" + this.gettype());
            System.out.println("健康值是" + super.getHealth());
            System.out.println("年龄是" + super.age);
        }
     ```
    ```

  + super代表超级，可以看成是父类的引用

  + super只能出现在子类的方法中

  + super可以省略 
    ```

+ 访问修饰符的限制

+ public    没有任何限制访问，

+ protected  本类可以访问，同包下的其他类，子类可以访问

+ friendly 默认的 本类可以访问，同包下的其他类或者子类可以访问，不同包的子类或者其他类都不可以访问

+ private 本类中访问

  + 类的属性，都是private  （常量一般都是public）

  + 类的对外方法，都是public

##04-什么情况 可以使用继承

+ 只有存在实际问题中的关联关系时，才可以使用继承，存在属于关系，子类属于父类。
+ 父类一般也是一个名称，是一种实体，是相同类型的实体分类。Pet.Person。
+ 必须存在一个is-a关系。
+ 继承最大的优势，就是实现代码的复用。

## 05-继承中构造方法的使用

+ 首先创建对象，一定会调用构造方法

+ 创建子类对象时，首先会调用父类的构造方法

+ 默认情况下会调用父类的无参构造，super（）；被虚拟机默认添加在了子类所有构造方法的第一句。

+ 我没可以通过super（参数）；的形式，放在子类构造的第一句上，指定调用父类的构造方法

+ 子类只能去调用父类中存在的构造方法，

+ 注意给父类添加无参构造方法

+ ```java
  public class Father {
      private int age;

      public int getAge() {
          return age;
      }

      public void setAge(int age) {
          this.age = age;
      }

      public Father() {
          System.out.println("这是父类的无参构造");
      }

      public Father(int age) {
          this.age = age;
          System.out.println("父类的带参构造");
      }
  }
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
  ```



      public Children(int age,String name){
          //指定调用父类的带参构造方法
          super(age);
          this.name = name;
          System.out.println("子类的带参构造");
      }

## 06-super关键字

+ 用法一：在子类的方法中，通过super.属性或者super.方法的形式调用父类的一些成员
+ 用法二：在子类的构造方法，通过super（）；调用父类的构造方法。

## 07-方法的重写overrid

+ 子类从父类继承过来的方法，无法满足子类的功能需求了，那么子类可以重写这个方法

+ ```java
  public class Pet {
      

      public void showinfo(){
          System.out.println("昵称是" + name + "\n健康值是" + health +"\n亲密度是" +
                  love);
      }
  }
  public class Dog extends Pet {
      private String type;

      //方法重写，从父类继承来的方法，无法满足子类的功能需求了，
      //那么子类可以重新覆盖这个方法
      @Override
      public void showinfo(){
          System.out.println("昵称是" + getName() + "\n品种是" + type + "\n健康值是" +
                  getHealth() + "\n亲密度是" + getLove());

      }
  }

  ```

+ 重写的要求

  + 子类重写父类方法
  + 方法名.返回值类型，参数列表必须一致
  + 访问修饰符不能比父类更严格

+ 重写：子类将父类继承过来的覆盖掉了，所有子类依然只有一个该方法

  + 子类对象在进行方法调用时，执行的是子类修改后的方法体

+ 优点：

  + 1.提高代码的复用性
  + 2.保证代码的一致性，父类规定了这个方法的定义，子类要遵守这个定义

## 08-抽象类和抽象方法的概念

+ 定义了共同属性的父类，在创建对象时无法对应到实际问题中的一个实体上，比如Pet创建对象，不确定是什么宠物

+ 针对这样的父类，我没可以通过定义为抽象类，限制它的实例化操作

+ 抽象类不可以创建操作

+ ```java
  public abstract class Pet{
    public Pet(){}
    
  }
  ```

  + 被abstract关键字修饰的类是关键类
  + 可以有普通的成员，也可以有抽象方法
  + 抽象父类一般用于继承，不可以通过new关键字创建对象
  + 有构造方法

+ 抽象方法：没有方法体的方法。

  + 只能声明在抽象类和接口中

  + 抽象方法在子类中，必须被重写实现否则子类也必须声明为抽象类

  + ```java
     //抽象方法，没有方法体的方法
        //必须出现在抽象类中
        public abstract void showinfo();
     ```


## 09-final

+ 修饰简单类型的变量代表值不可以被更改，修饰数组或者对象代表地址不可以被更改，
+ final修饰方法，不可被重写，
+ final修饰类，不可以被继承。