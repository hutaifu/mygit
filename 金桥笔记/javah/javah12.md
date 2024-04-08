## Java8新特性

### 01-Lambda表达式

+ 接口的的实现方式

+ 实现方式二：利用匿名内部类

+ ```
  public class Test02 {
      public static void main(String[] args) {
          //匿名内部类实现了接口的抽象方法
          MyInterfance myInterfance = new MyInterfance(){
               public String strHandler (String str) {
                   return str.substring(2, 5);
               }
              };
          String str = myInterfance.strHandler("hello");
          System.out.println(str);
      }
  }

  ```

+ Lambbba表达式的主要作用是简化匿名内部类的写法

+ 使用要求：

  + 接口中只能有一个抽象方法
  + java将这种只有一个抽像方法的接口称为函数式接口
  + 可以通过@Functionallnertfance标识函数接口，同时它会去检查该接口种的抽象方法个数。

+ Lambda应用

+ 实现带一个参数并且有一个返回值的抽象方法

+ ```
  public class Test02 {
      public static void main(String[] args) {
          //匿名内部类实现了接口的抽象方法
          MyInterfance myInterfance = new MyInterfance(){
               public String strHandler (String str) {
                   return str.substring(2, 5);
               }
              };
          String str = myInterfance.strHandler("hello");
          System.out.println(str);
      }
  }

  ```

+ 实现无参无返回值的抽象方法

+ ```
  @FunctionalInterface
  public interface MyInerfance02 {
      void show();
  }

  ```

```
public class Test04 {
    public static void main(String[] args) {
        MyInerfance02 myInerfance02 = () -> System.out.println("hello word");
    }
}

```

+ 实现多个参数，多条语句的抽象方法

+ ```
  @FunctionalInterface
  public interface MyInerface03 {
      void add(int num1,int num2);
  }
  public class Test05 {
      public static void main(String[] args) {
          MyInerface03 myInerface03 = (num1, num2) -> {
              int sum = num1 + num2;
              System.out.println(sum);
          };
          myInerface03.add(10,20);
      }
  }

  ```

  + lambda表达式主要用于实现一个函数接口中的抽象方法
  + 参数 -> 方法体
  + 参数的形式
    + （）无参
    + s 一个参数
    + （x，y） 多个参数
  + 方法体
    + sout（）；
    + num1 + num2;//计算并返回    自动返回
    + {多条语句}

### 02-四种函数式接口

+ Consumer接口

  + 消费型接口，需要参数，但是没有返回值

  + ```
    public class Test01 {
        public static void show(int money,Consumer<Integer> consumer){
            consumer.accept(money);
        }

        public static void main(String[] args) {
            //消费型函数式接口，提供accept方法，要求有参数，但是没有返回值
            //我们定义的泛型是什么类型，那么accept方法就接收什么类型参数
          /*  Consumer<String> consumer = str -> System.out.println(str);
            consumer.accept("hello");*/
          Consumer<Integer> consumer = money -> System.out.println("花费了" + money + "元");
            show((1000);
        }
    }

    ```

+ supplier接口

  + 供给型接口，没有参数，但是有返回值

  + 应用

  + ```
    public class Test02 {
        public static List<Integer> integerList(int num,Supplier<Integer> supplier) {
            List<Integer> list = new ArrayList<>();
            //向集合中存放随机数，存放num个
            //随机数通过supplier对象获得
            for (int i = 0; i < num; i++) {
                list.add(supplier.get());
            }
            return list;

        }
        public static void main(String[] args) {
            //供给型接口，get方法无参，但是有返回值
           /* Supplier<String> stringSupplier = () -> "java" + Math.random();
            String str = stringSupplier.get();

            Supplier<Integer> integerSupplier = () -> 1+2;
            System.out.println(integerSupplier.get());*/

           Supplier<Integer> supplier = () -> (int)(Math.random() * 100);
           List<Integer> list = integerList(10,supplier);

           for (Integer integer : list){
               System.out.println(integer);
           }
        }
    }

    ```

