# 路由对象

## 01-路由

+ 后端路由：分发用户的请求，后端路由会根据用户在浏览器上的请求路径去找到对应的后台处理器，也就是后台的请求方法，负责接收请求并做出响应。或者是根据请求路径找到后台对应的jsp或者servlet资源。
+ 前端路由
  + 整个前端项目是一个单页面，只有一个html，切换页面时，浏览器不会发送新的请求，路径也不会发生变化，无法使用后端路由。
  + 前台页面的切换，依靠前端路由来实现。
  + 页面切换本质就是组建的切换，前端路由的作用就是根据要请求的资源信息找到对应的组件显示在页面上。
  + 实现方式
    + 组件切换时，vue提供的方式依然是改变浏览器的访问路径，前端路由会根据当前的访问路径去找到对应的组件显示到页面中
    + 路径上有一个#，以哈希算法方式根据#后的路径去找到对应组件
    + 如果不带#，代表的是浏览器发生信息请求，是由后端路由起作用。
    + 带上#就是前端路由起作用，html不变，浏览器没有发生信的请求，前端路由去找资源。
+ vue中提供了vue-router对象实现了前端路由的作用。

## 02-vue-router的安装

+ 安装路由对象

  + npm install vue-router-g

+ 安装完成后，需要在全局引用

+ ```
  import VueRouter from 'vue-router'
  ```

+ ```
  Vue.use(VueRouter)
  ```

+ 在全局vue对象上注册这个路由对象

+ ```
  new Vue({
    router,

  }）
  ```

## 03-路由的使用

+ 首先在views目录下创建自己的页面组件

  + 比如Login.vue对应以前的jsp文件

