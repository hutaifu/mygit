## 异常

### 01-什么是异常

+ 异常指的是运行时的异常，代码本身没有任何语法问题，开始运行后，由于变量的不确定性，导致出现的运行时的问题。

+ Exception

+ ```java
  public class Test01 {
      public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          System.out.println("请输入被除数：");
          int num01 = input.nextInt();
          System.out.println("请输入除数：");
          int num02 = input.nextInt();

          System.out.println("结果是" + num01 / num02);
          System.out.println("感谢使用本程序");
      }
  }

  ```

+ 以上代码，由于用户的输入问题会导致出现至少两种异常，输入不匹配异常，计算异常。

+ 可以通过if判断简单处理，但是会导致代码冗余，

+ 并且自己写if判断可能会有遗漏问题，

+ java提供了异常处理机制，可以保证程序在出现异常时给出合理的提示，并平稳的结束程序。

### 02-java异常处理机制

+ try-catch-finally

  + try{}中放的是可能会出现异常的代码

  + catch（）捕获try中出现的异常对象

  + ```java
    public class Test01 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("请输入被除数：");
                int num01 = input.nextInt();
                System.out.println("请输入除数：");
                int num02 = input.nextInt();

                System.out.println("结果是" + num01 / num02);
    ```


            } catch (InputMismatchException e){
                System.out.println("请输入整数");
                e.printStackTrace();
            } catch (ArithmeticException e){
                System.out.println("零不能为除数");
                e.printStackTrace();
            } catch (Exception e) {
                //捕获try块中出现的异常对象
                System.out.println("用户输入有误");
                //记录异常信息
                e.printStackTrace();
            }
                System.out.println("感谢使用本程序");
        }
    }
    
    ​```
    
    + catch()中，声明一个异常的变量，用来存储try中出现的异常对象，
    + 一旦发生异常，虚拟机回去匹配catch块中的异常类型，如果符合，那么会进入该catch块，
    + catch块结束后，程序会继续往下执行try-catch之后的代码，不会直接中断

  + catch在try之后，可以有多个用于捕获不同类型的异常对象，

  + 虚拟机会从上往下依次匹配，一旦符合其中一个，将不再执行其他的catch块

  + 所有catch的顺序，要从子类到父类，先特殊，再普通

  + 使用try-catch之后，程序的的三种情况

    + 程序没有发生异常，不会进入任何catch块，正常结束
    + 程序出现异常，并且被catch捕获到了，那么会先进入catch块，然后执行之后的代码，正常结束
    + 程序出现异常，但是没有被catch捕获，程序直接中断，不会再执行任何代码，以此结束。

  + finally块

    + 放在catch块之后，其中代码始终都会执行
    + 只有一种情况，就是提前推出了java虚拟机，System.exit(1)；

  + 异常信息

    + ```java
      java.util.InputMismatchException
      	at java.util.Scanner.throwFor(Scanner.java:864)
      	at java.util.Scanner.next(Scanner.java:1485)
      	at java.util.Scanner.nextInt(Scanner.java:2117)
      	at java.util.Scanner.nextInt(Scanner.java:2076)
      	at com.jxd_ch05.Test01.main(Test01.java:19)
      ```

    + 常见的异常类型

      + InputMisMatchException
      + ArrayIndexOutofBoundExeption
      + ArithmeticExeption 计算异常
      + NullPointException   空指针异常
        + 当调用某个方法的对象为null时，会出现空指针异常。
      + ClassCastException  类型转换异常
      + ClassNotFoundException  找不到类，找不到第三方的类
      + NumberFormatException 数字转换异常。
      + ​

+ throws

  + 放在方法的声明处，参数列表之后，用于声明该方法可能出现的异常，抛出异常

  + ```java
    public class Test03 {
        public static void main(String[] args) throws Exception{
            /*try {
                divde();
            }catch (Exception e){
                System.out.println("输入有误");
            }*/
            divde();
        }

        public static void divde() throws Exception{
            Scanner input = new Scanner(System.in);
                System.out.println("请输入被除数：");
                int num01 = input.nextInt();
                System.out.println("请输入除数：");
                int num02 = input.nextInt();

                System.out.println("结果是" + num01 / num02);
    ```


                System.out.println("感谢使用本程序");
            }
    
        }
    
    ​```

  + 调用该方法的地方，需要对这个异常进行处理

  + 或者继续声明异常

+ throw

  + 抛出异常。

  + 比如学生对象的性别，如果输入不正确，我没去抛出一个异常。

  + ```java
    public class Student {
        private String name;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) throws Exception {
            if ("男".equals(sex) || "女".equals(sex)){
                this.sex = sex;
            } else {
                //创建自定义的异常对象，定义堆栈信息
                //并抛出异常对象
                throw new Exception("性别只能是男或者女");
            }

        }
    }

    ```

    + throw用于抛出一个自定义的异常对象
    + 抛出异常后，该方法必须对其进行处理
      + 可以try-catch
      + 可以声明异常

+ java通过这五个关键字处理异常

### 03-异常的分类

+ Exception是所有异常的根类
+ 分类：
  + 运行时异常runtimeException代码编译没有问题，运行时报错
    + 空指针，下标越界
  + 编译时异常：编译不通过，必须添加try-catch，或者throws才可以
    + ClassNotFound异常
    + FileNotFound异常
    + 一般出现我们去调用Java提供的某些方法，这些方法声明了异常。
+ Error错误
  + 比较严重的系统错误

### 04-日志的记录

+ 日志：用于记录程序运行的相关过程，数据，操作结果等。

+ 主要用于系统部署后，记录用户的使用过程，比如输入了什么，点击了什么，等等

+ 如果系统在运行过程中出错，我们可以根据日志中的记录，重现bug，直接定位。

+ 日志就是一个文本文件。一天一个。

+ 日志的实现：

  + 使用专门的日志记录工具。Log4j日志工具。

+ Log4j是第三方的jar包，jar包中就是编译好的class的二进制。

  + 我们想要利用log这个工具记录日志，就要使用log4j相关功能
  + 我们需要将这个jar包引入到自己的项目中

+ 日志的记录步骤

  + 创建文件配置文件：告诉log4j工具我们要怎么记录日志

  + 在代码中，创建日志工具创建对象，调用方法记录日志

  + ```java
    package com.jxd_ch05;

    import org.apache.log4j.Logger;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    /**
     * @ClassName Test01
     * @Description TODO
     * @Author Hutaifu
     * @Date 2022/8/4
     * @Version 1.0
     */

    public class Test01 {
        //创建日志工具对象
        private static Logger log = Logger.getLogger(Test01.class);
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            try {
                System.out.println("请输入被除数：");
                int num01 = input.nextInt();
                //记录用户操作
                log.info("用户输入了被除数：" + num01);
                System.out.println("请输入除数：");
                int num02 = input.nextInt();
                log.info("用户输入了除数：" + num02);

                System.out.println("结果是" + num01 / num02);
                log.info("用户执行了除法操作，结果是：" + num01 / num02);
    ```


```java
        } catch (InputMismatchException e){
            System.out.println("请输入整数");
//            System.exit(1);
            e.printStackTrace();
            log.error("用户输入的内容不是整数");
        } catch (ArithmeticException e){
            System.out.println("零不能为除数");
            e.printStackTrace();
            log.error("用户输入了0作为除数");
        } catch (Exception e) {
            //捕获try块中出现的异常对象
            System.out.println("用户输入有误");
            //记录异常信息
            e.printStackTrace();
            log.error("错误");

        } finally {
            System.out.println("感谢使用本程序");
        }

    }
}

​```
```

+ ```java
  ### 设置Logger输出级别和输出目的地 ###
  log4j.rootLogger=debug,stdout,logfile
  ### 把日志信息输出到控制台 ###
  log4j.appender.stdout=org.apache.log4j.ConsoleAppender
  log4j.appender.stdout.Target=System.err
  log4j.appender.stdout.layout=org.apache.log4j.SimpleLayout
  ### 把日志信息输出到文件：test.log ###
  log4j.appender.logfile=org.apache.log4j.FileAppender
  log4j.appender.logfile.File=test.log
  log4j.appender.logfile.layout=org.apache.log4j.PatternLayout
  log4j.appender.logfile.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %l %F %p %m%n
  ```

+ ​

+ Log对象提供给的方法

  + debug方法
  + info()
  + warn()
  + error()
  + 以上都可以记录日志，用于记录不同等级不同级别的用户操作。
  + 这四个方法对应四个级别：普通操作、关键输入、警告信息、报错信息

+ 日志文件中的级别，可以设置我没只记录哪个级别及以上的信息

  + 比如级别设置为warn，那么代码中log.info() 将不再升效。

+ 异常的堆栈信息

  + ```java
    catch (InputMismatchException e){
                System.out.println("请输入整数");
    //            System.exit(1);
      //打印堆栈信息
                e.printStackTrace();
                log.error("用户输入的内容不是整数");
                //记录堆栈信息
                log.error(e.getMessage());
    ```

  + ​


