变量

+ ```
   public static void main(String[] args) {
     //        整数类型
          byte num1 = 127;
     //        范围是-128至127
         short num2 = 2;//-2^15到2^15-1
          int num3 = 3;//-2^31到2^31-1
          long num4 = 4;//-2^63到2^63-1
     //        浮点数类型
          float num5 = 1.0F;//无限接近于1的数值
          double num6 = 1.0;//双精度更接近无限接近于零
          //字符型,
          char c1 = 'a';//存放的是单个字符,存储到内存的是一个数字，ascii
     //         布尔类型
          boolean b1 = true; //false,判断，不用引号
          String s = "hello";
   ```




       public static void main(String[] args) {
  //        想把“张三”存到内存中
  //        声明变量，本质存储，只能放字符块（双引号括起来的）
          String name = "张三";
          System.out.println(name);
          name = "李四";
          System.out.println(name);
  //        存储用户的年龄
          int age = 20;
          System.out.println("用户的年龄是"+age);
          double height;
          height = 165;


      }
  ```

+ 引用数据类型

  + String ,数组 对象

+ 变量使用的注意事项

  + 变量名为自定义，首字母只能是字母，_下划线，$,其他位置可以是字母，下划线，  ，以及数字和doller符

  + 要求不可以用Java关键字

  + 杜绝拼音，使用英文或者英文的缩写，尽量做到见名知意

  + 变量名首字母小写，其后每个单词首字母大写，比如userName, 小驼峰命名法

  + 类名首字母大写，其后每个单词也是大写，比如HelloWorld,大驼峰命名法

  + 变量名在一个main 方法中，不可以出现重复的变量名‘

  + 变量名严格区分大小写

  + 变量名长度没有限制

  + 变量需要先声明再赋值；先赋值再使用；

  + 一个变量的声明就是一条Java语句，以分号结束，一分号，一换行，

  + 一条语句中声明多个同类型变量

  + ```d
    int a,b;//声明两个变量
            a = 10;
            b = 20;
            double x = 1.0,y=2.0;

  ```

03-运算符

+ 加减乘除+-*/取余%

+ ```
   public static void main(String[] args) {
          int num1 = 10;
          int num2 = 2;
     //        申请空间存储和
          int sum = num1 + num2;
          System.out.println("求和结果是" + sum);
          System.out.println("求和结果是" + (num1+ num2));
          int num3 =8;
          int num4 =3;
     //        两个整数相除，结果仍然是整数，只保留商
          int num5 = num3 / num4;
          System.out.println("除法结果是" + num3 / num4);
     //取余
          int num6 = num3 % num4;
          System.out.println("余数是" + num6);
          System.out.println(-10%3);//余数是-1
          double d1 = 9.0;
          double d2 = 2;
          System.out.println(d1  /d2);
   ```


      }
  ```

+ 赋值运算符=

+ ```
    String name = "admin";
  //              一个变量给另外一个变量赋值
          String name2 = name ;
          String name3 = "你好，" + name;
  ```

+ 赋值左侧为变量，右侧可以是常量，也可以是变量，也可以是一个表达式，只要有运行结果即可

+ 自加自减++，--

+ ```
   int num3 = 10;
          System.out.println(num3 ++);
     //        加加在后先执行输出，然后再进行++
          System.out.println(num3);
          int num4 =10;
          System.out.println(++ num4);
     //        ++在前，先加加，然后再输出
          int num5 = 10;
     //        System.out.println(num5 ++ +1 );
     ////        只要++再后面最后一步做++
     //        System.out.println(num5);
          System.out.println(--num5 /2);
     //        先减减，再/2，最后输出
          System.out.println(num5);
   ```



  //
  ```

  + --++的作用是在变量本身的值上进行+1或者-1的动作
  + 可以出现在变量前，也可以出现在变量后
  + num++; ++num;没有区别
  + sout(num++);sout(++num)
    + ++在后，先执行其他操作，最后执行++
    + ++在前，先执行++，然后再执行其他动作

+ num5 ++ +1 +num5 

+ 第二个num5发生改变

+ 自身运算符

+ ```
  int num1 = 10;
          num1 = num1 + 2;
  //        等价于
          num1 += 2;
          num1 -= 2;//num1 = num1 - 2;
          num1 *= 3;
          num1 /= 2;
          num1 %= 2;
          
      }
  ```

  04-数据类型转换

+ 自动类型转化

+ ```
    int num1 = 10;
          double num2 = num1;
      //        自动类型转换,小范围转大范围
          float num3 = num1;
          System.out.println(num1/1.0);
      //        当表达式中有一个是double类型，那么结果将会提升为一个double类型
          int num4 = 8;
          System.out.println(1.0 * num4 / 3.0);
    ```



  ```

+ 强制类型转换

+ 大范围转小范围

+ ```
  double num5 = 1;
          int num6 = (int)num5;

  ```

  + 类型转换保证数据的类型兼容

+ byte,short,chor

  + 当以上三种类型的变量作为操作参数时，结果都会提升为int

  + ```
     byte b1 = 1;
       //      运算结果必须使用int类型变量接受
            int num = b1 +1;
            char c1 = 'a';
            int numc = c1 +1;
       //        
            b1++; //b1 =b1 +1
            c1 +=1;
       //        没有显示作为参数
     ```

    ```

  + 显示的作为操作数参加运算了，结果必须是int 变量接受

  + 但是++,--或者+=可以正常运行

    ```

+ ​