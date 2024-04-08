## 方法的参数

+ 打印机类，打印对象

  + 品牌，型号，颜色
  + 打印：需要独立于打印机外部的数据

+ 如果某个类的成员方法，某个功能在执行时需要依赖外部的数据，外部数据指的是没有在类中定义的数据，那么我们就需要以方法参数的形式将外部的数据拿到方法内部进行使用。

+ ```
  public class Print {
      String brand;
      String type;
      String color;
  //    打印功能实行时需要的外部数据
      public void print(String paper){
          System.out.println("使用" + paper + "打印文件");

      }

  ```

+ public 返回值类型 方法名（参数类型 参数名称）{

  + 使用参数进行操作
  + }

+ 带参方法的调用：

  + 对象名，方法名（对应类型的数据）；

+ 多个参数的定义

  + public 返回值类型 方法名（参数类型 参数名 ，参数类型 参数名2，参数类型 参数名3）{
  + 利用传递进来的参数进行操作
  + }

+ 多个参数方法的调用：

  + 对象名.方法名（参数1，参数2，参数3；）

+ 形式参数，新参和实际参数，实参

  + 形参指方法声明时指定的参数
  + 实参指的是方法调用时传递进去的具体数据
  + 实参和形参在类型上，个数上以及顺序上要一一对应。 

+ 成员变量有初值

## 参数的应用

```
public class StudentBiz {
//    属性，用于代表小组中的位置
    String[] names = new String[10];
    public void addName(String name){
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null){
                names[i] = name;
                break;
            }

        }

    }
    public void showName(){
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null){
                break;
            }
            System.out.println(names[i]);

        }
    }
//    修改学生姓名
    public void changeName(String oldname,String newname){
        boolean isFind = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null){
                break;
            }
            if (oldname .equals(null)){
                names[i] = newname;
                isFind = true;
                break;
            }
        }
        if (isFind){
            System.out.println("未找到");
            

        }
    }

}

```

```
 public static void main(String[] args) {
        StudentBiz studentBiz = new StudentBiz();
        studentBiz.addName("张三");
        studentBiz.addName("李四");
        studentBiz.changeName("张三","王五");
//        展示学生信息
        studentBiz.showName();
        StudentBiz studentBiz101 = new StudentBiz();
        studentBiz101.addName("刘备");
        studentBiz101.addName("关羽");

  
```

## 基本数据类型和引用数据类型的区间

+ 基本数据类型只在栈中申请空间，值直接存储到栈中，引用数据类型赋值号左边的变量在栈中申请空间，赋值号右侧的new操作，在堆中申请空间
  + 如果数组的new,就是申请数组长度的空间，并在这些空间中赋上数组的初值，然后第一个元素空间的地址，赋值给了左侧的变量
  + 如果对象的new，就是申请对象属性 个数的空间，并在这些空间上放上属性的数值，然后第一个属性空间的地址，赋值左侧的变量。