## 01-Stream流

+ 输入输出流，用于将java中的数据和文件中的数据进行传输。
+ 流中都是数据，这些都有一个来源，我们称为流的数据源
+ 输入流的数据源，是文件
+ 输出流的数据源是java中变量
+ Stream流中的数据源是一个集合或者是数组，java中批量存储数据的对象
+ 我没可以将集合或者数组中的数据依此放到Stream流 中
+ 我没可以对流中的数据进行筛选，过滤，整合计算等操作，获取我没想要的数据。
+ 流的操作步骤
  + 获取流对象
  + 对流进行处理
  + 流的终止，将流中获取的数据保存下来或者输出。

## 02-流的获取

```
public class Test01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        Stream<String> stream = list.stream();
        
        //方法二
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);
        
        //方法三：
        Stream<String> stream2 = Stream.of("aa","bb","cc");
```

## 03-流的操作

+ 流的操作分为两种：
  + 中间操作：操作完成后，依然得到一个流对象
  + 终端操作：操作完成后，会得到一个新的集合或者新的数组，或者新的具体值。

+ 遍历操作

  + 将流中所有的数据遍历输出到控制台，终端操作。

  + foreach（）

  + ```
    public static void main(String[] args) {
            Stream<String> stream1= Stream.of("a","b","c","d");
            //01-遍历输出
            stream1.forEach(s -> System.out.println(s));
    //        stream1.forEach(System.out::println);
    ```

+ 筛选和切片

  + 属于中间操作，对流中的数据进行过滤，得到的还是流对象

  + 并且流中的数据类型没有发生变化

  + ```java
     //02-筛选和切片，中间操作
     //0201:fillter方法
     List<Emp> list = new ArrayList<>();
     Collections.addAll(list,new Emp("张三",20),new Emp("李四",19),new Emp("王五",18)
     ,new Emp("赵六",21),new Emp("田七",22));
     //筛选年龄大于等于20的员工对象
     /*Stream<Emp> streamEmp = list.stream().filter(emp -> emp.getAge() >= 20);
     streamEmp.forEach(emp -> System.out.println(emp.getName()));*/
     //0202：截断流 limit（）
       // Stream<Emp> stream01 = list.stream().limit(3);
       // stream01.forEach(emp -> System.out.println(emp.getName()));

     //0203：跳过元素 skip（）
     //list.stream().skip(3).forEach(emp -> System.out.println(emp.getName()));

     //0204：去除流中的重复数据：distinct（）
     list.stream().distinct().forEach(emp -> System.out.println(emp.getName()));
     ```

    ```

    ```

+ 映射操作

  + 指的是针对流中每一个数据进行处理，得到新的结果，这些新结果会成为一个新的流

  + map（）中间操作

  + ```
    public class Test03 {
        public static void main(String[] args) {
            List<Emp> list = new ArrayList<>();
            Collections.addAll(list,new Emp("张三",20),new Emp("李四",19),new Emp("王五",18)
                    ,new Emp("赵六",21),new Emp("田七",22));

            //映射操作，map中间操作
            //获取每个对象的姓名值
            //map方法本身有循环动作，会处理每个员工对象，获取他们的姓名信息；
            Stream<String> stream = list.stream().map(emp -> emp.getName());
            stream.forEach(System.out::println);
        }
    }

    ```

+ 排序

  + sort（）中间操作

  + 默认从小到大

  + ```
    public class Test04 {
        public static void main(String[] args) {
            Stream<String> stream = Stream.of("c","d","a","b");
            //升序排序
            stream.sorted().forEach(System.out::println);

    List<Emp> list = new ArrayList<>();
    Collections.addAll(list,new Emp("张三",20),new Emp("李四",19),new Emp("王五",18)
            ,new Emp("赵六",21),new Emp("田七",22));
    ```


    //指定排序
    //sorted 内部有遍历操作，将所有的对象都进行年龄排序
    list.stream().sorted((e1,e2) -> e1.getAge()-e2.getAge())
            .forEach(emp -> System.out.println(emp.getName()));
    
    ​```
    
    ​			

+ 查找和匹配 终端操作

  + 返回查找的结果，数量

  + 返回符合条件的某个对象

  + ```
    public class Test05 {
        public static void main(String[] args) {
            List<Emp> list = new ArrayList<>();
            Collections.addAll(list,new Emp("张三",20),new Emp("李四",19),new Emp("王五",18)
                    ,new Emp("赵六",21),new Emp("田七",22));

            //查询集合中是否有年龄大于20的员工
            //任意一个大于20，返回true 相当于||
           /* boolean exists = list.stream().anyMatch(emp -> emp.getAge() > 30);
            System.out.println(exists);*/

            //所有人都大于20,相当于&&
          /*  boolean all = list.stream().allMatch(emp -> emp.getAge() > 20);
            System.out.println(all);*/
    ```


            //没有人大于20岁 anyMatch的非操作
           /* boolean isnotAll = list.stream().noneMatch(emp -> emp.getAge() > 30);
            System.out.println(isnotAll);*/


            //查找第一个
            Optional<Emp> op = list.stream().sorted((e1, e2) -> e1.getAge() - e2.getAge())
                    .findFirst();
            //Optional是一个盒子，容器，存放了第一个员工对象
            //避免获取到null对象，出现空指针异常
            System.out.println(op.get().getName());
    
            //查找任意一个对象
            Optional<Emp> op2 = list.stream().findAny();
            System.out.println(op2.get().getName());
    
            //count计数
            System.out.println(list.stream().count());//list.size();
    
            //max/min
            //年龄最大的员工信息
            Optional<Emp> op3 = list.stream().max((e1,e2) -> e1.getAge() - e2.getAge());
            System.out.println(op3.get().getName());
    
            Optional<Emp> op4 = list.stream().min((e1,e2) -> e1.getAge() - e2.getAge());
            System.out.println(op4.get().getName());
        }
    }
    
    ​```

+ 规约和收集

  + 终端操作

  + ```Java
    public class test06 {
        public static void main(String[] args) {
            //规约 reduce
            Integer[] nums = {1,2,3,4,5,6};
            Stream<Integer> stream = Arrays.stream(nums);
            //累计求和,从零开始依次累加
            System.out.println(stream.reduce(0,(x,y) -> x + y));

            //收集操作  collect 终端操作
            List<Emp> list = new ArrayList<>();
            Collections.addAll(list,new Emp("张三",20),new Emp("李四",20),new Emp("王五",18)
                    ,new Emp("赵六",18),new Emp("田七",22));
            List<Emp> listNew = list.stream().filter(emp -> emp.getAge() >20)
                    .collect(Collectors.toList());
            for (Emp emp: listNew) {
                System.out.println(emp.getName());
            }

            //年龄最大的员工信息
            Optional<Emp> op = list.stream().collect(Collectors.maxBy((e1, e2) -> e1.getAge() + e2.getAge()));
            System.out.println(op.get().getName());

            //年龄平均值
            double avg = list.stream().collect(Collectors.averagingDouble(Emp::getAge));
            System.out.println(avg);

            //按年龄分组
            Map<Integer,List<Emp>> map = list.stream().collect(Collectors.groupingBy(Emp::getAge));
            System.out.println(map.get(20).get(0).getName());
        }
    }
    ```

