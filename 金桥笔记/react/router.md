### 一.配置路由表

```
import {BrowserRouter,useRoutes} from "react-router-dom";
import List from "../List";
import Game from "../game/Game"
import Layout from "../pages/Layout";
import Home from "../pages/Home";
import Blogs from "../pages/Blogs";
import Contact from "../pages/Contact";
import NoPage from "../pages/NoPage";

export default  function GetRoutes() {
    const routes = useRoutes(
    [
        {
            path: '/',
            element: <Layout/>,
            children: [
                {
                    index:<Home/>
                },
                {
                    path: 'blogs',
                    element: <Blogs/>
                },
                {
                    path: 'contact',
                    element: <Contact/>
                },
                {
                    path: '',
                    element: <NoPage/>
                },
                {
                    path: 'list',
                    element: <List/>
                },
                {
                    path: 'game',
                    element: <Game/>
                }
            ]
        }
    ]
    )
    return routes;
}
```

默认路由配置有问题

### 二，使用路由表

```
import React,{PureComponent} from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
/*import App from './App';*/
import reportWebVitals from './reportWebVitals';
import {BrowserRouter,Routes,Route,useRoutes} from "react-router-dom";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import Blogs from "./pages/Blogs";
import Contact from "./pages/Contact";
import NoPage from "./pages/NoPage";
import {CSSTransition,TransitionGroup} from "react-transition-group";
import List from "./List";
import Game from "./game/Game"
import Routess from './router/index'
/*import {Button} from 'antd';*/
/*import './CSSTransition.css'*/


/*export default function App() {*/
function App (){

        return (
            <BrowserRouter>
            <Routess/>
            </BrowserRouter>
        )


}
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App/>);
/*root.render(<List/>)*/
```

### 注意，

+ router的hook函数只能在函数组件中使用，不能在嵌套的函数中使用。
+ 组件函数首字母大小

### 三，直接配置路由

```
import React,{PureComponent} from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
/*import App from './App';*/
import reportWebVitals from './reportWebVitals';
import {BrowserRouter,Routes,Route,useRoutes} from "react-router-dom";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import Blogs from "./pages/Blogs";
import Contact from "./pages/Contact";
import NoPage from "./pages/NoPage";
import {CSSTransition,TransitionGroup} from "react-transition-group";
import List from "./List";
import Game from "./game/Game"
import Routess from './router/index'
/*import {Button} from 'antd';*/
/*import './CSSTransition.css'*/


/*export default function App() {*/
function App (){

        return (
 <BrowserRouter>
                            <Routes >
                                <Route path="/" element={<Layout/>}>
                                    <Route index element={<Home/>}/>
                                    <Route path="blogs" element={<Blogs/>}/>
                                    <Route path="contact" element={<Contact/>}/>
                                    <Route path="" element={<NoPage/>}/>
                                    <Route path="list" element={<List/>}/>
                                    <Route path="game" element={<Game/>}/>
                                </Route>
                            </Routes>
                        </BrowserRouter>
        )


}
            
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App/>);
/*root.render(<List/>)*/

```

路由动画？

layout配置

```
import { Outlet, Link } from "react-router-dom";

const Layout = () => {
    return (
        <>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/blogs">Blogs</Link>
                    </li>
                    <li>
                        <Link to="/contact">Contact</Link>
                    </li>
                    <li>
                        <Link to="/list">List</Link>
                    </li>
                    <li>
                        <Link to="/game">Game</Link>
                    </li>
                </ul>
            </nav>

            <Outlet />
        </>
    )
};

export default Layout;
```