Java 8中的Stream API提供了各种方法，可以很方便地对集合进行处理和操作。以下是Stream的各种方法介绍：

遍历操作

- 将流中所有的数据遍历输出到控制台，终端操作。

- foreach（）

- public static void main(String[] args) {

         Stream<String> stream1= Stream.of("a","b","c","d");
         //01-遍历输出
         stream1.forEach(s -> System.out.println(s));
         //        stream1.forEach(System.out::println);
         
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


1. 排序

   - sort（）中间操作

   - 默认从小到大

   - ```
     public class Test04 {
         public static void main(String[] args) {
             Stream<String> stream = Stream.of("c","d","a","b");
             //升序排序
             stream.sorted().forEach(System.out::println);

     List<Emp> list = new ArrayList<>();
     Collections.addAll(list,new Emp("张三",20),new Emp("李四",19),new Emp("王五",18)
             ,new Emp("赵六",21),new Emp("田七",22));
     ```

     指定排序

     ```
     //指定排序
     //sorted 内部有遍历操作，将所有的对象都进行年龄排序
     list.stream().sorted((e1,e2) -> e1.getAge()-e2.getAge())
             .forEach(emp -> System.out.println(emp.getName()));

     ​```
     ```


1. 查找和匹配 终端操作

   - 返回查找的结果，数量

   - 返回符合条件的某个对象

   - ```
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

     ```
          //没有人大于20岁 anyMatch的非操作
            /* boolean isnotAll = list.stream().noneMatch(emp -> emp.getAge() > 30);
             System.out.println(isnotAll);*/
     ```

     ```
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
     ```

     规约和收集

     - 终端操作

     - ```
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

       ​

2. filter()方法

filter方法可以对Stream中的元素进行过滤，只保留符合条件的元素。该方法接收一个Predicate函数式接口作为参数，用于判断元素是否符合条件。

例如：

```
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
Stream<Integer> stream = list.stream();
stream.filter(n -> n % 2 == 0).forEach(System.out::println);

```

输出结果：

```
2
4

```

1. map()方法

map方法可以对Stream中的元素进行映射，将一个元素转换成另一个元素。该方法接收一个Function函数式接口作为参数，用于定义映射规则。

例如：

```
List<String> list = Arrays.asList("apple", "banana", "orange");
Stream<String> stream = list.stream();
stream.map(s -> s.toUpperCase()).forEach(System.out::println);

```

输出结果：

```
APPLE
BANANA
ORANGE

```

1. flatMap()方法

flatMap方法可以将Stream中的元素展开成一个新的Stream，常用于将多个集合合并成一个集合。该方法接收一个Function函数式接口作为参数，用于定义如何将一个元素展开成一个新的Stream。

例如：

```
List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
Stream<List<Integer>> stream = lists.stream();
stream.flatMap(list -> list.stream()).forEach(System.out::println);

```

输出结果：

```
1
2
3
4
5
6

```

1. distinct()方法

distinct方法可以对Stream中的元素进行去重，只保留不重复的元素。

例如：

```
List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6);
Stream<Integer> stream = list.stream();
stream.distinct().forEach(System.out::println);
```





Arrays.asList是Java中Arrays类提供的一个静态方法，用于将一个数组转换成一个List集合。

例如：

```
String[] array = {"apple", "banana", "orange"};
List<String> list = Arrays.asList(array);

```

上述代码将一个String类型的数组转换成了一个List集合。

Arrays.asList方法的作用是将数组转换成List集合，以便我们可以使用List的各种方法来操作数组中的元素。转换后的List集合是一个固定长度的列表，不支持添加或删除元素，只能修改元素。

需要注意的是，Arrays.asList方法返回的List集合是一个固定长度的列表，不支持添加或删除元素。如果我们需要对List集合进行添加或删除操作，可以使用ArrayList等可变长度的List实现类来进行操作。同时，对转换后的List集合进行修改操作时，也会同时修改原数组中的元素，因为它们共享同一份数据



Predicate是Java 8中的一个函数式接口，用于表示一个谓词（即一个返回值为布尔类型的函数）。它只有一个抽象方法test(Object obj)，用于判断一个对象是否符合某个条件。例如：

```
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(2)); // 输出 true
System.out.println(isEven.test(3)); // 输出 false

