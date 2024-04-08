## 输入输出流

### 01-流的概念

+ 数据在计算机中的存储
  + 内存：软件运行过程当中临时存储的数据
  + 外存：存储在电脑硬盘中的数据。
+ 数据的传输
  + 内存和外存之间的数据是不断转换。
  + java程序中临时存储的数据，也可以保存到外存中，保存到一共文件中。
+ 输入输出
  + 输入动作：将外存中的文件中的数据，读取到java虚拟机中
  + 输出动作：java中的临时变量，写入到硬盘中某个文件中。
+ 流：
  + 可以将内存和外存之间的数据传输看成一共通道
  + 数据在这个通道中进行传输，就形成了数据流。
+ java中的输入输出流
  + input
  + output
  + 简称为I/O流
+ 输入输出流的分类
  + 字节流：以字节的形式进行数据的传输，一个字节占8位
  + 字符流：以字符的形式进行数据传输，一个字符占两个字节
+ IO操作中的类
  + File类，对应硬盘中的文件或者目录
  + InputStream字节的输入流
  + OutputStream类，字节输入流
  + Reader类，字符的输入流
  + Writer类，字符的输出流

###02-File文件类

+ 一共File对象对应硬盘上的一共文件或者文件夹

```
public class TestFile {
    public static void main(String[] args) {
        //创建文件对象，对应硬盘上的一共文件或者目录
        //\\代表根目录，当前文件所在根目录
        //d盘下的test文件夹
        File file = new File("\\test");
        //判断硬盘上是否存在改文件夹
        if (!file.exists()){
            //我们负责创建这个文件夹
            file.mkdir();
        }

        //在E盘下创建文件夹
        /*File file1 = new File("e:\\test");
        file1.mkdir();*/
/*

相对路径
        File file2 = new File("test");
        file2.mkdir();
*/

        //返回当前目录下所有的子文件,同时包含路径信息
//        File[] lists = file.listFiles();
        File fileTxt = new File("d:\\","test.txt");
        if (!fileTxt.exists()){
            //创建文件
            try {
                fileTxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

```

+ ​

  + mkdir（）：创建文件夹

  + createNewFile（）创建文件

  + delete（）：删除文件或者目录

  + exists（）：判断文件是否存在

  + listFile（）；获取某个目录下所有的子文件或者子目录，

  + ```
    public class Tes {
        public static void main(String[] args) {
            File file = new File("d:\\app");
            File[] files = file.listFiles();

            for (int i = 0;i < files.length; i++){
                System.out.println(files[i].getName());
            }
        }
    }
    ```

###03-InputStream 字节输入流

+ 用于将硬盘的数据读取到Java中。
+ ​

```
public class Test {
    public static void main(String[] args) {
        //建立数据传输的通道
        try {
            InputStream in = new FileInputStream("d:\\Welcome.html");
            //创建字节数组接收文件中读取到的数据
            byte[] bytes = new byte[1024];
            //读取文件内容,存储到字节数组中,并返回读取到的字节数
            try {
          /*      int length = in.read(bytes);
                System.out.println(new String(bytes));
                //将字节数组中的内容转换为字符串输出
                while (length != -1){//-1代表没有读到任何内容
                    length = in.read(bytes);
                    System.out.println(new String(bytes));
                }*/
             

                while (in.read(bytes) != -1){
                    System.out.println(new String(bytes));
                }
                

                in.close();

            }catch (IOException e){
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

### 04-字节输出流outputStream

+ 用于将程序中的变量写入到文件中。

+ ```
  public class TestOutputStream {
      public static void main(String[] args) {
          //创建数据的传输通道
          try {
              OutputStream out = new FileOutputStream("d:\\test.txt");
              //用于存储控制台输入内容
              byte[] bytes = new byte[1024];

              try {
                  //将控制台输入的内容保存到了字节数组中，返回读取到的字节长度
                  int count = System.in.read(bytes);
                  //将字节数组中的内容保存到文件中
                  //将数组中有值的元素写到文件中，后面的空位置不会写入到文件中
                  out.write(bytes,0,count);

                  //刷新输出流
                  out.flush();
                  out.close();

              } catch (IOException e) {
                  e.printStackTrace();
              }


          } catch (FileNotFoundException e) {
              e.printStackTrace();
          }

      }
  }
  ```

### 05-字符输入流Reader

+ 用于将文件中的内容读到程序中

```

public class TestReader {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("d:\\test.txt");
            char[] chars = new char[1024];

            while(true){
                try {
                    if (((reader.read(chars)) != -1)) {
                        System.out.println(new String(chars));
                        chars = new char[1024];
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

```



### 06-字符输入出流Writer

+ 将程序中的数据写入到文件中

+ ```
  public class TestWriter {
      public static void main(String[] args) {
          try {
              Writer writer = new FileWriter("d:\\test.txt");
              String str = "这是要写入到文件中的内容";
              //可以直接将字符串写入到文件中
              //方法内部会将这个字符串转换为char数组
              writer.write(str);

              writer.flush();
              writer.close();

          } catch (IOException e) {
              e.printStackTrace();
          }

      }
  }

  ```

### 07-文件的复制

```
public class TestCopy {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("d:\\DBUtil.java");
            Writer writer = new FileWriter("d:\\test.txt");
            char[] chars = new char[1024];
            while ((reader.read(chars)) != -1){
                writer.write(chars);
            }
            reader.close();
            writer.flush();
            writer.close();
            
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
```

### 08-缓冲区

+ 缓冲区相当于在程序和文件之间建立了一共临时存储数据的空间
+ 它是在内存中的
+ 在进行读写操作时，不再是直接对应文件的读写，而是面向缓冲区进行读写操作
+ 降低了文件的读写次数，提高读写效率

```
public class TestBuffer {
    public static void main(String[] args) {
        //创建输入流、用于将键盘输入的内容读到程序中
        InputStreamReader in = new InputStreamReader(System.in);
        //创建输入流的缓冲区
        BufferedReader br = new BufferedReader(in);

        //创建输出流对象，勇于写入到文件中
        try {
            Writer writer = new FileWriter("d:\\test.txt");
            //创建缓存区
            BufferedWriter bw = new BufferedWriter(writer);

            String str = "";
            //br.readline用于读取数据到缓冲区，并返回读取到的字符串
           str = br.readLine();
           while (str.length() > 0){
               //将字符串内容写入到缓冲区
               bw.write(str);
               bw.newLine();
               //在控制台继续输入内容
               str = br.readLine();
           }
           br.close();
           bw.flush();
           bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
```



































