01.布尔类型

```
      //布尔变量
        boolean flag = true;
        //命名格式
        boolean isSuccess = false;
        int age1 = 20;
        int age2 = 21;
        System.out.println(age1 > age2);
```

02,计较运算符

+ <    >     <=   >=    !=     == 数字的比较

+ 字符串我们一般只比较等于

  03 -if选择结构

+ ```
   int zhangSocer = 94;
          //张三的成绩
          //从键盘输入李四的成绩
          Scanner input = new Scanner(System.in);
          System.out.println("请输入李四的成绩：");
          double liScore = input.nextDouble();//获取键盘输入的成绩
          //判断张三的成绩是否大于李四的成绩
          if(zhangSocer > liScore){
              System.out.println("奖励张三一个U盘");
          }
  ```

+ if(条件表达式){

  + //条件成立就执行，条件不成立就不执行
    +  			}

+ （条件表达式）结果为true,执行，结果为flase,不执行

+ 复杂判断条件

+ ```
    Scanner input = new Scanner(System.in);
          System.out.println("请输入张三的html成绩：");
          double htmlSore = input.nextDouble();
          System.out.println("请输入张三的Java成绩：");
          double javaScore = input.nextDouble();
  //        if(htmlSore > 90 && javaScore >85){
  //            System.out.println("奖励张三一个u盘");
              //满足其中一个条件
              if (htmlSore == 100 || javaScore >99){
                  System.out.println("奖励张三一个u盘");
              }
                  if ((htmlSore > 90 && javaScore >80) || (htmlSore > 95 && javaScore>90)){
                      System.out.println("奖励张三");
                  }
                  if (htmlSore !=100){
                      System.out.println("没有满分");
                  }
                  if (!(htmlSore >90)){
                      System.out.println("没有到九十分");
                  }
                  if (!true){
                      System.out.println();
                  }
      }
  }
  ```

  + &&连接的条件必须同时满足，整个结果才是true

  + ||，连接的俩个条件，只需满足其中一个即可；

  + ！，非运算符，非真为假，非假为真。

  + &&和||短路特性

  + ```
    int num1 = 1;
            int num2 = 1;
           if (num1++ ==1 || ++num2 ==2){
               num1 =7;
           }
            System.out.println(num1);//7
            System.out.println(num2);//1
    ```

  + &和|：也是用于连接两个条件，同时满足或者满足其中一个，但是没有短路特性

    04.if-else是二选一结果

+ ```
   public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          System.out.println("请输入张三的成绩：");
          int sore = input.nextInt();
          if (sore > 90){
              System.out.println("奖励张三");
          }else{
              System.out.println("惩罚张三");
          }
          //条件不成立的代码
  //        if (sore <= 90){
  //            System.out.println("奖励张三");
  //        }
      }
  ```

+ if（条件表达式）{

  + 条件成立执行的代码

    }else{条件不成立执行的代码

    }

+ else必须跟着if之后

  三目运算符

  ```
   int num1 = 10;
      int num = num1 > 5 ? 1 : 0;
          System.out.println(num);
          //赋值号右侧是表达公式，有一个0.0的double,操作数为
          double numd =  num1 > 5 ? 1 : 0.0;
  ```

  ​

+ 变量 = 比较表达式 ？ 成立的取值；不成立的取值

  06 字符串的比较

  ​