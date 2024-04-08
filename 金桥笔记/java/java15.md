## 字符串的创建方式

+ String str = "值"；
+ String str = new String("值")；



## 1.字符串常用方法

+ A.equals(B) 判断A和B是否相等
+ A.concat(B)连接字符串A和B
  + 连接符+ 也能连接2个字符串
  + 返回值为连接后的字符传
+ A.length()获取字符串的长度
  + 区分数组的length和字符串的length（）
+ A.toUpperCase()将字符串中英文全部变为大写
+ A.toLowerCase()变小写
+ AindexOf(B)判断B在A中首次出现的位置，如果不存在，则返回-1，
  + 下标从0开始

```
public class Test02 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("请输入邮箱");
        String email = input.next();
        int index = email.indexOf("@");
        int index2 = email.indexOf(".");
        if (index >= 0 && index < index2){
            System.out.println("邮箱格式正确,进入下一步");
        }else {
            System.out.println("邮箱格式不正确");
        }
    }
}

```

+ A.indexOf（B，formidex）第二个参数可以控制查找的起始位置

+ A.lastindexOf(B)从右向左查找首次出现位置，位置从左往右数

+ A.subString(begainindex,endindex)截取开始位置到结束位置之间的字符串，

  + 如果不写第二个数，则截取到最后

  ```
    String str6 = "今天是周四";
          str6 = str6.substring(0,2);
  //        包含头不包含尾
          System.out.println(str6);
  ```

A.split(B),按B分割,B会消失，返回数组

```
public class Test03 {
    public static void main(String[] args) {
        String today = "2022/7/21";
//        2022-7-21
        String[] strings = today.split("/");
        System.out.println(strings[0]+"-"+strings[1]+"-"+strings[2]);
    }
}

```

String = new String(),栈内存指向堆内存，堆内存指向常量池。

## StringBuffer类

+ 如果要频繁的拼接或者修改String类型的变量， 会在常量池中创建很多无用的常量，浪费内存空间
+ 如果要拼接或者修改使用StringBuffer类
+ StringBuffer stb = new StringBuffer("");
+ A.append(B),将B拼接在A后面，返回值为StringBuffer；、
+ A.insert(B),插入

## StringBuffer和String的转换

+ 调用StringBuffer的toString方法

```
public class Test05 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("你好");
        String str = sb.toString();
        System.out.println(str.concat("吃了吗"));
        sb = new StringBuffer(str);
        sb.insert(2,"早上好");
        System.out.println(sb);
    }
}

```

+ String 类型转换为StringBuffer
+ 将String对象放在StringBuffer的构造方法中
+ StringBuffer相对于String的优点，String不可变，每次对String 的值进行改变时，每次都等同于生成新的String对象，然后将变量指向新的string对象
+ StringBuufer则不同，每次对其做拼接都是在其本身进行操作，而不生成新的对象。；
+ String的方法trim去除字符串两边的空格