## 方法的参数

+ 打印机类，打印机对象

  + 品牌、型号、颜色
  + 打印：需要独立于打印机的外部的条件，需要外部数据

+ 如果某个类的成员方法，某个功能在执行时，需要依赖外部的数据，外部数据指的是没有在类中定义的数据。那么我们就需要以方法参数的形式将外部的数据拿到方法内部进行使用。

+ ```java
  public class Printer {
      String brand;
      String type;
      String color;
  
      /**
       * 打印功能
       * @param paper ：打印功能执行时需要的外部数据
       */
      public void print(String paper){
          System.out.println("使用" + paper + "打印文件");
      }
  
      public void show(){
          System.out.println(brand);
      }
  }
  ```

+ public  返回值类型  方法名(参数类型  参数名称){

  + 使用参数进行操作

+ }

+ 带参方法的调用：

  + 对象名.方法名(对应类型的数据);

+ 多个参数的定义，参数个数在语法上没有要求

  public 返回值类型  方法名(参数类型  参数名1,参数类型 参数名2,参数类型 参数名3){

  ​	利用传递进来的参数进行操作

  }

+ 多个参数方法的调用：

  + 对象名.方法名(参数1,参数2，参数3);

+ 形式参数，形参和实际参数，实参

  + 形参指的是方法声明时指定的参数
  + 实参指的是方法调用时，传递进去的具体数据
  + 形参和实参在类型上，个数上以及顺序上要一一对应。

## 参数的应用

```java
public class StudentBiz {
    //属性，用于代表小组中的位置
    String[] names = new String[10];

    public void addName(String name){
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null){
                names[i] = name;
                break;
            }
        }
    }

    //修改学生姓名
    public void edit(String oldName,String newName){
        boolean isFind = false;
        for (int i = 0; i < names.length; i++) {
            if(names[i] == null){
                break;
            }
            if(oldName.equals(names[i])){
                names[i] = newName;
                isFind = true;
                break;
            }
        }
        if (isFind){
            System.out.println("找到并修改成功");
        } else {
            System.out.println("未找到");
        }
    }


    public void showName(){
        for (int i = 0; i < names.length; i++) {
            if(names[i] == null){
                break;
            }
            System.out.println(names[i]);
        }
    }

}

```

```java
public static void main(String[] args) {
        /*StudentBiz studentBiz = new StudentBiz();
        studentBiz.addName("张三");
        studentBiz.addName("李四");

        //展示学生信息
        studentBiz.showName();*/

        StudentBiz studentBiz01 = new StudentBiz();
        studentBiz01.addName("刘备");
        studentBiz01.addName("关羽");
        studentBiz01.showName();


        Scanner input = new Scanner(System.in);
        String oldName = input.next();

        studentBiz01.edit(oldName,"关云长");
        studentBiz01.showName();
}
```

```java
public class StudentBiz {
    //属性，用于代表小组中的位置
    String[] names;
}
public static void main(String[] args) {
        StudentBiz studentBiz = new StudentBiz();
        studentBiz.names = new String[10];

        studentBiz.addName("张三");
        studentBiz.addName("李四");
}
```

## 基本数据类型和引用数据类型的区别

+ 基本数据类型是在栈中申请空间，值直接存储到栈中
+ 引用数据类型，赋值左边的变量在栈中申请空间，赋值号右侧的new操作，在堆中申请空间
  + 如果是数组的new，就是申请数组长度的空间，并在这些空间中赋上数组的初值，然后第一个元素空间的地址，赋值给了左侧的变量
  + 如果是对象的new，就是申请对象属性个数的空间，并在这些空间上放上属性的数值，然后第一个属性的空间地址，赋值左侧的变量
  + 字符串声明 String str = "hello";  hello会在堆中的常量池里申请空间，然后将hello的地址赋值给str。对于代码中相同的字符串常量，不会在常量池中重复申请，只会申请一个。
    + String str01 = "hello";
    + String str02 = "hello";   
    + sout(str01 == str02)；比较是地址，这里相同会返回true









