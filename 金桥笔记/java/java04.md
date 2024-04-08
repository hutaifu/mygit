1.多重if选择结构

+ 什么场景下用多重if

  + 张三，考试，90以上，80以上，良好，60以上，及格，60以下，不及格

  + 连续区间的判断使用多重if的选择结构

  + ```
     public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入张三的成绩");
            int score = input.nextInt();

            if (score >= 90){
                System.out.println("优秀");
            }

            if (score >=80 && score < 90){
                System.out.println("良好");
            }

            if (score >= 60 && score < 80){
                System.out.println("及格");
            }

            if (score <60){
                System.out.println("不及格");
            }
    //        连续区间的判断使用多重if注意顺序，不能随意改变
            if (score >=90){
                System.out.println("优秀");
            }else if (score >=80){
                System.out.println("良好");
            }else if(score >= 60){
                System.out.println("及格");
            }else {
                System.out.println("不及格");
            }
        }
    ```

  + if     else if      else

  + 条件从上到下执行，一旦满足其中一个条件，其他的不再判断

  + else（条件），条件只需要指定一个边界即可，else已包含另一个边界

  + else if 的顺序要保证从大到小或者从小到大

  + else if的个数不限制

  + 最后的else可以省略

  02.嵌套if

+ 在if结构中嵌套另外一个完整的if

+ ```
   public static void main(String[] args) {
          double runScore = 11;
          char sex = '男';
          if (runScore <= 12){
              if (sex == '男'){
                  System.out.println("进入男子组比赛");
              }else {
                  System.out.println("进入女子组比赛");
              }
          }else {
              if (sex == '男'){
                  System.out.println("");
              }
              
          }
          
      }
  }

  ```

+ 嵌套层级不超过三层 

+ 变量的作用域

+ ```
   public static void main(String[] args) {
          int  num1 = 10;

          if (num1 == 10){
              int num2 = 20;
              System.out.println(num2);
              System.out.println(num1);
          }
          //在一个大括号中声明的变量，在大括号结束之后，会被回收
          System.out.println(num2);//num2以及被回收，无法访问
          System.out.println(num1);
      }

  ```

  + 变量只在声明的大括号内有效，Java内存回收程序会将这块内容释放。
  + 代码中使用的变量尽量在main的最开始给出初始值

  03.switch- case-break

+ ```
   public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          System.out.println("请输入张三的名次：");
          int ranking = input.nextInt();

          switch (ranking){
              case 1:
                  System.out.println("参加夏令营");
                  break;//跳出当前判断
              case 2:
                  System.out.println("奖励一个笔记本电脑");
                  break;
              case 3:
                  System.out.println("奖励一个移动硬盘");
                  break;
              case 4:
              case 5:
              case 6:    
                  System.out.println("纪念奖");
                  break;
              default:
                  System.out.println("没有奖励");
          }
      }
  }

  ```

+ 场景应用

  + 等级判断
  + switch(变量或者表达式) {
    + case 取值：
      + 符合值1时的操作
      + break;//结束这个操作}
    + case 取值2：
    + case 取值3：
      + 符合值2值3的操作
      + break;
    + default:
      + 缺省操作

+ 使用注意

  + break不可以省略，如果省略，一旦符合其中一个case值，那么会继续执行其他case值类的操作。直到遇到break关键字
  + case必须是不同的值
  + case个数不限制
  + 不同case值相同的操作可以放在一起判断
  + default 一般放在在后
  + switch可以判断的变量类型不限制

+ 多重if和switch case的区别

  + 多重if连续空间

  04.程序中的异常处理

+ 涉及到用户的输入的时候，经常会出现不匹配的情况

+ ```
   public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          System.out.println("请输入一个整数:");
  //        判断用户输入的是否是一个整数
          if (input.hasNextInt()){
              int num = input.nextInt();
          }else {
              input.nextInt();//将错误的内容拿走
              System.out.println("请输入整数");
          }
          System.out.println("请输入下一个整数");
          int num1 = input.nextInt()；

      }
  }
  ```

+ ​