```

Predicate函数式接口可以用于对集合中的元素进行过滤、筛选等操作，例如Stream中的filter方法就接收一个Predicate函数式接口作为参数，用于判断元素是否符合条件。

方法引用是一种特殊的lambda表达式，用于简化lambda表达式。方法引用可以直接引用已有方法或构造方法，它的语法形式为 类名::方法名 或 对象名::方法名。例如：

```
list.forEach(System.out::println);

```

上述代码使用了方法引用的方式对集合中的元素进行输出。System.out::println 等价于 x -> System.out.println(x)，它的含义是将System.out.println方法作为一个函数来使用，对每个元素进行输出。

方法引用可以简化代码，使代码更加简洁、易读。在Stream API中，方法引用经常用于对集合元素进行操作，例如对字符串进行转换、对数字进行计算等。



### 数据库查询null或者为空字符串数据

```
QueryWrapper<Entity> queryWrapper = new QueryWrapper<>();
queryWrapper.isNull("fieldName").or().eq("fieldName", "");
List<Entity> list = mybatisPlusMapper.selectList(queryWrapper);
```



### 获取sessionId

在Vue中获取sessionId的方法与普通的JavaScript获取sessionId的方法相同。可以使用document.cookie来获取sessionId。具体代码如下：

```
javascript复制代码var sessionId = document.cookie.match(/JSESSIONID=[^;]+/);
if (sessionId) {
  sessionId = sessionId[0].substring(11);
}

```

如果需要在Vue组件中获取sessionId，可以在created钩子函数中获取sessionId并将其存储在Vue实例中，以便在组件中使用。具体代码如下：

```
javascript复制代码export default {
  created() {
    var sessionId = document.cookie.match(/JSESSIONID=[^;]+/);
    if (sessionId) {
      sessionId = sessionId[0].substring(11);
      this.$store.commit('setSessionId', sessionId);
    }
  }
}

```

在上面的代码中，我们使用Vuex来存储sessionId。在组件中，我们可以使用this.$store.state.sessionId来获取sessionId。

在Java Spring MVC中获取sessionId也很简单，可以通过HttpServletRequest对象来获取。具体步骤如下：

1. 在Controller中注入HttpServletRequest对象：

```
java复制代码@Controller
public class MyController {
    @Autowired
    private HttpServletRequest request;
    // ...
}

```

1. 在需要获取sessionId的方法中，使用request.getSession()方法获取HttpSession对象，然后通过getId()方法获取sessionId：

```
java复制代码@RequestMapping("/myUrl")
public String myMethod() {
    HttpSession session = request.getSession();
    String sessionId = session.getId();
    // ...
}

```

这样就可以获取到sessionId了。需要注意的是，如果sessionId是通过HttpOnly标记设置的，那么无法通过JavaScript获取，只能在后端获取。

sessionId是指会话标识符，用于标识用户与Web应用程序之间的会话。在Web应用程序中，当用户与服务器建立连接时，服务器会为该用户创建一个唯一的sessionId，并将其存储在cookie或URL参数中。在用户与服务器之间的每个请求中，sessionId都会被发送回服务器，以便服务器可以识别用户并维护会话状态。

sessionId通常是由服务器生成的随机字符串，具有足够的复杂性和随机性，以确保不会被猜测或伪造。sessionId的长度和格式可能因服务器和应用程序而异，但通常是一个32位的十六进制字符串。

sessionId在Web应用程序中扮演着重要的角色，它可以用于实现用户身份验证、会话跟踪、购物车等功能。因此，保护sessionId的安全性非常重要，应该采取适当的安全措施，如使用HttpOnly标记、SSL加密等。

### Araays

Arrays.asList()方法返回的List是一个固定大小的列表，不能添加或删除元素。

### 对象改map

是的，你可以使用Java 8中的Stream API来实现这个功能。假设你有一个QueryWrapper查询出来的对象集合，每个对象都有两个字段，你想要从每个对象中提取这两个字段并将它们组成一个Map。你可以使用Stream的collect方法来实现这个功能。下面是一个示例代码：

```
java复制代码List<MyObject> objects = ...; // 假设这是你的对象集合
Map<String, String> map = objects.stream()
                                  .collect(Collectors.toMap(MyObject::getField1, MyObject::getField2));
