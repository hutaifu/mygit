### 01，css简介

+ css Cascading Style Sheet(层叠样式表)

+ 可以设置html元素的样式，使页面更加美观

  ### 02，css简单使用

+ 在head标签中添加style标签，在style标签中写css代码

+ 语法

+ ```
  选择器{
    属性：值；
  }
  ```

  + 如果有多个样式，用；隔开
  + 给选择器选中的html元素添加属性

+ 基本选择器

  + id选择器

    + 给元素添加id属性，通过#id选中指定元素

    + ```
      <ul id="fruit" id="fruit">
              <li>苹果</li>
              <li>哈密瓜</li>
              <li>榴莲</li>
          </ul>
      ```

    + ```
      #fruit {
          color: red;
      }
      ```

  + 类选择器

    + 给元素添加class属性，通过class选中指定元素

    + ```
      <ul  class="changeStyle">
          <li>苹果</li>
          <li>哈密瓜</li>
          <li>榴莲</li>
      </ul>
      ```

    + ```
      .changeStyle{
          color: yellow;
      }
      ```

  + 标签选择器

    + 通过标签名选择指定元素

    + ```
      ul {
        color: yellow;
      }
      ```

    + 一般情况下，不会单独使用标签选择器，因为范围太大，容易不小心误添

  + id选择器和class选择器对比

    + id不能重复，id选择器只选择一个元素
    + class可以重叠，class选择器可以选择多个元素

  3，选择器优先级

+ 对于同一个html样式，使用不同的选择器来设置，优先级顺序为

  + id>class>标签

    4.css样式表分类

+ 内部样式表

  + 在head中添加style标签，在style标签中写css代码

+ 内联样式表

  + 直接在html标签中用style属性添加css样式

  + ```
    <p style="color:red"></p>
    ```

+ 外部样式表

  + 使用css文件书写css代码。从html页面中引入css文件

  + 同一个css文件可以被多个html页面引用，减少代码冗杂

  + ```
    <link rel="stylesheet" href="../css/css1.css">
    ```

+ 样式表优先级

  + 就近原则
    + 谁离标签近就听谁的
    + 行内样式表永远里标签最近，优先级永远最高。其他样式表按书写顺序优先级

+ 优点

  + 行内样式表：书写简单，但是只适用于给单一元素添加少量样式；css代码和html代码耦合在一起，影响页面加载顺序。
  + 内部样式表：比行内样式表更适用于给多个元素添加多个样式，但是css代码仍然耦合在一起，而且不适用于多个页面有相同样式的情况
  + 外部样式表（也是css的优点）
    + 将结构和样式分离
    + 可以使许多页面同时更新
    + 可以制作体积更小，下载更快的网页
    + css优点：控制网页的布局（没有css时都是使用表格布局，不灵活，

  5.css美化样式

+ 设置文字样式

  + 文字样式可以被继承

  + color文字颜色

  + font-size字体大小

  + font-family 字体

    + 可以设置多个字体，用逗号隔开，第一个不能 显示时，显示第二个

  + font-weight 字体粗细

    + 可以使用数字也可以使用英文单词400正常。normal，bold.lighter等
    + font-style 设置字体的倾斜或正常
    + 倾斜oblique或者italic
    + 正常 normal

  + 综合写法：font:倾斜 粗细 大小 字体

    + font：normal bold 20px 楷体

  + text-decrition 装饰线

  + text-align 文字对齐方式

    + 可选值 right,left ,center

  + text-indent 缩进

    + 用em作单位

  + line-height 行高

    + 有时可以用于设置文字居中

    + ```
      <style>
              div{width: 100px;
              height: 100px;
                  border:solid;
              line-height:100px;}
          </style>
      ```

    + ```
      div >
              这是一个div
          </div>
      ```

+ 宽高，width和height

  + 行内元素不能设置宽高

+ 背景

  + background 背景颜色

  + background-image背景图片

    + 使用url("")设置背景图片路径

  + background-size 背景图片大小

    + 可以使用单词
      + contain 保持图片比例，使图片长边刚好匹配上该元素，短边若不足，该元素则平铺
      + cover 保持图片比例，使图片短边匹配上该元素，长边多余部分不显示

  + background-repeat 背景图片平铺效果

    + no-repeat 不平铺
    + background-position  背景图片位置

  + ```

    ```

  + background 

    + 可以设置渐变

    + ```
       /*线性渐变，linear-gradient（方向，颜色1，颜色2、、、）*/
                  background:linear-gradient(to right,pink,red,blue);}
              /*  偏移  */
      ```

    + 综合写法

      + background :颜色 url(图片) 横轴偏移量，纵轴偏移量， 是否重复
      + 也可以用background 设置颜色

  + 给整个页面设置背景

    + 在body标签上添加HTML属性加bgcolor 
    + 使用标签选择器body选中后添加css样式

+ 边框

  + border style 边框样式
    + 最常用的就是solid(实线) 和none（无边框）
  + border-color
  + border-width 边框宽度 ，可以用英文单词，也能用数字
  + border-radius 边框圆角
  + border 综合写法：宽度 样式 颜色
    + border 的综合写法中可以省掉任意一个样式，比如宽度，颜色
  + 边框有四个，可以分别给四个方向上的边框设置不同的样式
    + 以border-color为例
    + 左边边框border-left-color
      + 在中间加上方向即可
    + 所有边框都要设置颜色。但是颜色各不相同，可以使用border-方向-color分别设置，也可以border-color统一设置
    + 如果颜色不足四个，则没有匹配的边从对面取颜色
    + 上右下左
  + 边框的所有样式都是类似的
    + border-width
    + border-style
    + border-radius

+ 列表

  + list-style:none;   去除无序列表的小圆点

  6.css高级选择器

+ 通用选择器 *

  + 所有的html元素都会被选中

+ 并集选择器，

  + 表示和的意思

+ 交集选择器 不写任何符号

  + 表示既属于这个选择器又属于那个选择器的范围
  + 元素必须既是li标签又是类标签

+ 后代选择器 空格

+ 子元素选择器  >

  + 后代选择器选择 儿子孙子等等
  + 子元素选择器只选择儿子

+ 属性选择器

  + [属性] 有/无 此属性
  + [属性=值] 有这个属性 并且属性为指定值
  + 一般会与标签选择器搭配使用
  + [属性*=值]存在指定属性，并且属性值包含指定值
  + [属性^=值] 存在指定属性，并且以指定值开头
  + [属性$=值] 存在指定属性，并且以指定值结尾

+ 伪类

  + 伪类是一些选择器的特殊状态，多用于超链接
  + :hover{}
  + 可以直接使用a{} 设置链接未点击时的颜色

+ 伪元素

  + 伪元素就是假的html元素
  + 会在ul标签的内部上方添加一个伪元素，内容
  + ::after 在被选中的元素尾部插入伪元素

+ ​



