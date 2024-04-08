## redux

### 入门

+ Redux 是 JavaScript 应用的状态容器，提供可预测的状态管理。

  可以帮助你开发出行为稳定可预测的、运行于不同的环境（客户端、服务器、原生应用）、易于测试的应用程序。不仅于此，它还提供超爽的开发体验，比如有一个[与时间旅行调试器相结合的实时代码编辑](https://github.com/reduxjs/redux-devtools)。

  可以将 Redux 与 [React](https://reactjs.org/) 或其他视图库一起使用。它体小精悍（只有2kB，包括依赖），却有很强大的插件扩展生态。

+ ````
  # NPM
  npm install @reduxjs/toolkit

  # Yarn
  yarn add @reduxjs/toolkit
  ````

+ 创建一个React Redux应用

+ 官方推荐的使用 React 和 Redux 创建新应用的方式是使用 [官方 Redux+JS 模版](https://github.com/reduxjs/cra-template-redux)或 [Redux+TS 模板](https://github.com/reduxjs/cra-template-redux-typescript)，它基于 [Create React App](https://github.com/facebook/create-react-app)，利用了 **Redux Toolkit** 和 Redux 与 React 组件的集成.

+ ```
  # Redux + Plain JS template
  npx create-react-app my-app --template redux

  # Redux + TypeScript template
  npx create-react-app my-app --template redux-typescript
  ```

+ Redux核心库

+ ```
  # NPM
  npm install redux

  # Yarn
  yarn add redux
  ```

+ 应用的整体全局状态以对象树的方式存放于单个 *store*。 唯一改变状态树（state tree）的方法是创建 *action*，一个描述发生了什么的对象，并将其 *dispatch* 给 store。 要指定状态树如何响应 action 来进行更新，你可以编写纯 *reducer* 函数，这些函数根据旧 state 和 action 来计算新 state