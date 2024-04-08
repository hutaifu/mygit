## Vue框架

+ vue是一个前端框架，封装了原生的js代码。类似jQuery框架和layui框架。
+ 依然用于实现原生js的功能
  + 实现页面的动态效果。
  + 实现表单验证。
  + Vue框架还实现了数据的前台渲染和页面的切换功能。
+ 当前项目结构
  + index.html入口页面
    + 该页面中嵌入了app.view根组件
    + App.view中又嵌入了Homeview.view子数件
      + 在Homeview.view子组件又潜入了HelloWorld.view子组件。
+ 浏览器要显示的页面，比如登陆页面，注册页面，列表展示页面，我们放在views目录下。相当于jsp页面。
+ 如果是要显示在独立完整的页面中作为一个局部功能展示的话，一般我们放在components目录下。相当于jsp引入的部分内容。

### 01、vue指令

+ 回顾，js中通过js代码实现div的内容显示设置innerHtml值

  + document.getElementById("div").innerHTML = "动态值"
  + $("#div").html("动态值")

+ vue的实现方式

  + 首先去定义数据，js中的变量

  + ```
    <script>
    <!--  js代码部分-->
    // @ is an alias to /src
    import HelloWorld from '@/components/HelloWorld.vue'

    export default {
      /*当前这个vue组件，这个文件，可以看成是一个对象*/
      name: 'HomeView',
      //当前vue组件的name属性值
      /*ES6方式声明一个匿名函数*/
      data(){
        /*本质就是js中变量声明操作，全局变量，在当前组件任意位置都能使用*/
        return{
          /*以trturn值的形式返回这个组件所拥有的数据js中声明变量var msg = "Hello vue"*/
          msg:"Hello Vue",
          sname:"张三"

        }
    }
      /*components: {
        HelloWorld
      }*/
    }
    ```

    + 在data中以返回值方式定义所有的数据，可以是任意类型，比如string，number、boolean、对象类型、数组

  + 直接在页面中html标签位置通过vue提供的语法方式去应用data中的数据

  + ```
    <template>
    <!--  html标签部分-->
      <div class="home">
    <!--    <img alt="Vue logo" src="../assets/logo.png">-->
    <!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
        <!--双大括号的作用，就是将js中定义的变量显示在html中-->
        <div>{{msg}}}</div>
        <div>{{sname}}}</div>
    ```




      </div>
    </template>
    ​```
    
    + {{}}vue中的插值表达式，用于引用data数据，展示到页面中，替代了原先的innerHTML属性设置。

  + js中的动态操作

    + 动态设置标签的innerHTML属性，jQuery中用html（）
    + 动态设置标签的innerText属性，jQuery用text（）
    + 动态设置标签的某个属性，比如样式style，或者图片的src属性，atr（）  css（）
    + 动态设置或者得到input的value属性值，jQuery中用到式val（）方法。
    + 动态给元素设置点击事件
    + js中实现页面元素的隐藏和显示：display，show（），hide（）

  + 以上功能在vue中完全不同的语法实现，比如{{}}替代了innerHTMl的赋值

    + vue指令就是vue提供的可以实现上面功能的语法形式。

  + 设置文本或者html显示

    + v-html 用于将js中的变量设置到某个标签的innerhtml属性上
      + 会识别到其中的标签内容，然后在浏览器上渲染
    + v-text 用于将js中的变量设置到某个标签的innerText属性上
      + 不会识别标签内容，都会以字符在形式出现
      + 插值表达式作用等同

  + v-bind:用于将js中的变量设置到某个标签的任意属性上，相当于jQuery中的attr

  + 比如class name id type src等等

  + ```
    <!--动态给标签某个属性赋值-->
    <p v-bind:class="clsName">段落文本</p>
    <!--v-bind语法糖，就是简写-->
    <p :class="clsName">段落文本2</p>
    <p class="red"></p>
    ```

  + ```
    data(){
      /*本质就是js中变量声明操作，全局变量，在当前组件任意位置都能使用*/
      return{
        /*以trturn值的形式返回这个组件所拥有的数据js中声明变量var msg = "Hello vue"*/
        msg:"<h1>Hello Vue</h1>",
        sname:"张三",
          /*将cslName变量赋值给p标签的class属性*/
          clsName:"red",

      }
    }
    ```

  + v-model：用于将js中的变量绑定到表单元素的value上

  + ```
         <!--将sname这个变量绑定到input的value属性值上-->
       ```
    <!--      v-model是双向绑定的，js中变量发生变化会体现在页面中，页面中value发生变化，也会重写给js中的变量赋值-->
          <input type="text" v-model="sname" >
          <h4>{{sname}}}</h4>
    ​```

  + v-model实现了数据的双向绑定，v-bind是单向绑定，v-bind用于绑定普通属性，v-model用于绑定value值。

  + 双向绑定，js中的变量如果发生变化，那么页面也会随之改变

    + 反过来，页面中我们修改了input的值，或者切换了下拉框的选中项，或者切换了单选纽的选中值，都会重新给js终端 绑定变量赋值。d

    + v-on:用于将vue组件中声明的方法绑定页面的元素的响应事件

      + 首先在vue组件中声明methods属性，和data同级别，用于存放所有的全局函数

      + ```
        methods:{
            /*声明js中所有的全局函数，相当于以前的function函数*/
            show() {
                alert("hello vue")
                /*访问当前vue对象中的data数据*/
                alert(this.sname)
            },
            show02(){
                let msg = "hello"
                alert(this.msg)
            },
            add(){
                this.count ++
            }

        }
        ```

      + 再页面中通过v-on指令绑定到某个标签的响应事件上

      + ```
              <!--v-on之类用于绑定事件-->
              <button v-on:click="show">点击一下</button>
              <input type="text" v-model="count">
            <!--      v-on简写-->
              <button @click="add">count++</button>
              <h4>{{count}}</h4>
          ```
        ```

      + 其他事件，@change，@blur，@focus
        ```

    + 在methods方法中可以实现任意代码，

      + 如果要访问当前组件中的data数据时，需要添加this关键字作为关键字
      + 同时也可以访问其他的函数，也需要加this关键字

    + v-if

    + v-show都是根据vue组件中的布尔变量决定是否要隐藏或者显示页面元素

    + ```
      data(){
        /*本质就是js中变量声明操作，全局变量，在当前组件任意位置都能使用*/
        return{
            isShow:false,

        }
      },
      ```

    + ```
      <!--      根据isShow的值决定是否要显示当前元素-->
            <div v-if="isShow">这是要隐藏的元素</div>
            <div v-show="isShow">这是要隐藏的元素</div>
            <button @click="showOrHide">切换</button>
      ```

    + ```
      methods:{
          /*声明js中所有的全局函数，相当于以前的function函数*/
          showOrHide(){
              this.isShow = !this.isShow
          }

      }
      ```

      + 当布尔值为true，那么元素显示，否则元素隐藏。

      + 区别：

        + v-if控制元素显隐，是通过创建这个dom元素或者整体移除这个dom元素实现
        + v-show控制元素显隐，是通过当前元素的diplay实现的。
        + 如果需要频繁切换显示隐藏时，使用v-show指令，否则使用v-if，v-if在初始渲染时比v-show效率较高，因为它不需要加载display属性。

      + v-if和v-else可以实现二选一的分置结构

      + ```
        <!--      根据isShow的值决定是否要显示当前元素-->
              <div v-if="isShow">这是要隐藏的元素</div>
              <!--如果v-if条件不成立，显示else-->
              <div v-else>这是另外一个元素</div>
        ```

    + v-for用于对data中的对象或者数组进行遍历，在页面中重复渲染某个标签

    + ```html
            <select v-model="saddress">
          <!--          address是data中的一个数组对象，city代表的是其中每一个城市对象-->
                <option v-for="city in address" :value="city.cid">{{city.cname}}</option>
            </select>
            <h4>{{saddress}}</h4>
        ```
      ```

    + ```js
      data(){
        /*本质就是js中变量声明操作，全局变量，在当前组件任意位置都能使用*/
        return{
            address:[
                {cid:1,cname:"济南"},
                {cid:2,cname:"青岛"},
                {cid:3,cname:"烟台"},
            ]
        }
      },
      ```

    + 在html中循环该数组，实现标签的加载，

    + 下拉框的应用：

      + v-model绑定的是js中的data变量，代表的是当前用户所选中的下拉框的value值

      + 页面中切换下拉选项时，saddress的就会发生变化

      + 也通过在js中给saddress赋值，来控制默认选的哪一个option

      + saddress就是我们要提交到后天的数据

      + 小任务：性别单选钮如果绑定？？？

      + 其他遍历方式

      + ```
        data(){
          /*本质就是js中变量声明操作，全局变量，在当前组件任意位置都能使用*/
          return{
              strs:["one","two","three"],
              studet:{name:"张三",age:18}

          }
        }
        ```

      + ```
              <ul>
                  <!--nums代表数组元素，i代表数组下标，从零开始-->
                  <li v-for="(nums,i) in strs">{{i}}-----{{nums}}</li>
              </ul>
            <!--      value代表属性值，name代表属性名-->
              <p v-for="(value,name) in studet">{{name}}:{{value}}</p>
          ```
        ```

      + v-for中key属性的使用

      + ```
             <select v-model="saddress">
        <!--          address是data中的一个数组对象，city代表的是其中每一个城市对象-->
                  <option v-for="city in address" :value="city.cid" :key="city.cid">{{city.cname}}</option>
              </select>
        ```

      + 在使用了v-for指令的标签中才能使用key属性，

      + key可以看成option的唯一标识，不允许重复，类似于id或者主键

      + 作用：

        + 不使用key属性时，那么当我们address对象数据中的值发生变化时，option标签的加载会采取就地更新策略，把原先第一个济南的option改查淄博，然后第二个改查济南，依此类推，就地更新出策略会影响原来option
        + 使用key属性，每个option都有自己的标识，当数组发生变化时，比如在第一个位置增加了一个元素值，那么vue内部会新建一个option对象，插入到下拉框第一个位置上，对原先的option没有任何影响。
        + 推荐添加key属性，默认绑定为对象的id即可。

