### 1.盒子模型

+ 浮动一定要给父元素设置高度，不然撑不开父元素

+ width height 宽高

+ padding 内边距

+ margin 外边距（盒子和外部盒子，浏览器边框，的距离)

+ 盒子大小=宽度+2*border +2乘以padding

+ box-sizing:border-box 使我们设置的宽高是盒子正真的宽高

+ padding和margin跟border类似，都有四个方向，可以分别设置也可以统一设置

+ margin 与其他属性不同的是：

  + 如果2个元素都设置了margin，大的起作用，小的不起作用

+ margin的值可以为负数，如果是负数就向指定的方向移动

  + margin-left：-30px;元素向左偏移30px

+ 使用margin设置块元素居中

  + margin:0 zero;

  2.displaay设置元素类型

+ 元素类型：块元素，行内元素，行内块元素

+ 使用通用选择器取消说有html元素的内外边距

+ 设置图片的垂直居中vertical-align:middle

   ```
    <img src="image/img19.png" style="width: 95px ;vertical-align: middle">
   ```

   ​

+ ```
   *{margin:0;
          padding: 0}
   ```
  ```

+ 

+ ### 2、display 可取值

  + block
  + inline
  + inline-block
  + none（不显示）

+ 可以将块元素或行内元素设置为行内块，这样就可以设置宽度高，又处于同一行

+ 缺点：

  + 会因为空格在元素之间产生一道缝隙

+ 
  ```

### 3.浮动

+ float:left right


+ 浮动最开始是用于制作文字坏绕效果的

+ 可以使用浮动令多个元素块处于同一行

+ 浮动元素脱离标准文档流，自动转换为行内块元素

+ 如果两个相邻元素都是浮动的，可以排在同一行

+ 浮动元素上方如果是标准文档流的元素，浮动元素顶部与标准文档流底部对齐（处于同一行）

+ 浮动元素上方如果也是浮动元素，后面的浮动元素与上一个浮动元素底部对齐（处于同一行）

+ 浮动元素因脱离了标准文档流，所有后方的标准文档流会向前移动，占浮动元素原本的位置，会导致浮动元素遮挡标准文档流的元素

  + 所以要清除浮动，清除浮动是清除浮动造成的影响
  + 排在浮动元素后面的标准文档流中的元素，添加clear属性，可清除浮动，不会遮挡。

+ 父级塌陷

  + 父元素中所有的子元素都浮动起来了，没有内容物可以撑起父元素的高度为0，我们称之为父级塌陷
  + 解决方案
    + 手动添加父元素高度
    + 或添加父元素overflow属性
      + auto
      + hidden
      + scorll

  ### 4.定位

+ position

  + relative 相对定位
  + absolute 绝对定位
  + fixed 固定定位
  + static 默认的，不设置定位的

+ 相对定位

  + 相对于元素自身进行定位
  + 不脱离标准文档流
  + 多数情况是用于作为绝对定位的元素参照物

+ 绝对定位

  + 相对于一个设置了定位模式的父元素进行定位，如果没有这样的父元素，则相对浏览器进行定位
  + 脱离标准文档流

+ 固定定位

  + 相对与浏览器进行定位，固定在浏览器一个位置上
  + 脱离标准文档流
  + 常用于：导航，广告等

+ 边偏移

  + top
  + left
  + right
  + bottom
  + 边偏移只对定位元素生效