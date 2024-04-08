## java的特性

+ 面向对象

## 01-对象

+ 对象是我没在生活中看得见，摸得着的任意一个实体，一个真实存在的物体或者动物。
+ 万物皆对象。
+ 比如一个人，一台电脑，一辆车，都可以看成一个对象，
+ 实际问题中的实体或者物体，在java中都会被看成是一个对象。

## 02-对象的特征

+ 描述对象可以分为两个方面
  + 固有的基本信息，比如人的姓名，比如车的品牌型号等
    + 我没一般称为对象的属性，在Java中使用变量就可以表达清楚
  + 动态的功能特征，比如学生会编程，比如车会跑，电脑可以打游戏，
    + 这些我们称为对象的方法
+ 任意一个对象都可以从属性和方法表述清楚。
  + 所有对象都具有属性和方法。
  + 相辅相成，共同来描述对象

## 03-对象的分类

+ 对象都是分类管理的；
+ 我们把具有相同属性和方法的对象分为一类。
+ 生活中是先有对象再有类的。
+ 对象是具体的，类是抽象的。

## 04-从对象抽象出类

+ 我们要在类中规定属于这个类的对象要具有的属性和方法。
+ 类可以看成是一种模板，符合这个模板的就是这一类的对象。

## 05-java中的类和对象

+ 学生管理系统

  + 存储所有学生的信息
  + 我们在Java中创建学生类

+ 创建类：声明属性和方法

+ ```
  public class Student {
  //属性;我们关注的学生属性
      String name;
      char sex;
      int age;
      String address;
  //    方法:学生所具备的技能
      public void showInfo(){
          System.out.println("姓名是"+name);
          System.out.println("性别是"+sex);
          System.out.println("年龄是"+age);
          System.out.println("籍贯是"+address);
      }

  }

  ```

+ ```
   创建对象：对应实际问题中的一个具体的学生
          Student student01 = new Student();
  //        给对象的属性赋值
          student01.name = "张三";
          student01.age = 20;
          student01.sex = '男';
          student01.address = "山东济南";
  //        方法的调用
  //        自我介绍
          student01.showInfo();
  //        创建其他的对象
          Student student02 = new Student();
          student02.name = "李四";
          student02.sex = '男';
          student02.address = "山东青岛";
          student02.age = 20;
          student02.showInfo();
      }
  }
  ```

+ 根据类去创建对象，解决实际问题，

+ 创建对象的语法

  + 类名 对象名 = new 类名();
  + 对象名，一般为类名首字母小写的形式

+ 对象的使用

  + 对象名.属性
  + 对象名.方法

+ 使用面向对象解决问题

  + 变量的存储，从单个变量存储变成存到对象的属性中
  + 逻辑功能的实现，从main中的顺序流代码转换称为类的方法

+ 对象的属性

+ ```
   public static void main(String[] args) {
          School school01 = new School();
          school01.name = "实验一小";
          school01.classroomcount = 32;
          school01.labCount = 10;
          school01.showInfo();

          School school02 = new School();
  //        每个对象的属性有初值
  //        String 为null
  //        int 为0
  //        double为0.0
  //        booleam 为false
          school02.showInfo();
      }
  }

  ```

+ 对象的属性都有初值，在不赋值的情况下也可以直接使用

 ## 06-面向对象思想

+ java中的类对应实际问题中实体的分类，比如学生类，老师类，电脑类，食品类，
+ java中的对象对应的就是实际问题中具体的物体或者人，比如69个学生，对应程序中的69个学生对象，——对应。
+ 用户的数据要存储在对象的属性中，任何一个逻辑操作都应该是某个对象的操作
+ java所有的数据和操作都依附在某个对象上，都有执行的主体，
+ java中的解题思路，和我们日常思维习惯是比较契合的。
+ 面向过程的语言和面向对象相反，没有对象的概念。

## 07-类和对象的应用

```
public class Visitor {
    int fee;
    String name ;
    int age ;
    public void show(){
        if (age < 18 || age >60){
            fee = 0;
        }else {
            fee = 20;
        }
        System.out.println(name+"的年龄为:"+age+",门票价格为："+fee);

    }
}

```

```
public class TestVisitor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            Visitor visitor = new Visitor();
//            创建类对象时必定要保证现实中一定要保证真实存在那个对象
            System.out.println("请输入姓名：");
            visitor.name = input.next();
            if (visitor.name.equals("n")){
                break;
            }
            System.out.println("请输入年龄：");
            visitor.age = input.nextInt();
            visitor.show();
        }while (true);
        System.out.println("退出程序");
    }
}

```

## 08-数据类型

+ 基本数据类型
  + 8种
+ 引用数据类型
  + String
  + 数组
  + 对象

## 09-面向对象的优点

+ 与我们日常的思维习惯一致
+ 提高了代码的复用性
  + 不需要重复定义变量
  + 不需要重复编辑逻辑代码
+ 信息的隐藏，提高了代码的安全性