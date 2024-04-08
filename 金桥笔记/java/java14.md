## 方法的应用

+ 内存分配
+ 基本数据集类型
+ 引用数据类型 String, 数组，对象
+ 方法的传参
  + 基本数据类型作为参数时，会将具体的值复制一份，传递给方法内的形参。
  + 方法内的形参可以看作是方法内部的局部变量，当调用方法进入方法时，形参被创建，被赋值，然后方法结束后， 该形参的空间位置就被回收了。
+ 基本数据类型作为参数时，不论方法内部如何操作都不会影响原来的值，因为方法内部操作的都是复制的形参值


```
public class Calcu {
    public int cal01(int num){
//        形参都是方法的局部变量
        num += 10;
        return num;

    }
//    public void calu02(){
//        int num= 10;



    public static void main(String[] args) {
        Calcu calcu = new Calcu();
        int num = 10;
//        方法在传递参数时会将当前方法复制一份,传到方法中
        int num02 = calcu.cal01(num);
        System.out.println(num);
        System.out.println(num02);
//        基本数据作为参数时，方法内的操作都不会影响原来的数据
    }
}

```

+ 引用数据类型作为参数
+ 会将实参变量的值复制一份传递给方法内的形参，引用数据类型变量中存储的是一个地址，所以这个过程是将地址复制了一份转递给了方法的形参
+ 地址相同，所以形参指向同一块堆空间
+ 所以在方法内部对元素修改，会影响方法外部原来的实参

```
public class CarArray {
    public void setArray(int[] nums){
        nums[1] += 10;
        System.out.println(nums[1]);
    }

    public static void main(String[] args) {
        CarArray carArray = new CarArray();
        int[] nums = {1,2,3};

        carArray.setArray(nums);
        System.out.println(nums[1]);
    }
}

```

+ 引用数据类型进入到重新进行new操作，申请了新的堆空间，那么之后所有的新操作都是在新的堆空间中进行，不会影响原来的值。

```
public void setArray02(int[] nums){
    nums[1] += 10;
    nums = new int[3];
    nums[1] += 10;
    将地址返回
    System.out.println(nums[1]);
}
```

+ 引用数据类型作为返回值时，

+ 会将变量当中的地址返回出来，接受到另一个变量中，因为地址相同，所以可以在方法之后访问堆中的元素。

+ 对象类型作为参数

+ 内存分配和数组相同，也是将地址复制了一份传递给了形参，实参和形参指向同一块堆空间。

+ 所以在方法内部修改了对象的属性，会影响外面对象的属性。

+ 同时我们可以在方法内部访问到所有原来对象的属性

+ 对象类型的数组

  + 指的是首先有一个数组，数组的每个元素初始值为null，需要new类型[]
  + 数组每个元素上都是一个对象，需要new类型（）出来

+ 传参是将地址传递过去，方法内部依然访问的是开始申请的空间

+ ```
   public static void main(String[] args) {
          Scanner input= new Scanner(System.in);
          Student[] stus = new Student[5];
          for (int i = 0; i < stus.length; i++) {
              Student student = new Student();
              System.out.println("请输入身高");
              student.height = input.nextDouble();
  //            将学生赋给数组
              stus[i] = student;
          }
          Heightcal heightcal = new Heightcal();
          double avg = heightcal.getavg(stus);
          System.out.println("平均身高是" + avg);
      }
  }

  ```

## 类的方法

+ 方法指的是一个独立的功能块，有自己的参数以及返回值。

+ 方法三要素：

+ 返回值类型，方法名，（参数列表）

+ 方法的声明或者定义

  + 说明当前类具有什么功能，是怎么实现的。

+ 方法的使用：

  + 对象名.方法名()；
  + 在一个方法中调用其他方法
    + 方法名();

  ## 递归算法

+ 方法调用方法本身的算法就是递归算法

```
public class Test04 {
//    求num的阶乘
//    f(n)用于求n的阶乘，n+1的阶乘f(n+1) = f(n) * (n+1)
    public int fact(int n){
        if (n == 0 || n == 1) {
            return 1;
        }
        return fact(n-1) * n;

    }

    public static void main(String[] args) {
        Test04 test04 = new Test04();
        int num = test04.fact(2);
    }
}

```

斐波那契数列

