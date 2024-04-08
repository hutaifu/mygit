## 初始JQuery

### 一，见识JQuery

+ jquery是一个js文件，是当前比较流行的javascript函数库，内部封装了javascript代码

+ 特点

  + write less，do more

+ 使用

  + 使用jQuery，需要在html页面中引入jQuery库
  + <script src = "jquery.js"> </script>

+ 实现表格啄行变色

  + ```
    <body>
    <table align="center" width="500px" border="1px" cellspacing="0">
        <caption>学生信息</caption>
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>学校</th>
            <th>专业</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>刘备</td>
            <td>清华大学</td>
            <td>计算机</td>
        </tr>
        <tr>
            <td>2</td>
            <td>张飞</td>
            <td>山东大学</td>
            <td>通信</td>
        </tr>
        <tr>
            <td>3</td>
            <td>诸葛亮</td>
            <td>北京大学</td>
            <td>化学</td>
        </tr>
        <tr>
            <td>4</td>
            <td>小乔</td>
            <td>四川大学</td>
            <td>物理</td>
        </tr>
        </tbody>
    </table>


        <script>
            window.onload = function () {
                var trs = document.getElementsByTagName("tr");
                for (var i = 0; i < trs.length; i++) {
                    if (i % 2 == 0){//下标为偶数的行
                        trs[i].style.background = "blue"
                    } else {
                        trs[i].style.background = "yellow"
                    }
                }
            }
        </script>
    </body>
    ```

+ $就是jQuery，

+ ```
  <!--引入jquery-->
  <script src="../js/jquery-3.1.1.min.js"></script>
  <script>
      //文档加载之后执行
      $(document).ready(function () {
          //所有的jQuery代码都要写在里面
          $("table tr:even").css("background-color","blue");
          //odd:奇数
          $("table tr:odd").css("background-color","yellow");


      })
  </script>
  ```

+ $("table tr")就是获取页面中所有table标签下的tr标签

+  $(document).ready(function () {}）作用：

  + 等内容全部加载完成后再去执行jquery代码
  + 页面中定义的所有变量和方法都有写在里面

### 二，jQuery选择器

+ JavaScript获取dom元素过于繁琐，所有出现了jQuery选择器
+ jQuery选择器可以帮助我们快速定位一个或多个dom元素

1.基本选择器

+ ​	

  + id选择器

  + 类选择器

  + 标签选择器

  + ```
    <body>
        <div id="div01"></div>
        <div class="div02"></div>
        <div class="div02"></div>
        <p>好好学习</p>
        <p>天天向上</p>
        <p></p>

        <script src="../js/jquery-3.1.1.min.js"></script>
        <script>
            $(document).ready(function () {
                //id选择器
                $("#div01").css("width","100px")
                           .css("height","100px")
                             .css("background-color","red")
                //类选择器
                //对象格式：

                $(".div02").css({"width":"200px","height" : "200px","background-color":"red"})
                //标签选择器
                console.log($("p").length);


            })
        </script>
    </body>
    ```

+ 组合选择器

+ ```
  //组合选择器，多个选择器一起选择，之间用英文逗号分隔
  $("#div01,p").css("color","blue")
  ```

+ 层次选择器

+ ```
  <script src="../js/jquery-3.1.1.min.js"></script>
  <script>
      $(document).ready(function () {
          //后代选择器 ,选择di为div01下的所有P标签（子子孙孙）
          $("#div01 p").css("font-size","20px")
          //子选择器 :选择id为div01下的直接子元素和p标签（儿子辈的）
          $("#div01>p").css("background-color","yellow")
      })
  </script>
  ```

+ 过滤选择器

+ ```
  <body>
  <ul>
      <li>第一个</li>
      <li>第二个</li>
      <li>第四个</li>
      <li id="li05">第五个</li>
      <li>第六个</li>
      <li>第七个</li>
      <li>第八个</li>
      <li>第九个</li>
  </ul>

      <script src="../js/jquery-3.1.1.min.js"></script>
      <script>
          $(document).ready(function () {
              //获取第一个li
              $("li:first").css("color","red")
              //获取最后一个
              $("li:last").css("color","green")
              //获取偶数行
              $("li:even").css("background-color","yellow")
              $("li:odd").css("background-color","blue")
              //获取下标三的li
              $("li:eq(3)").css("font-size","26px")
              //获取下标小于三的li
              $("li:lt(3)").css("font-size","14px")
              //大于三
              $("li:gt(3)").css("font-size","36px")
              //获取id不是li05的li标签
              $("li:not(#li05)").css("font-family","隶书")



          })
      </script>
  ```

+ 属性选择器

+ ```
  <input type="text" name="uname"><br>
  <input type="password">



  <script src="../js/jquery-3.1.1.min.js"></script>
  <script>
      $(document).ready(function () {
          //属性选择器,根据name属性值获取元素语法：$("[属性名=属性值]”)
          $("[name=uname]").val("张三")
          //根据输入框的种类，即type属性值获取元素值语法：$(":属性值")
          $(":password").css("border-color" ,"red")
  ```

### 三，jQuery的优势

+ 简洁的写法：$("#tab")替代了js中的document.getElementByld("tab")
+ 更完善的处理机制
  + 页面中如果没有di为div01的元素，使用js获取元素中的内容会报错
  + 使用jquery不会报错，不会影响运行
  + $("#div01").text()

### 四，jQuery中的事件

+ DOM加载

+ $(document).ready(function(){})

+ 简写为：

+ ```
  <script src="../js/jquery-3.1.1.min.js"></script>
  <script>
      $(function () {
          
      })
      
      
  </script>
  ```

+ 点击事件，失去光标事件，合成事件

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <input type="text" id="uname">
    <button id="btn">按钮</button>
    <div id="div01" style="width: 100px;height: 100px">一块区域</div>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <script>
        $(function () {
            //点击按钮，获取文本框的内容，如果内容为空，赋值张三
            //触发事件的思路，先获取元素，触发这个元素的事件，事件以函数的形式调用
            $("#btn").click(function () {
                if ($("#uname").val() == ""){
                    $("#uname").val("张三")
                } else {
                    alert($("#uname").val())
                }
            })
            //失去光标，得到光标
            $("#uname").focus(function () {
                $(this).css("background-color","green")
            }).blur(function () {
                $(this).css("background-color","red")
            })
            //合成事件
            //当鼠标移动到元素上触发第一个函数，当鼠标从元素上移开触发第二个函数
            $("#div01").hover(function () {
                $(this).css("background-color","yellow")
            },function () {
                $(this).css("background-color","blue")
            })




        })
        
        
```

### 五，jquery常用动画

+ 隐藏和显示

+ ```
  <script src="../js/jquery-3.1.1.min.js"></script>
  <script>
      $(function () {
          $("#btn").click(function () {
             /* //获取下一个元素next（）
              //is（”：hidden“）：判断元素的显隐状态，隐藏返回true
              if ( $(this.next()).is(":hidden")){
                  $(this).next().show(2000)//显示
              }else{
                  $(this).next().hide(2000)//隐藏
              }*/
             $(this).next().toggle(2000)
          })
      })
  </script>
  ```

+ 淡入和淡出

+ 滑动

+ ​