+ router目录下的index.js中维护路由匹配原则

  + 为了告诉前端路由对象，当浏览器访问什么路径时，显示哪个组件

  + 路径和组件的对应关系

  + ```
    import Login from '../views/Login.vue'
     { path:'/login',
      name:'login',
      /*组件名称对应上方的引入组件名称*/
      component:Login
    ```



    }
    ​```

  + 当浏览器路径为localhost：8080/#/login，浏览器显示Login登录组件

+ 组件如何显示到了页面上

  + 所有通过路径之间切换找到的组件都会显示在跟组件App.vue中的router-view标签下

  + ```
    <!--跟组件的占位符，用于显示路由对象找到的那个组件-->
    <router-view/>
    ```

  + router-view的作用就是在一个组件中嵌入另外一个组件

+ 路由对象的执行过程，当浏览器路径发生变化时，前端路由会根据#后的路径，去路由匹配规则中进行比对

+ 根据当前path路径，会找到一个component组件

+ 路由对象就会将这个组件对象响应给vue对象

+ vue对象这个组件就显示到了App.vue根组件的router-view标签下。

## 04-页面的切换及访问方式

+ 大页面的切换，一般都在App.vue中实现


+ 可以通过a标签，直接修改浏览器的访问路径，实现资源的跳转，实现页面的切换

+ ```html
  <a href="#/login">登录</a>
  ```

+ 使用router-link，实现页面切换

+ ```
  <router-link to="/login">登录</router-link>
  ```

+ js中动态实现

+ ```html
  <template>
      <div>
          <h4>这是登陆页面</h4>
          <button @click="toAbout">跳转到about</button>
      </div>
  </template>

  <script>
      export default {
          name: "Login",
          methods:{
              toAbout(){
                  //通过js动态实现页面跳转
                  this.$router.push({
                      path:"/about"
                  })
              }
          }
      }
  </script>

  <style scoped>
  ```

+ 以上方式切换的组件都会显示到App.vue中的router-view标签下。

## 05-路由重定向

+ 重定向让浏览器访问一个新的路径

+ ```JavaScript
  const routes = [
    {
      path:'/',
    //  重定向到/home路径上
      redirect:'/home'
    },
    {
      path: '/home',
      name: 'home',
      component: HomeView
    },
  ```

  + 我们去访问localhost：8080/#/时，浏览器会自动去访问/#/home这个目录，将对应的组件显示到页面中。

## 06-路由传参

+ 指的是在路径上拼接参数传递到对应组件中

+ 方式一：query方式传参

  + 在路径上以问好形式拼接参数，多个参数之间使用&分隔

  + ```
    <router-link to="/about?name=admin&pwd=123">About</router-link>|
    ```

  + 在js跳转时以query对象形式传递参数

  + ```
    <template>
        <div>
            <button @click="red">跳转到about</button>
        </div>
    </template>

    <script>
        export default {
            name: "MyView",
            data(){
                return{
                    name:"admin",
                    pwd:"123"
                }
            },
            methods:{
                red(){
                    this.$router.push({
                        path:"/about",
                        /*query实现路径传参*/
                        query:{
                            name:this.name,
                            pwd:this.pwd
                        }
                    })
                }
            }
        }
    ```

    + query对象中的这个属性依然会被拼接到路径上

  + 参数的获取

    + 在目标页面获取路径参数

    + ```javascript
          data(){
            return{
              //用于接收路径拼接的参数
              name:this.$route.query.name,
              pwd:this.$route.query.pwd

            }
          }
      ```

    + 直接在html中以插值表达式方式获取，this指代当前这个组件对象，只用在js中，hrml中无需使用关键字

    + ```
      <h4>{{name}}----{{pwd}}</h4>
      <h4>{{$route.query.name}}</h4>
      ```

+ 方式二：params方式

  + 以/形式直接在路径上拼接参数值，

  + ```
    <router-link to="/myview/admin/123">MyView</router-link>
    ```

  + 修改路由匹配原则中的path属性

  + ```
    {
      /*:name代表要接受路径上的参数*/
      path:'/myview/:name/:pwd',
      name:'myview',
      component:MyView
    },
    ```

  + 在目标位置获取

  + ```
    /*params后跟的时路径上指定的变量名称*/
    name02:this.$route.params.name,
    pwd02:this.$route.params.pwd
    ```

  + js中实现params方式传参

  + ```
    redparams(){
        this.$router.push({
            /*对应路由对象中的name属性值*/

            name:'about',
            /*通过params方式进行传参*/
            params:{
                name:this.name,
                pwd:this.pwd
            }

        })
    ```

## 07-路由嵌套

+ 我们在路由匹配原则中维护的路由陪陪对象，所用对象直接显示在App.vue根组件下，比如登录页面，注册页面

+ 如果页面中左侧有导航栏，通过导航栏切换页面时，这些页面应该显示在主页中

+ 需要实现路由嵌套

+ 路由嵌套的实现

  + 创建主页面，已经要切换的主页面

    + 主页面下有两个列表页面

    + Index.vue  Emp.vue  . Dept.vue

    + 维护路由原则

    + ```
      const routes = [
        {
          path:'/index',
          name:'index',
          component:Index,
          //children对应的是所有子页面路由对象
          children:[
            {
              path:'emp',component:Emp
            },
            {
              path:'dept',component:Dept
            }
      ```


          ]
        },
      ```
    
    + 在index下是实现子页面的切换
    
    + ```
      <template>
          <div>
              <h3>系统主页面</h3>
      <!--        emp和dept对应的是路由对象中子路由的path路径-->
              <router-link to="/index/emp">员工信息列表 </router-link>
              <router-link to="/index/dept">部门信息列表 </router-link>
    
              <router-view/>
          </div>
      </template>
    
      <script>
          export default {
              name: "Index"
          }
      </script>
    
      <style scoped>
    
      </style>
      ```

## 08-路由守卫或者路由钩子

+ 路由对象起作用的时候，也就是通过路由进入某个页面或者离开某个页面时触发的一些函数

+ 路由钩子的实现
  + 全局路由，添加在全局路由对象上，router目录下的index.js

  + ```
    const router = new VueRouter({
      routes
    })
    /*全局路由*/
    //每当路由切换时触发
    router.afterEach((to,from) => {
      //to要去的目标位置
      //from来自于哪个位置
      console.log(to)
      console.log(from)
    })

    router.beforeEach((to,from))=>{}
    ```

    + 只要有路径切换，就会触发这两个钩子方法

  + 组件内路由钩子，声明在某个组件中，只针对该组件生效

  + ```
    export default {
        name: "Index",
    //    组件内的路由钩子
    //    只针对当前路由生效
        beforeRouteEnter(to,from,next){
            /*进入当前页面之前触发*/
            /*to代表目标位置*/
            /*from代表从哪里来*/
            /*next（）,如果要方行当前路由，就执行next，否则不执行*/
            /*console.log(to)
            console.log(from)*/
            /*放行*/
            next()

        },
        beforeRouteUpdate(to,from,next){
            /*浏览器路径发生变化，但是依然进入该组件*/
        //    比如先通过/index/admin进入到了该组件，
            /*后来又通过/index/张三进入到了该组件，那么会触发该钩子函数*/

        },
        beforeRouteLeave(to,from,next){
            console.log(to)
            console.log(from)
            next()
        }
    }
    ```

  + 单个路由钩子，声明在路由对象中

    + ```js
      {
        path: '/home',
        name: 'home',
        component: HomeView,
        beforeEnter:(to,from,next) =>{
          /*进入/hoem路径前触发*/
          next()
        }
      },
      ```

+ 路由钩子的应用场景，

  + 前置守卫，进入某个路由之前触发的，一般用于进行用户的登录验证
  + 后置守卫，离开某个路由之前，一般用于数据的保存提示
  + 更新守卫，一般用在查询功能上，不同查询条件进入同一个组件时触发，用于查询时的特殊处理

+ 路由钩子获取路由对象的meta信息

  + 在路由对象上维护meta信息

  + ```js
      {
        path:'/',
      //  重定向到/home路径上
        redirect:'/home'
      },
      {
        path: '/home',
        name: 'home',
        component: HomeView,
        beforeEnter:(to,from,next) =>{
          /*进入/hoem路径前触发*/
          next()
        },
        meta:{
          title:"主页",

        }
      },
      {
        path: '/about',
        name: 'about',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: function () {
          return import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
        },
        meta:{
          title:"关于我们"
        }
      }
    ]
    ```

  + 在全局路由钩子中，获取meta信息值，进行相应的处理

  + ```js
    const router = new VueRouter({
      routes
    })
    /*全局路由*/
    //每当路由切换时触发
    router.afterEach((to,from,next) => {
      //to要去的目标位置
      //from来自于哪个位置
      console.log(to)
      console.log(from)
      //获取每个路由的meta信息，赋值给浏览器的标题信息
      window.document.title = to.meta && (to.meta.title || '默认')
      next()//特殊操作后自动拦截
    })

    ```

  + ​