01.-java语言的概念

+ BS架构的软件，基于浏览器访问的信息化系统。

+ Java用来处理，前台浏览器传递来的数据，进行逻辑上的校验，判断，保存操作。

+ java程序的本质就是用来处理用户的数据的。

  02.Java程序的开发

+ Java程序的开发有自己所依赖的开发环境，开发平台。

+ JDK，提供了Java程序开发及运行环境

+ java develop toolkit ,java开发工具包，

+ jre,jdk中包含了jre

  + java runtime enviroment java运行环境

+ jvm，jre中包含了jvm

  + java virtual machine java 虚拟机
  + Java程序真正所依赖的运行环境

+ java的特点

  + 跨平台，在任意的操作系统中安装了jdk，就可以进行Java程序的开发以及运行
  + jdk的环境变量配置
  + 创建了JAVA_HOME环境变量，取值为Java根目录，往下能看到bin
  + 修改系统中的path变量
    + path是操作系统启动时会来加载的一个变量
    + 系统会读取到path中Java坏境的设置，然后帮我们把Java虚拟机准备好，
    + %JAVA_HOME%\bin,%%内是引用了之前创建好的变量
    + 之后如果改变jdk的安装位置，或者重新升级版本，那么只需修改java-home变量即可
  + ​

+ JAVA程序的基本语法

+ ```
  public class day01 {
      public static void main(String[] args) {
          System.out.println("sfjl");
      }
  }

  ```

+ public class 类名{

+ ​    public static main(String[] args) {//main方法，程序的入口

+ //jvm要执行的代码

+ System.out.println("");向控制输出内容，

+ }

+ }

+ 执行步骤

  + 编译程序，使用java命令让虚拟机把java文件编译成后缀是class的文件，二进制才是虚拟机最终可以执行的文件
  + 运行程序，使用Java命令运行二进制文件

+ 如果Java文件发生变化，那么需要重新编译生成新的二进制文件

+ 在idea中的开发步骤

  + 创建Java项，选择要依赖的jdk
  + 在src下创建package包
  + 在package包下创建Java类
  + 右键单击run

+ Java的类名和文件名完全一致

+ print和println的区别，println在内容输出后不会换行

+ \n和\t

  + \n代表一个换行，可以出现在文本的任意位置
  + \t代表一个制表符，用于表格展示

+ 注释

  + //单行注释
  + /* */多行注释

+ 04Java的分类

+ J2ME

  + 用于开发移动设备，比如车载导航，机顶盒

+ J2SE

  + 用于开发一些PC端的应用

+ J2EE

  + 用于开发BS架构的软件
  + ​