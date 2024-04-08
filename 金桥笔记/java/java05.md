循环操作

+ 在符合某种条件的情况下，多次循环执行某个操作。

+ 分析循环操作

  + 循环动作：重复执行的动作
  + 循环条件：满足什么情况去执行重复动作
  + 保证循环条件有不成立的时候，不然会成为死循环

  01.while循环结构

+ ```
   int count =0;
          while (count < 100){
              System.out.println("第"+(count +1)+"遍：");
              System.out.println("好好学习，天天向上");
              count ++;
          }
  ```

+ while (循环条件){

  + 循环操作
  + 包含循环条件的改变
  + }

+ 特点

  + 先判断条件再执行循环操作

  + 循环动作最少执行0次、

  + whlie 适用于循环次数不确定的情况

  + ```
      public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            //存储老师的检查结果
            String answer = "";
            System.out.println("张三进行测试");
            System.out.println("合格了吗？（y/n）");
            answer = input.next();
            
            while ("n".equals(answer)){
                System.out.println("上线学习理论，下午上机编程");
                System.out.println("测试，检查，合格了吗？");
    //            保证条件有成立的时候
                answer = input.next();
            }
            System.out.println("完成学习任务");
        }
    }

    ```

  + do-while

  + 应用

  + ```
    Scanner input = new Scanner(System.in);
            String answer ="";
            do {
                System.out.println("上午学习理论，下午上机编程");
                System.out.println("合格了吗（y/n）");
                answer = input.next();
            } while (!"y".equals(answer));
    //        循环结束
            System.out.println("完成学习任务");
        }
    }
    ```

  + do {

  + 重复动作

  + } whlie(循环条件)

+ 特点

  + 语法结构最后以分号结尾
  + 先执行循环动作再判断循环条件
  + 循环动作最少执行一次
  + 适用于循环次数不确定的情况

  03.程序的调试

+ 首先加断点，断点是我们希望程序停止的位置

  + 断点一般加在报错位置之前
  + 加在可执行的代码前
  + 在行号前单击，再次单击取消断点

+ 以debug模式运行程序

  + 程序会停在我们添加断点的位置

+ 我们控制程序的运行

  + F8 step over ,控制程序单步执行
  + 让虚拟机一句一句的往下执行
  + 执行的时候，要注意观察变量的变化。

+ 让程序直接结束的话，通过F9或者左侧的绿色箭头