### 02、计算属性

+ 计算属性一般用于简单的函数

  + 单纯用于处理某个变量并得到结果的函数可以声明为计算属性

  + 计算属性可以作为变量在页面中直接引用，

  + ```
    computed:{
    //  计算属性
        /*一般用于对某个变量进行操作，得到结果展示到页面当中*/
        //必须将结果以return形式返回
        reverseStr(){
            return this.text.split(",").reverse().join(",")
        }
    ```

  + ```
    methods:{
        /*声明js中所有的全局函数，相当于以前的function函数*/

        changeStr(){
            return this.chgText = this.text.split(",").reverse().join(",")
        }

    },
    ```

  + ```
    <p>{{text.split(',').reverse().join(',')}}</p>
    <!--      引用函数,两个p标签会调用两次方法-->
          <p>{{changeStr()}}</p>
          <p>{{changeStr()}}</p>
          <!--引用计算属性，只会调用一次计算属性，计算属性会把结果储存到缓存，之后再次使用，回去拿缓冲结果-->
    <!--      只有text发生属性时，计算属性才会重写执行-->
          <p>{{reverseStr}}</p>
          <p>{{reverseStr}}</p>
    ```

  + 计算属性和函数的区别

    + 函数重复调用出现时，就是会重复执行
    + 计算属性在重复出现时，不会重复执行，执行一次后，将结果缓存
      + 除非计算属性中的变量发生变化了，计算属性才会重新执行。

### 03-侦听器

+ 用于侦听data中数据的变化，类似于js中的onchagne方法

+ ```
  watch:{
  //  侦听器
  //    用于侦听data中某个变量的变化
      changeName(){
          /*以变量名作为当前函数名称，只要变量发生变化，当前函数就会被触发*/
          alert("发生变化")
      }
  }
  ```

+ 侦听器的名称要和变量名一致

### 04、Vue的设计模式/核心思想

+ MVVM设计模式
  + M model ，模型，数据模型，指的是我们声明在vue组件中所有的资源信息，
  + 包括data，methods函数，计算属性computed,侦听器watch，
  + V：view，视图，代表的是整个html结构，也就是页面要显示的内容
  + VM：viewModel对象，这是vue本身提供的类似于控制器的角色，它的作用是负责根据我们提供的各种指令，将model中的数据渲染到view页面中，或者同时负责将页面中的信息修改重新赋值会model中的数据。
    + VM和页面进行了一个数据的绑定，databind，是一个双向的绑定
  + 和后台的MVC设计模式非常类似，前台vue实现js动态效果的本质就是页面显示data数据，或者页面修改daga数据。