```
###docx转pdf,已测试，能运行

```java
@PostMapping(value = "/Pdf")
    public static void convertDocxToPdf(@RequestBody Map<String,Object> map) {
        try {
            String docxFilePath = (String)map.get("docxFilePath");
            String pdfFilePath = (String)map.get("pdfFilePath");
            // 读取Word文档
            XWPFDocument document = new XWPFDocument(new FileInputStream(docxFilePath));
         *//*   HWPFDocument document = new HWPFDocument(new FileInputStream(docxFilePath));*//*
            // 创建PDF文档
            com.itextpdf.text.Document pdfDocument = new com.itextpdf.text.Document();
            PdfWriter.getInstance(pdfDocument, new FileOutputStream(pdfFilePath));
            pdfDocument.open();
            // 将Word文档内容写入PDF文档
            for (IBodyElement element : document.getBodyElements()) {
                if (element instanceof XWPFParagraph) {
                    XWPFParagraph paragraph = (XWPFParagraph) element;
                    Paragraph pdfParagraph = new Paragraph();
                    for (XWPFRun run : paragraph.getRuns()) {
                        if (run.getEmbeddedPictures().size() > 0) {
                            for (XWPFPicture picture : run.getEmbeddedPictures()) {
                                byte[] pictureData = picture.getPictureData().getData();
                                Image image = Image.getInstance(pictureData);
                                pdfParagraph.add(new com.itextpdf.text.Chunk(image, 0, 0, true));
                            }
                        } else {
                            pdfParagraph.add(new com.itextpdf.text.Paragraph(run.getText(0)));
                        }
                    }
                    pdfDocument.add(pdfParagraph);
                } else if (element instanceof XWPFTable) {
                    XWPFTable table = (XWPFTable) element;
                    PdfPTable pdfTable = new PdfPTable(table.getRows().size());
                    for (XWPFTableRow row : table.getRows()) {
                        for (XWPFTableCell cell : row.getTableCells()) {
                            pdfTable.addCell(cell.getText());
                        }
                    }
                    pdfDocument.add(pdfTable);
                }
            }
            // 关闭文档
            pdfDocument.close();
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

###doc的转换，未测试

```java
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToPdfConverter;
import org.apache.poi.hwpf.usermodel.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public static void convertDocToPdf(String docFilePath, String pdfFilePath) {
    try {
        // 读取Word文档
        HWPFDocument document = new HWPFDocument(new FileInputStream(docFilePath));
        
        // 创建PDF文档
        com.itextpdf.text.Document pdfDocument = new com.itextpdf.text.Document();
        PdfWriter.getInstance(pdfDocument, new FileOutputStream(pdfFilePath));
        pdfDocument.open();
        
        // 将Word文档内容写入PDF文档
        Range range = document.getRange();
        WordToPdfConverter converter = new WordToPdfConverter(pdfDocument);
        converter.processDocument(range);
        
        // 处理图片
        for (Picture picture : document.getPicturesTable().getAllPictures()) {
            byte[] pictureData = picture.getContent();
            Image image = Image.getInstance(pictureData);
            pdfDocument.add(image);
        }
        
        // 处理表格
        for (Table table : document.getRange().getTables()) {
            PdfPTable pdfTable = new PdfPTable(table.numColumns());
            for (int rowIndex = 0; rowIndex < table.numRows(); rowIndex++) {
                TableRow row = table.getRow(rowIndex);
                for (int colIndex = 0; colIndex < row.numCells(); colIndex++) {
                    TableCell cell = row.getCell(colIndex);
                    pdfTable.addCell(cell.text());
                }
            }
            pdfDocument.add(pdfTable);
        }
        
        // 关闭文档
        pdfDocument.close();
        document.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

