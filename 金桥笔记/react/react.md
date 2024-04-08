## react

###一，组件

+ 通过函数或者class创建组件，返回值即位页面显示内容，

+ 在组件内部通过this.props.属性来调用组件属性

+ ```
  function HelloMessage(props) {
      return <h1>Hello {props.name}!</h1>;
  }
   
  const element = <HelloMessage name="Runoob"/>;
   
  ReactDOM.render(
      element,
      document.getElementById('example')
  );
  ```

+ 注意，原生 HTML 元素名以小写字母开头，而自定义的 React 类名以大写字母开头，比如 HelloMessage 不能写成 helloMessage。除此之外还需要注意组件类只能包含一个顶层标签，否则也会报错

+ 复合组件

+ ```
  function Name(props) {
      return <h1>网站名称：{props.name}</h1>;
  }
  function Url(props) {
      return <h1>网站地址：{props.url}</h1>;
  }
  function Nickname(props) {
      return <h1>网站小名：{props.nickname}</h1>;
  }
  function App() {
      return (
      <div>
          <Name name="菜鸟教程" />
          <Url url="http://www.runoob.com" />
          <Nickname nickname="Runoob" />
      </div>
      );
  }
   
  ReactDOM.render(
       <App />,
      document.getElementById('example')
  );
  ```

### React State(状态)

+ React 把组件看成是一个状态机（State Machines）。通过与用户的交互，实现不同状态，然后渲染 UI，让用户界面和数据保持一致。

  React 里，只需更新组件的 state，然后根据新的 state 重新渲染用户界面（不要操作 DOM）

+ ```
  class Clock extends React.Component {
    constructor(props) {
      super(props);
      this.state = {date: new Date()};
    }
   
    componentDidMount() {
      this.timerID = setInterval(
        () => this.tick(),
        1000
      );
    }
   
    componentWillUnmount() {
      clearInterval(this.timerID);
    }
   
    tick() {
      this.setState({
        date: new Date()
      });
    }
   
    render() {
      return (
        <div>
          <h1>Hello, world!</h1>
          <h2>现在是 {this.state.date.toLocaleTimeString()}.</h2>
        </div>
      );
    }
  }
   
  ReactDOM.render(
    <Clock />,
    document.getElementById('example')
  );
  ```

+ componentDidMount() 与 componentWillUnmount() 方法被称作生命周期钩子。

  在组件输出到 DOM 后会执行 componentDidMount() 钩子，我们就可以在这个钩子上设置一个定时器。

  this.timerID 为定时器的 ID，我们可以在 componentWillUnmount() 钩子中卸载定时器。

+ 使用this.setState()方法，来改变组件的状态，从而重新渲染组件。

## 默认 Props

你可以通过组件类的 defaultProps 属性为 props 设置默认值，实例如下

+ ```
  class HelloMessage extends React.Component {
    render() {
      return (
        <h1>Hello, {this.props.name}</h1>
      );
    }
  }
   
  HelloMessage.defaultProps = {
    name: 'Runoob'
  };
   
  const element = <HelloMessage/>;
   
  ReactDOM.render(
    element,
    document.getElementById('example')
  );
  ```

## Props 验证

+ Props 验证使用 **propTypes**，它可以保证我们的应用组件被正确使用，React.PropTypes 提供很多验证器 (validator) 来验证传入数据是否有效。当向 props 传入无效数据时，JavaScript 控制台会抛出警告。

+ ```
  var title = "菜鸟教程";
  // var title = 123;
  class MyTitle extends React.Component {
    render() {
      return (
        <h1>Hello, {this.props.title}</h1>
      );
    }
  }
   
  MyTitle.propTypes = {
    title: PropTypes.string
  };
  ReactDOM.render(
      <MyTitle title={title} />,
      document.getElementById('example')
  );
  ```

