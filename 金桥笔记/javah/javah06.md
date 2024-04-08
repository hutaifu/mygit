## 集合框架

### 01-数组存储批量数据的问题

+ 数组申请时，必须指明长度，一块连续的空间。
+ 这个长度无法改变。数组空间无法扩展。
+ 如果需要存储更多数据，需要不断的申请新的数组。

### 02-集合存储批量数据

+ 集合也是用于存储批量数据，优势是创建是无需指定长度
+ 往集合中存储数据时才会在内存中申请空间，
+ 可以不断的申请新的数据，集合的长度随时可以扩展。

### 03-List集合

+ List是一个接口，接口中声明了集合应该具有的方法

+ 接口下有两个实现类

  + ArrayList
  + LinkedList

+ 我们去创建实现类的对象，作为集合对象，用于存储批量数据。 

+ ArrayList

  + ```java
    package com.jxd.ch0601;

    import java.util.ArrayList;
    import java.util.List;

    /**
     * @ClassName TestArrayLIst
     * @Description TODO
     * @Author Hutaifu
     * @Date 2022/8/5
     * @Version 1.0
     */

    public class TestArrayLIst {
        public static void main(String[] args) {
            //声明集合对象
            List list = new ArrayList();
            //存储数据,可以存储object类型，也就是任意数据
            list.add("hello");//按照顺序依次存放内容
            list.add(100);
            System.out.println(list.size());
            list.add(1,"java");//将元素放在指定位置上。

            //获取集合的长度
            System.out.println(list.size());

            //获取集合中的元素
            System.out.println(list.get(1));
            //获取到的是Object类型，如果需要作为具体的字符串或者整型进行处理
            //需要强转
            String str = (String)list.get(0);
            System.out.println(str.length());

            //遍历输出
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            //删除集合中的元素
            list.remove(1);
            list.remove("hello");
            System.out.println(list.size());
            if (list.remove("hello")){

            }

            //查找集合中是否包含某个元素
            if (list.contains(100)){
                System.out.println("包含");
            }
    ```


        }
    }
    
    ​```

  + ArrayList实现了List接口，重写list接口中所有的抽象方法

  + 我们使用时，声明接口类型，创建实现类类型即可

  + 声明是接口类型，所以list只能访问到接口中声明的方法

  + 创建的是ArrayList类型，所有真正运行时，运行的是ArrayList中的方法

  + ArrayList底层实现是数组，所有内存空间是连续的

  + 这个集合是有顺序的，可以通过下标访问

  + ArrayList遍历效率非常高

  + 但是插入或者删除，效率稍微低一些

+ LinkedLis的使用

+ ```java
  package com.jxd.ch0601;

  import java.util.LinkedList;
  import java.util.List;

  /**
   * @ClassName TestLinkedList
   * @Description TODO
   * @Author Hutaifu
   * @Date 2022/8/5
   * @Version 1.0
   */

  public class TestLinkedList {
      public static void main(String[] args) {
          LinkedList list = new LinkedList();
          list.add("hello");
          list.addFirst("java");
          list.addLast("I");

          System.out.println(list.size());

          for (int i = 0; i < list.size(); i++) {
              System.out.println(list.get(i));
          }
          
          list.removeFirst();//移除第一个
          list.removeLast();
          list.remove(1);
          if (list.contains("java")){
              
          }
      }
  }

  ```

  + 使用时，要声明LinkedList实现类类型，创建实现类型
  + 这样可以调用到LinkedList中特殊方法
  + LinkedList底层实现为链表，每个元素中除了存储当前元素的值之外，还会存储下一个元素的地址，通过这样的形式把每个元素串联在一起，形成表结构
  + LinkedList是有序的，可以使用下标访问
  + 基于链式结构，LinkedList插入和删除操作效率非常高
  + 但是遍历查询效率非常低。

+ List接口中的常用方法

  + add();将元素添加在最后
  + add(int,Object);在指定位置插入
  + size()长度
  + remove(int index) 删除指定位置元素
  + remove(Object) 删除指定元素
  + get(int) 获取指定位置元素
  + contains(Object)判断集合中石佛包含某个元素。

### 04-有序集合遍历

+ List接口规定了，集合存储的数据必须是有序的，不唯一的。

+ ```java
  public class TestFor {
      public static void main(String[] args) {
          List list =  new ArrayList();
          list.add(new Dog("大毛","金毛"));
          list.add(new Dog("二毛","拉布拉多"));
          list.add(new Dog("三毛","哈士奇"));

          //1.fori循环
          for (int i = 0; i < list.size(); i++) {
              Dog dog = (Dog)list.get(i);
              System.out.println(dog.getName());
          }
          
          //for each循环
          //遍历这个集合中的每一个obj对象
          for (Object obj : list) {
              Dog dog = (Dog)obj;
              System.out.println(dog.getName());
          }
          
          //3.迭代器循环
          Iterator it = list.iterator();
          //hasNext用于判断集合中是否有下一个元素
          //Next用于获取这个元素
          while (it.hasNext()){
              Dog dog = (Dog)it.next();
              System.out.println(dog.getName());
          }
      }
  }

  ```

### 05-泛型

+ List中目前可以存储任意类型的数据，虚拟机会把它们都转为Object类型

+ 我们通过get或者其他方式获取到集合中的元素时，也是Object类型

+ 我们需要进行强制类型转换后，才能进行其他操作

+ 可以通过泛型限制集合中只能存储某种固定类型的数据

+ ```java
  public class TestList {
      public static void main(String[] args) {
          List<Dog> list = new ArrayList<>();
          list.add(new Dog("大毛","金毛"));

          for (int i = 0; i < list.size(); i++) {
              System.out.println(list.get(i).getName());
          }

          for (Dog dog : list) {
              System.out.println(dog.getName());
          }

          Iterator<Dog> it = list.iterator();
          while (it.hasNext()){
              System.out.println(it.next().getName());
          }
          
          List<int[]> list1d = new ArrayList<>();
          
          List<List<String>> lists = new ArrayList<>();
          List<String> list1 = new ArrayList<>();
          list1.add("hello");
          list1.add("java");
          
          lists.add(list1);
      }
  }

  ```

  + 限定了泛型后，集合中只能存储这种类型的数据
  + 获取元素时，不再需要强转，


### 06-Map集合

+ Map是一个接口，规定了一种以key-value的形式存储数据的集合

+ map集合中的一个元素是一个键值对，一个key，一个value值。

+ key值唯一，value值可以重复。

+ 两个实现类，

  + HasMap  线程不安全
  + HasTable   线程安全
  + HasMap 的使用

+ ```java
  public class TestMap {
      public static void main(String[] args) {
          //创建map集合
          Map map = new HashMap();
          //存储数据
          map.put("CN","中华人民共和国");
          map.put("RU","俄罗斯联邦");
          map.put("FR","法兰西共和国");
          map.put("FR","法国");//如果有重复的key值，那么value值会被覆盖

          //map的长度
          System.out.println(map.size());

          //获取map中的值，通过key值获取value值//map是无序的，无法通过下标访问。
          System.out.println(map.get("FR"));

          map.put("UA",123);

          //移除数据
          map.remove("RU");
          System.out.println(map.get("RU"));//null值

          //直接输出map中的数据
          System.out.println(map.keySet());
          System.out.println(map.values());
          System.out.println(map);
          
          //判断是否包含某个key值
          if (map.containsKey("CN")){
              System.out.println("包含");
          }
          
          if (map.containsValue("法国")){
              System.out.println("包含");
          }
          
          //泛型map
          Map<String , Dog> mapDog = new HashMap<>();
          //key值必须是String类型，value值必须是Dog类型
          mapDog.put("001",new Dog("毛毛","泰迪"));
          mapDog.put("002",new Dog("大毛","柴犬"));
          
          //获取元素，并且输出
          Dog dog = mapDog.get("002");
          System.out.println(dog.getName());
        

          mapDog.put("003",null);//value值可以为空
          mapDog.get("003").getName();//空指针异常



      }
  }

  ```

  + 声明Map接口类型，创建实现类类型
  + key值对于我们来说是已知的，我们自己指定的，获取元素时，都是通过key值获取value值
  + map是无序的，不能通过下标访问
  + Map中的泛型需要同时设置两个，一个用来限制key的类型，一个用来限制value的类型，用逗号隔开
  + 常用方法
    + put（key，value）；
    + get（key）；通过key值获取value值
    + size（）；长度，键值对个数。
    + remove（key）；通过key值移除整个元素。
    + KeySet（） 获取所有的key值
    + value（） 获取所有的value值

### 07-集合框架的API

+ 顶层接口是：Collection：可以批量存储数据，无序不唯一的数据
  + List子接口：继承了Collection可以存储一组有序不唯一的数据。
    + ArrayList
    + LinkedList
  + Set子接口：可以存储一组无序但是唯一的数据
    + HashSet
    + TreeSet
+ Map接口：存储键值对的，无序的，key值唯一的，value不唯一
  + HashMap
  + HashTabel

### 08-Collections工具类

+ 用于操作Collection接口下的实现类的

+ ```java
  public class TestCollections {
      public static void main(String[] args) {
          List<String> list = new ArrayList<>();
          //批量添加
          Collections.addAll(list,"hello","java","!");
          System.out.println(list.size());
          //排序
          Collections.sort(list);
          //反转
          Collections.reverse(list);
      }
  }

  ```

  + 工具类中的方法都是静态的

### 09-集合的应用

+ List中存储Map集合

+ ```java
  public class TestListMap {
      public static void main(String[] args) {
          List<Map<String,String>> list = new ArrayList<>();
          //创建mapo
          Map<String,String> map1 = new HashMap<>();
          map1.put("001","张三");
          map1.put("002","李四");
          list.add(map1);

          Map<String,String> map2 = new HashMap<>();
          map2.put("001","王五");
          map2.put("002","赵六");

          list.add(map2);

          System.out.println(list.size());

          //遍历所有班级所有学生
          for (Map<String,String> map : list) {
              System.out.println(map.get("001"));
              System.out.println(map.get("002"));
          }
      }
  }

  ```

+ ​

