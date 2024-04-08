## Ajax

### 01-Ajax简介

+ asychornous + JavaScript + xml
  + 异步的JavaScript + xml对象
+ Ajax是可以实现不刷新页面的情况下请求后台，进而更新局部网页的技术

### 02-jquery对ajax的支持

+ $.ajax()

+ ```
  <script>
      layui.use(['jquery']),function () {
      var $ = layui.$
          $("input[name=user]").blur(function () {
              //当输入框失去焦点时，校验用户名是否可用
              var user = $(this).val();//获取当前元素的value值
              //使用jQuery提供的Ajax请求后台
              $.ajax({
                  url:"/ExistUserServlet",//请求路径
                  data:{"user":user},//要发送给后台的数据
                  type:"get",//请求类型get/post
                  async:true,//是否异步，一般为true
                  dataType:"text",//响应返回数据类型
                  success:function (msg) {//小括号中的参数就是后台传回来的数据
                      //后台没有出现异常就执行success内容
                      $("#msg").html(msg)
                  },
                      error:function (err) {
                      //后台出现异常，执行error的内容
                          alert("服务器响应失败")
                      }
              })
          })
      }



  </script>
  ```

+ layui中table.render()封装了ajax操作

+ ```
   response.setContentType("text/html;charset=utf-8");
          //获取前台传递过来的user
          //data：{"user":user}
          String user = request.getParameter("user");
          PrintWriter pw = response.getWriter();
          //判断用户名是否可用
          if ("张三".equals(user)){
              //向前台发送消息“该用户名不可以”
              pw.write("该用户名不可用");
          } else {
              pw.write("用户名可用");
          }
          pw.flush();
          pw.close();
      }
  }

  ```

+ 转发和重定向都会造成整个页面的刷新，所有我们使用响应流的方式给浏览器

+ data的写法

  + json对象

    + ```
      // data:{"user":user，},
      ```

  + 表单序列化--把整个表单转换成一个json字符串

    + ```
      data:$("#form1").serialize(),
      ```

    + 表单元素的name属性就是name，value属性就是value

context.lookup()