+ ```
  MyComponent.propTypes = {
      // 可以声明 prop 为指定的 JS 基本数据类型，默认情况，这些数据是可选的
     optionalArray: React.PropTypes.array,
      optionalBool: React.PropTypes.bool,
      optionalFunc: React.PropTypes.func,
      optionalNumber: React.PropTypes.number,
      optionalObject: React.PropTypes.object,
      optionalString: React.PropTypes.string,
   
      // 可以被渲染的对象 numbers, strings, elements 或 array
      optionalNode: React.PropTypes.node,
   
      //  React 元素
      optionalElement: React.PropTypes.element,
   
      // 用 JS 的 instanceof 操作符声明 prop 为类的实例。
      optionalMessage: React.PropTypes.instanceOf(Message),
   
      // 用 enum 来限制 prop 只接受指定的值。
      optionalEnum: React.PropTypes.oneOf(['News', 'Photos']),
   
      // 可以是多个对象类型中的一个
      optionalUnion: React.PropTypes.oneOfType([
        React.PropTypes.string,
        React.PropTypes.number,
        React.PropTypes.instanceOf(Message)
      ]),
   
      // 指定类型组成的数组
      optionalArrayOf: React.PropTypes.arrayOf(React.PropTypes.number),
   
      // 指定类型的属性构成的对象
      optionalObjectOf: React.PropTypes.objectOf(React.PropTypes.number),
   
      // 特定 shape 参数的对象
      optionalObjectWithShape: React.PropTypes.shape({
        color: React.PropTypes.string,
        fontSize: React.PropTypes.number
      }),
   
      // 任意类型加上 `isRequired` 来使 prop 不可空。
      requiredFunc: React.PropTypes.func.isRequired,
   
      // 不可空的任意类型
      requiredAny: React.PropTypes.any.isRequired,
   
      // 自定义验证器。如果验证失败需要返回一个 Error 对象。不要直接使用 `console.warn` 或抛异常，因为这样 `oneOfType` 会失效。
      customProp: function(props, propName, componentName) {
        if (!/matchme/.test(props[propName])) {
          return new Error('Validation failed!');
        }
      }
    }
  }
  ```
  ### react事件处理

  + React 元素的事件处理和 DOM 元素类似。但是有一点语法上的不同:

    - React 事件绑定属性的命名采用驼峰式写法，而不是小写。

    - 如果采用 JSX 的语法你需要传入一个函数作为事件处理函数，而不是一个字符串(DOM 元素的写法

    - ```
      HTML 通常写法是：

      <button onclick="activateLasers()">
        激活按钮
      </button>
      ```

    - ```
      React 中写法为：

      <button onClick={activateLasers}>
        激活按钮
      </button>
      ```

    - 在 React 中另一个不同是你不能使用返回 **false** 的方式阻止默认行为， 你必须明确使用 preventDefault。例如，通常我们在 HTML 中阻止链接默认打开一个新页面，可以这样写

+ ```
  在 React 的写法为：

  function ActionLink() {
    function handleClick(e) {
      e.preventDefault();
      console.log('链接被点击');
    }
   
    return (
      <a href="#" onClick={handleClick}>
        点我
      </a>
    );
  }
  ```

+ 你可以通过用花括号包裹代码在 JSX 中嵌入任何表达式 ，也包括 JavaScript 的逻辑与 &&，它可以方便地条件渲染一个元素。

+ ```
  function Mailbox(props) {
    const unreadMessages = props.unreadMessages;
    return (
      <div>
        <h1>Hello!</h1>
        {unreadMessages.length > 0 &&
          <h2>
            您有 {unreadMessages.length} 条未读信息。
          </h2>
        }
      </div>
    );
  }
   
  const messages = ['React', 'Re: React', 'Re:Re: React'];
  ReactDOM.render(
    <Mailbox unreadMessages={messages} />,
    document.getElementById('example')
  );
  ```

+ 在 JavaScript 中，true && expression 总是返回 **expression**，而 false && expression 总是返回 **false**。

  因此，如果条件是 **true**，&& 右侧的元素就会被渲染，如果是 **false**，React 会忽略并跳过它

+ 三目运算符

+ ```
  render() {
    const isLoggedIn = this.state.isLoggedIn;
    return (
      <div>
        {isLoggedIn ? (
          <LogoutButton onClick={this.handleLogoutClick} />
        ) : (
          <LoginButton onClick={this.handleLoginClick} />
        )}
      </div>
    );
  }
  ```


### react列表和keys

+ ```
  const numbers = [1, 2, 3, 4, 5];

  const listItems = numbers.map((numbers) =>

    <li>{numbers}</li>

  );

  ReactDOM.render(

    <ul>{listItems}</ul>,

    document.getElementById('example')

  );

  ```

+ 我们可以将以上实例重构成一个组件，组件接收数组参数，每个列表元素分配一个 key，不然会出现警告 a key should be provided for list items，意思就是需要包含 key：

+ ```
  function NumberList(props) {
    const numbers = props.numbers;
    const listItems = numbers.map((number) =>
      <li key={number.toString()}>
        {number}
      </li>
    );
    return (
      <ul>{listItems}</ul>
    );
  }
   
  const numbers = [1, 2, 3, 4, 5];
  ReactDOM.render(
    <NumberList numbers={numbers} />,
    document.getElementById('example')
  );
  ```

+ 一个元素的 key 最好是这个元素在列表中拥有的一个独一无二的字符串。通常，我们使用来自数据的 id 作为元素的 key:

+ ```
  const todoItems = todos.map((todo) =>
    <li key={todo.id}>
      {todo.text}
    </li>
  );
  ```

+ 当元素没有确定的 id 时，你可以使用他的序列号索引 index 作为 key

+ ```
  const todoItems = todos.map((todo, index) =>
    // 只有在没有确定的 id 时使用
    <li key={index}>
      {todo.text}
    </li>
  );
  ```

### react组件的API

+ 在本章节中我们将讨论 React 组件 API。我们将讲解以下7个方法:
  - 设置状态：setState
  - 替换状态：replaceState
  - 设置属性：setProps
  - 替换属性：replaceProps
  - 强制更新：forceUpdate
  - 获取DOM节点：findDOMNode
  - 判断组件挂载状态：isMounted
+ 设置状态setState

### react生命周期

+ 在本章节中我们将讨论 React 组件的生命周期。

  组件的生命周期可分成三个状态：

  - Mounting(挂载)：已插入真实 DOM

  - Updating(更新)：正在被重新渲染

  - Unmounting(卸载)：已移出真实 DOM

  - ####挂载

  当组件实例被创建并插入 DOM 中时，其生命周期调用顺序如下：

  - `constructor()`: 在 React 组件挂载之前，会调用它的构造函数。
  - `getDerivedStateFromProps()`: 在调用 render 方法之前调用，并且在初始挂载及后续更新时都会被调用。
  - `render()`: render() 方法是 class 组件中唯一必须实现的方法。
  - `componentDidMount()`: 在组件挂载后（插入 DOM 树中）立即调用。

  render() 方法是 class 组件中唯一必须实现的方法，其他方法可以根据自己的需要来实现。

  这些方法的详细说明，可以参考

+ ## 更新

  每当组件的 state 或 props 发生变化时，组件就会更新。

  当组件的 props 或 state 发生变化时会触发更新。组件更新的生命周期调用顺序如下：

  - `getDerivedStateFromProps()`: 在调用 render 方法之前调用，并且在初始挂载及后续更新时都会被调用。根据 shouldComponentUpdate() 的返回值，判断 React 组件的输出是否受当前 state 或 props 更改的影响。
  - `shouldComponentUpdate()`:当 props 或 state 发生变化时，shouldComponentUpdate() 会在渲染执行之前被调用。
  - `render()`: render() 方法是 class 组件中唯一必须实现的方法。
  - `getSnapshotBeforeUpdate()`: 在最近一次渲染输出（提交到 DOM 节点）之前调用。
  - `componentDidUpdate()`: 在更新后会被立即调用。

  render() 方法是 class 组件中唯一必须实现的方法，其他方法可以根据自己的需要来实现。

  这些方法的详细说明，可以参考[官方文档](https://zh-hans.reactjs.org/docs/react-component.html#reference)。

+ ## 卸载

  当组件从 DOM 中移除时会调用如下方法：

  - `componentWillUnmount()`: 在组件卸载及销毁之前直接调用。

  这些方法的详细说明，可以参考[官方文档](https://zh-hans.reactjs.org/docs/react-component.html#reference)

  ### ajax

+ React 组件的数据可以通过 componentDidMount 方法中的 Ajax 来获取，当从服务端获取数据时可以将数据存储在 state 中，再用 this.setState 方法重新渲染 UI。

  当使用异步加载数据时，在组件卸载前使用 componentWillUnmount 来取消未完成的请求。

  以下实例演示了获取 Github 用户最新 gist 共享描述:

+ ```
  class UserGist extends React.Component {
    constructor(props) {
        super(props);
        this.state = {username: '', lastGistUrl: ''};
    }
   
   
    componentDidMount() {
      this.serverRequest = $.get(this.props.source, function (result) {
        var lastGist = result[0];
        this.setState({
          username: lastGist.owner.login,
          lastGistUrl: lastGist.html_url
        });
      }.bind(this));
    }
   
    componentWillUnmount() {
      this.serverRequest.abort();
    }
   
    render() {
      return (
        <div>
          {this.state.username} 用户最新的 Gist 共享地址：
          <a href={this.state.lastGistUrl}>{this.state.lastGistUrl}</a>
        </div>
      );
    }
  }
   
  ReactDOM.render(
    <UserGist source="https://api.github.com/users/octocat/gists" />,
    document.getElementById('example')
  )
  ```

### react表单

+ 本章节我们将讨论如何在 React 中使用表单。

  HTML 表单元素与 React 中的其他 DOM 元素有所不同,因为表单元素生来就保留一些内部状态。

  在 HTML 当中，像 <input>, <textarea>, 和 <select> 这类表单元素会维持自身状态，并根据用户输入进行更新。但在React中，可变的状态通常保存在组件的状态属性中，并且只能用 setState() 方法进行更新。

+ 在实例中我们设置了输入框 input 值 **value = {this.state.data}**。在输入框值发生变化时我们可以更新 state。我们可以使用 **onChange** 事件来监听 input 的变化，并修改 state

+ ```
  class HelloMessage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: 'Hello Runoob!'};
        this.handleChange = this.handleChange.bind(this);
    }
   
    handleChange(event) {
      this.setState({value: event.target.value});
    }
    render() {
      var value = this.state.value;
      return <div>
              <input type="text" value={value} onChange={this.handleChange} /> 
              <h4>{value}</h4>
             </div>;
    }
  }
  ReactDOM.render(
    <HelloMessage />,
    document.getElementById('example')
  ```

+ 在 React 中，不使用 selected 属性，而在根 select 标签上用 value 属性来表示选中项。

### ref

+ React 支持一种非常特殊的属性 **Ref** ，你可以用来绑定到 render() 输出的任何组件上。

  这个特殊的属性允许你引用 render() 返回的相应的支撑实例（ backing instance ）。这样就可以确保在任何时间总是拿到正确的实例。

+ ```
  class MyComponent extends React.Component {
    handleClick() {
      // 使用原生的 DOM API 获取焦点
      this.refs.myInput.focus();
    }
    render() {
      //  当组件插入到 DOM 后，ref 属性添加一个组件的引用于到 this.refs
      return (
        <div>
          <input type="text" ref="myInput" />
          <input
            type="button"
            value="点我输入框获取焦点"
            onClick={this.handleClick.bind(this)}
          />
        </div>
      );
    }
  }
   
  ReactDOM.render(
    <MyComponent />,
    document.getElementById('example')
  );
  ```

### 包含

+ 有些组件无法提前知晓它们子组件的具体内容。在 `Sidebar`（侧边栏）和 `Dialog`（对话框）等展现通用容器（box）的组件中特别容易遇到这种情况。

  我们建议这些组件使用一个特殊的 `children` prop 来将他们的子组件传递到渲染结果中：

+ ```
  function FancyBorder(props) {
    return (
      <div className={'FancyBorder FancyBorder-' + props.color}>
        {props.children}
      </div>
    );
  }
  function WelcomeDialog() {
    return (
      <FancyBorder color="blue">
        <h1 className="Dialog-title">
          Welcome
        </h1>
        <p className="Dialog-message">
          Thank you for visiting our spacecraft!
        </p>
      </FancyBorder>
    );
  }
  ```

+ `<FancyBorder>` JSX 标签中的所有内容都会作为一个 `children` prop 传递给 `FancyBorder` 组件。因为 `FancyBorder` 将 `{props.children}` 渲染在一个 `<div>` 中，被传递的这些子组件最终都会出现在输出结果中。



+ 少数情况下，你可能需要在一个组件中预留出几个“洞”。这种情况下，我们可以不使用 `children`，而是自行约定：将所需内容传入 props，并使用相应的 prop。

+ ```
  function SplitPane(props) {
    return (
      <div className="SplitPane">
        <div className="SplitPane-left">
          {props.left}
        </div>
        <div className="SplitPane-right">
          {props.right}
        </div>
      </div>
    );
  }

  function App() {
    return (
      <SplitPane
        left={
          <Contacts />
        }
        right={
          <Chat />
        } />
    );
  }
  ```

+ ​