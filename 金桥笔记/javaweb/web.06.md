## EL表达式和JSTL标签库

+ 核心作用：用来替代jsp中的java代码

### 01-EL表达式

+ 概述
  + expression language
  + 用在jsp中，用于获取后台传递到jsp中的数据
  + el用于替代getAttribute（）

+ 语法

  + ${范围对象.变量名}
  + ${requestScope.msg}    ===》request。getAttribute（“msg”）
  + 获取request对象中的msg，并展示在页面中，在展示前，会进行非空校验
  + 还可以通过${requestScope['msg']}   
  + ${sessionScope["uname"]}

+ el表达式获取数据的方式

  + 可以在el中省略范围对象，直接使用${变量名}的方式展示数据

  + ```
    ${msg}
    ```

  + el表达式，依此从多个范围对象中查找该变量，一直到找到为止

    + 查找顺序：page，request，session，application
    + 这四个式jsp范围内置对象，可以使用setAttribute和getAttribute进行数据的存取
    + page：当前页面，存到page对象中的数据只能在当前页面中获取，访问

  + ​

    + request：一次请求过程中，只要请求不结束，数据一直可以访问
    + session：回哈对象，在一次访问过程中都可以访问
    + application：应用对象，在tomcat整个启动期间，都可以访问0

### 02-JSTL

+ Java stardand taglib ，java标准标签库

+ 提供很多标签，在jsp中使用

+ 这些标签完成某些java功能

+ 我们使用JSTL标签替代jsp中java逻辑操作

+ 使用步骤

  + 引入jar包

  + 需要在jap页面中引入这个标签

  + ```
    <%--引入JSTL的标签库--%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    ```

  + 在当前jsp页面中，可以使用

  + ```
        <c:forEach items="${stuList}" var="stu">
            <tr>
                <td><input type="checkbox"></td>
                <td>${stu.sno}</td>
                <td>${stu.sname}</td>
                <td>${stu.ssex}</td>
                <td>${stu.age}</td>
                <td>${stu.address}</td>
            </tr>
        </c:forEach>
    </tbody>
    ```

+ 常用标签

  + c:if用来判断某个后台变量 是否符合条件

  + c:choose二选一

  + c:foreach 实现对某个集合或者数组的循环

  + ```
     <%
            pageContext.setAttribute("name",null);
            pageContext.setAttribute("number",1);
            List<String> list = new ArrayList<>();
            list.add("one");
            list.add("two");
            list.add("three");
            request.setAttribute("list",list);
        %>

    <%--    判断page中的name是否为空--%>
        <c:if test="${empty name}">
            用户名为空
        </c:if>
        <c:if test="${not empty name}">
            ${name}
        </c:if>
        <c:if test="${number == 1}">
            ${number}
        </c:if>

       <%-- <c:choose>
            <c:when test=""></c:when>
            <c:otherwise></c:otherwise>
        </c:choose>--%>
        <ul>
        <c:forEach items="${list}" var="str" varStatus="vs">
            <c:if test="${vs.index % 2 ==0}">
                <li style="background: bisque">
            </c:if>
            <c:if test="${vs.index % 2 != 0}">
                <li>
            </c:if>

    <%--        index代表变量下标，从零开始--%>
            ${vs.index +1} --- ${str}<br>
    <%--        计数，代表展示了几个变量--%>
            ${vs.count}<br>
    <%--        是否是第一个--%>
            ${vs.first}<br>
            </li>

        </c:forEach>
        </ul>
    <%--    for循环输出1-5--%>
        <c:forEach begin="1" end="5" step="1" var="num">
            ${num}
        </c:forEach>
    </body>
    ```

    + items：数据项，要进行变量的集合对象，通过el获取
    + var：变量名，代表集合或者数组中的每个对象
    + varStatus：当前变量的状态
      + index：下标
      + count ：计数
      + first ：是否第一个
      + begin ：迭代起始值
      + end：迭代结束值
      + step ：步长
      + var：迭代变量

  + 通用标签

  + ```
    <%--通用标签--%>
    <%--    定义String msg = "hello" 然后request.setAttribute（"msg",msg）--%>
        <c:set var="msg" value="hello" scope="request"/>
    <%--    ${msg}--%>
        <c:out value="${msg}"/>
    <%--    移除变量--%>
        <c:remove var="msg" scope="request"/>
        ${msg}

    <%--重定向--%>
        <c:redirect url="testEl.jsp"/>
    ```

  + ​