+ Function接口

  + 函数式接口，要求有参数，并且有返回值

  + ```
    public class Test03 {
        public static void main(String[] args) {
            Function<String,Integer> function = str -> str.length();

            int lenght = function.apply("java");
            System.out.println(lenght);

            Function<Integer,String[]> function1 = count -> new String[count] ;//{
              /*  String[] strings = new String[count];
                return strings;*/
    //        };
            String[] strs = function1.apply(5);
            strs[0] = "java";

            for (int i = 0; i < strs.length; i++) {
                System.out.println(strs[i]);
            }
        }
    }
    ```

Predicate接口

+ 断言式函数，有参数，返回布尔类型

### 03-方法引用和构造器的应用

+ 方法引用的场景

  + 如果lambda表达式的右侧，方法体，是调用了某对象的方法。

  + 比如System.out.println() 就是system.out对象调用print方法

  + 比如str。length（）是str调用length方法

  + 以上场景可以使用方法引用的语法实现lambda表达式

  + 保证对象调用的方法和接口中的抽象方法格式一致，要有相同的返回值类型和参数类型

  + ```
    public class Test01 {
        public static void main(String[] args) {
            Consumer<String> consumer = str -> System.out.println(str);

            Consumer<String> consumer1 = System.out::println;
            consumer1.accept("hello");
    ```


            Function<String,Integer> function = str -> str.length();
​            

        }
    }
    
    ​```
+ ​	

  + 自定义对象

  + ```
        public static void main(String[] args) {
            Emp emp = new Emp("张三",20);
            //共给式接口可以访问同一级别的局部变量
            //getName和接口中的get方法都是无参带返回值的方法
            //可以应用方法引用
            Supplier<String> supplier = () -> emp.getName();
            supplier.get();
            
            Supplier<String> supplier1 = emp::getName;
            System.out.println(supplier1.get());
            
            String s = "java";
            Supplier<Integer> supplier2 = () -> s.length();
            Supplier<Integer> supplier3 = s::length;
            supplier2.get();



        }

    }
    ```

+ 函数式接口的方法中可以直接访问当前范围的局部变量

  + 类名：：静态方法

  + ```
    public class Test03 {
        public static void main(String[] args) {
            BiFunction<Integer,Integer,Integer> biFunction = (x,y) -> Integer.compare(x,y);
            //0   1  -1
            System.out.println(biFunction.apply(10,20));

            //类名：静态方法
            BiFunction<Integer,Integer,Integer> biFunction1 = Integer::compare;
            System.out.println(biFunction1(20,));;
        }
    }

    ```

+ 类名：成员方法

+ ```
  public class Test04 {
      public static void main(String[] args) {
          String s = "java";
          //将str传递到方法中，返回长度
          Function<String,Integer> function = str -> str.length();
          System.out.println(function.apply(s));

          //将参数传到方法中，利用参数调用方法的场景
          //可以使用类名：：方法名
          Function<String,Integer> function1 = String::length;

          Supplier<Integer> supplier = s::length;
      }
  }

  ```

+ 构造器引用

  + lambda表达式的右侧，在调用某个构造方法创建对象或者通过new关键字创建数组或者集合，可以将表达式简写为构造器形式

  + 类名：：new

  + ```java
    public class Test05 {
        public static void main(String[] args) {
            Supplier<Emp> supplier = () -> new Emp();
            Emp emp = supplier.get();
            
            //调用无参构造方法
            Supplier<Emp> supplier1 = Emp::new;
            BiFunction<String,Integer,Emp> biFunction = (name,age) -> new Emp(name,age);
            biFunction.apply("张三",20);
            
            BiFunction<String,Integer,Emp> biFunction1 = Emp::new;
            Emp emp1 = biFunction1.apply("张三",20);

            Function<Integer,String[]> function = count -> new String[count];
            Function<Integer,String[]> function1 = String[] ::new;
            //返回长度为5的字符串数组
            String[] strs = function1.apply(5);
        }
    }
    ```

+ ​