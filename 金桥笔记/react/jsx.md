## JSX

### 一，js表达式

+ 我们可以在 JSX 中使用 JavaScript 表达式。表达式写在花括号 **{}** 中。实例如下：

+ ```
  ReactDOM.render(
      <div>
        <h1>{1+1}</h1>
      </div>
      ,
      document.getElementById('example')
  );
  ```

+ ```
  ReactDOM.render(
      <div>
        <h1>{i == 1 ? 'True!' : 'False'}</h1>
      </div>
      ,
      document.getElementById('example')
  );
  ```

### 二，内联样式

+ ```
  var myStyle = {
      fontSize: 100,
      color: '#FF0000'
  };
  ReactDOM.render(
      <h1 style = {myStyle}>菜鸟教程</h1>,
      document.getElementById('example')
  );
  ```

### 三，注释

+ 注释需要写在花括号中，实例如下：

+ ```
  ReactDOM.render(
      <div>
      <h1>菜鸟教程</h1>
      {/*注释...*/}
       </div>,
      document.getElementById('example')
  );
  ```

### 四，数组

+ JSX 允许在模板中插入数组，数组会自动展开所有成员：

+ ```
  var arr = [
    <h1>菜鸟教程</h1>,
    <h2>学的不仅是技术，更是梦想！</h2>,
  ];
  ReactDOM.render(
    <div>{arr}</div>,
    document.getElementById('example')
  );
  ```

+ ​