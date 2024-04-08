01、for循环

+ 100遍的好好学习

+ ```
       }
          for (int i= 0; i < 100; i++){
              System.out.println("好好学习，天天向上");
          }
   ```
  ```

+ for (int i = 初值; 循环条件；变量迭代  )

  + 循环动作

+ }

+ 执行顺序

  + i的初始化，只执行一次
  + 然后判断条件，如果符合去执行循环动作
  + 如果不符合条件，就直接跳出循环结构，循环动作最少执行0次。
  + 循环动作结束后，去执行变量的迭代
  + 变量变化了，要去判断条件是否依然满足

+ 注意事项

  + for用于实现循环次数确定的情况
  + 固定的使用i变量作为计数器
  + i一般不作为普通变量使用
  + i从0开始，i<循环次数

+ for循环的几种语法

+ ```
  for (int i= 0; i < 100; i++){
  //            System.out.println("好好学习，天天向上");
  //        }
  //        int i = 0;
  //        for (;i < 100; i++){
  //            System.out.println("学习");
  ////
          int i = 0;
          for (;i< 100;){
              System.out.println("学习");
          }
          for (;;){
              System.out.println("学习");
          }
  ```

+ ```
    Scanner input = new Scanner(System.in);
          String name = "";
          int sum = 0;
          double aba = 0;
          System.out.print("请输入学生姓名：");
          name = input.next();
          for (int i = 0; i < 5; i++) {
              System.out.println("请输入第"+(i+1)+"门课成绩");
              sum += input.nextInt();
          }
          System.out.println("张三的平均分是"+(sum / 5.0));
    ```
  ```

+ ```
  Scanner input = new Scanner(System.in);
          System.out.println("请输入一个数");
          int num = input.nextInt();

          for (int i = 0,j= num; i <= num; i++,j--) {
              System.out.println(i+ "+" +j+ "=" + num);
          }
  ```

02.break

+ 作用：跳出某个循环

+ ```
  boolean isSuccesss = true;
          int score = 0;
          Scanner input = new Scanner(System.in);
          String name = "";
          int sum = 0;
          double aba = 0;
          System.out.print("请输入学生姓名：");
          name = input.next();
          for (int i = 0; i < 5; i++) {
              System.out.println("请输入第"+(i+1)+"门课成绩");
              score = input.nextInt();
              if (score < 0){
                  isSuccesss = false;
                  break;
              }
              sum += score;
          }
          if (isSuccesss) {
              System.out.println("张三的平均分是" + (sum / 5.0));
          }else {
              System.out.println("录入错误，请重新录入");
          }

  ```

  + 用在循环中，作用是结束循环
  + 会影响循环次数
  + 执行break后，直接跳出循环结构，执行循环后的结构
  + 也能用在while和do-whlie的循环中

  03、continue

+ ```
  Scanner input = new Scanner(System.in);
          int stuCount = 0;
          int highCount = 0;
          System.out.print("请输入学生数量：");
          stuCount = input.nextInt();
          for (int i = 0; i < stuCount; i++) {
              System.out.println("请输入第"+(i+1)+"个学生的成绩");
              int score = input.nextInt();
              if (score < 80){
                  continue;
              }
              highCount++;

          }
          System.out.println("80分以上的 比例是" + highCount / 1.0 * stuCount * 100.0 + "%");
      }
  ```

+ 作用

  + 只能用在循环中，while ,do-whlie.for .
  + 提前结束循环，进入下一轮循环
  + 不影响循环次数

+ break和continue的区别

  + break可以出现在循环中也可以出现在switch中
    + 作用 是跳出当前结构
    + 用在循环中，会影响循环次数
  + continue只能用在循环中
    + 作用提前结束本轮循环，进入下一次循环
    + 不影响循环次数

  04.循环结构

+ while

  + 先判断循环条件再进行循环动作，循环动作最少执行0次
  + 适用于次数不确定的循环

+ do-whlie

  + 先进性循环动作，再判断循环条件，最少执行1次
  + 适用于次数不确定的循环

+ for

  + 先判断条件，再去执行动作，循环动作最少0次
  + 适用于次数确定的循环。

