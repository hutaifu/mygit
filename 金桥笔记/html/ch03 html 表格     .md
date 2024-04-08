### 表格

#### 1.表格的基本结构

+ table-tr-td

+ ```
  <table width="200px" height="300px" border="1">
          <tr>
              <td>1</td>
              <td>2</td>
          </tr>
          <tr>
              <td>3</td>
              <td>4</td>
          </tr>
          <tr>
              <td>5</td>
              <td>6</td>
          </tr>
  ```

+ ```
  table表示这是一个表格，html中的表格只能先写行，再写行中的单元格
  tr,这是表格中的行，td表示行中的单元格
  ```

+ table 表格

+ tr 行

  + html中的表格只能先写行，再写行中的单元格

+ td 单元格

  + 数据放在单元格里

  ### 2.表格的常用属性

  表格标签table的属性

+ border 边框

  + 表格默认不显示边框，添加border=“1"之后显示边框，数字越大，边框越粗
  + border=”0“不显示边框

+ width宽height 高

  + 给表格设置宽高，单元格平均分配这些宽高

+ align设置表格在父元素中的对齐方式

  + left
  + right
  + center

  单元格标签td的属性

+ width宽height高

  + 给单元格设置宽高时，会影响单元格所在的行，或列

+ align单元格中文字对齐方式

+ ```
  <table border="1" width="500" height="200">
      <tr>
          <td>序号</td>
          <td width="100" height="50" align="center">姓名</td>
          <td>年龄</td>
      </tr>
      <tr>
          <td>1</td>
          <td>喜羊羊</td>
          <td>8</td>
      </tr>
      <tr>
          <td>2</td>
          <td>懒羊羊</td>
          <td>9</td>
      </tr>
  </table>
  ```

  #### 3,合并单元格

+ 合并列 colspan

+ 合并行 rowspan

+ 合并单元格的步骤

  + 先观察表格原本有几行几列
  + 先找到要合并的单元格（最左，最上方的那个单元格）
  + 添加colspan或者rowspan属性
  + 删除多余的单元格

  #### 4.使用表格布局

+ 单元格中可以嵌套其他的标签，比如图片，标题，段落等，当然也可以嵌套表单元素

+ 对于表单的布局，使用非字型布局更加美观

  + 左边单元格右对齐，右边单元格左对齐

+ ```html
  <form action="test01.html" method="post">
          <table align="center">
              <tr>
                  <td align="right">昵称：</td>
                  <td><input type="text" name="user" value="小明"><br></td>
              </tr>
              <tr>
                  <td align="right" >密码：</td>
                  <td><input type="password" name="pwd" value="123"></td>
              </tr>
              <tr>
                  <td align="right" >再次输入密码：</td>
                  <td><input type="password" name="pwd2"><br></td>
              </tr>
              <tr>
                  <td align="right">性别：</td>
                  <td><input type="radio"value="男" checked name="sex"> 男<input type="radio" value="女" name="sex"> 女 <br></td>
              </tr>
              <tr>
                  <td align="right"> 爱好：</td>
                  <td><input type="checkbox" name="hobby" value="打篮球"> 打篮球
                      <input type="checkbox" name="hobby" value="踢足球"> 踢足球
                      <input type="checkbox" name="hobby" value="游泳" checked> 游泳</td>
  <tr><td colspan="2" align="center"><input type="submit" value="注册"></td></tr>
          </table>
      </form>
  ```

+ ​

  ##### 				

  #### 5.表格高级标签

+ thead 表格头部

  + ```
    表头中使用th代替td,单元格中文字加粗且居中
    ```

+  tbody 表格身体

+ tfoot 表格尾部

+ 用于划分表格的区域，表头中的行一定是在表格中的上方，表尾中的行一定是在表格中的下方

+ 表头表尾的行高是固定的，（使用css可以修改），如果表格设置了高度，表体中的行号会随着整体高度变化而变化，但是表头和表尾不会。

+ caption 表格标题，位于表格上方且居中，无边框

+ ```html
  <body>
  <table border="1" width="200px" heght="150px">
  <!--    caption,表格标题，直接放在table标签中，呈现在页面上-->
      <caption>学生信息</caption>
  <!--    thead，本身没有样式，起到划分表格区域的作用,thead中的行会显示在表格的上方，不受书写
  顺序的影响-->
      <thead style="background:darkcyan">
      <tr>
  <!--        表头中使用th代替td,单元格中文字加粗且居中-->
          <th>组号</th>
          <th>姓名</th>
          <th>年龄</th>
      </tr></thead>
      <tbody style="background: gray">
      <tr>
          <td >1组</td>
          <td>喜羊羊</td>
          <td>8</td>
      </tr>
      <tr>
                  <td>2</td>
          <td>懒羊羊</td>
          <td>9</td>
      </tr></tbody>
      <tfoot style="background: red">
      <tr>
          <td colspan="2">平均年龄</td>
          <td>8.5</td>
      </tr>
      </tfoot>
  </table>
  ```

+ ​

  ###### 

  ##### 

  ​

  ​