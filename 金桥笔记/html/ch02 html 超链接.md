## 01 超链接

+ a超链接
  + href 链接地址
  + target 打开方式


+ 页面间链接

  + 从一个页面跳转到另一个页面，可以是站内的也可以是站外的

  + ```
    <a href="http://www.baidu.com">这是一个超链接</a>
    ```

```
<a href="../day01/test01.html">跳转到day01的test01</a>
```

+ 站外资源要写全网址，站内资源以相对路径作链接

+ 锚链接

  + 从页面一个位置跳到页面的指定位置

  + 必须在页面中存在纵向滚动是才起作用

  + 组成：锚点加上链接

    + 锚点：任何一个html元素都可以作为锚点，只需要添加id或者name属性即链接：href=#name或#id

      ```
      <h1 id="top">这是顶部</h1>
      ```

    + 链接：href="#id或者#name"

      ```
      <a id="bottom" href="#top" >跳转到顶部</a>
      ```

  + 页面间链接+锚链接

    + 从一个页面跳转到另一个页面指定位置

    + href=“页面路径#id”

      ```
      <a href="test02.html#bottom">跳转到test02的底部</a>
      ```

+ 功能性链接

  + 具有一些特殊的功能，打开一些小软件

    ```
    <a href="mailto:123@qq.com">拉起邮箱</a>
    ```

+ 链接的打开方式

  + 由target属性控制
  + 可选值有
    + _self   在原窗口打开
    + _blank    在新窗口打开
    + _top    
    + _parent

```
<!--超链接默认在原窗口打开，也就是target默认值为_self-->
    <a href="test01.html" target="_blank">跳转到test01</a>
```

+ _top 和 _parent 在结合内联框架iframe使用

+ ## 02表单

+ 表单标签form

  + 是表单的载体，要提交给服务器，必须要有form
  + action 表单的提交地址
  + method 表单的提交方式
    + get 默认的表单提交方式，把所有表单的元素都显示在地址栏，不安全，速度比post快，数据的传输量有限，受到浏览器的地址限制
    + post 隐藏表单元素的值，比较安全，速度比get慢，数据传输量没有限制

+ 表单元素 表单元素必须放在form里才能交给服务器

  + 由input标签演变的表单元素

  + 文本框 text

    ```
    <input type="text" name="user" value="小明">
    ```

    + type元素类型，值不同，元素不同
    + name元素名，用于提交服务器时，服务器获取元素值
    + value元素值，提交给服务器时，服务器获取到的值
      + 输入框的value是输入框的默认值

  + 密码框 password

    + 与文本框类似，但是文本框的值为明文，密码框的值为密文

  + 单选按钮radio

  + ```
    性别：<input type="radio"value="男" checked name="sex"> 男<input type="radio" value="女" name="sex"> 女
    ```

    + name相同的单选框为一组
    + value表示该单选按钮的值，value只影响提交给服务器时的值，不影响页面内容的显示
    + 添加了checked属性的单选按钮默认被选中

  + 复选框(多选框) checkbox

  + ```
    <input type="checkbox" name="hobby" value="打篮球"> 打篮球
                  <input type="checkbox" name="hobby" value="踢足球"> 踢足球
                  <input type="checkbox" name="hobby" value="游泳" checked> 游泳
    ```

    + 跟单选框类似，只是功能不同，name,value,checked的用法都一样

  + 隐藏域 hidden

    + 有些东西用户无需看到，但是服务器需要使用，则可以使用隐藏域，随着表单提交给服务器

    + ```
      <input type="hidden" name="id" value="20220705">
      ```

  + 按钮

    + 提交  sumbit

    + 重置，reset

    + 普通按钮 button

    + 图片按钮，image

    + ```
      <!--        submit，提交按钮，一定要和form搭配使用-->
              <input type="submit" value="注册">
      <!--        使表单元素恢复到默认值-->
              <input type="reset" value="重置按钮">
      <!--        普通按钮本身没有任何功能-->
              <input type="button" value="普通按钮">
      <!--        一般放在表单外面，表示与表单无关，如果放在了form里面，表示提交作用-->
              <button>普通按钮</button>
      <!--        图片按钮,按钮样式为图片的提交按钮-->
              <input type="image" src="../image/img1.PNG" style="height: 30px; width: 70px">
      ```

    + 按钮中的value可以改变按钮上的文字

    + 其他

    + ```
      日期： <input type="date"><br>
              数字：<input type="number"><br>
              颜色：<input type="color"><br>
              文件：<input type="file"><br>
      ```

  + 非input标签元素

  + 下拉列表 select-option

  + ```
    <!--        select 下拉列表，option 下拉列表选项，name写在select标签上，value写在option标签上,默认被选中项selectde-->地址：<select name="address">
                <option value="济南">济南</option>
                <option value="济南" selected>济南</option>
                <option value="济南">济南</option>
                 </select><br>
    ```

  + 文本域 textarea

  + ```
    <!--        文本域，textarea,cols,列数，rows,行数-->
            <textarea name="sigm" cols="40" rows="10">今天天气好</textarea><br>
    ```

    + 文本域的value是两个标签中的内容，也是文本域的默认值

+ 表单的高级用法

  + 表单元素都可以添加的属性：readonly 和 disabled

  + readonly 只读

  + disabled 禁用

  + 输入框可以添加 placeholder——提示文字

  + ```
    有些东西，用户有些情况下不能使用，则添加disabled 禁用该元素，一般放在按钮上-->
            <input type="submit" disabled>
    <!--       有些元素只能看，不能改，添加readonly 使该元素只读-->
            <input type="text" value="123" readonly>
    <!--  输入框提示 placeholder,输入框无值时，显示placeholder的值，有值时不显示-->
            <input type="text" placeholder="请输入账号">
    ```

### 03 特殊符号

+ 空格 &nbsp
+ 小于号&lt
+ 大于号 &gt
+ 引号 &quot
+ 版权符号 &copy
+ 每一个后面都要加；