## Vue组件

### 01、Vue组件的概念及作用

+ 使用了vue之后，这个前端是一个单页面的应用，只有一个index.html入口页面。
+ 原生web项目中，会有很多jsp，htlm文件，对应vue项目，就是一个个vue组件文件，
+ login.vue对应原先的login.jsp
  + 组件的作用就是完成一个个浏览器页面，用来拆分代码量。
  + 如果某些页面中，有些布局或者内容会重复出现，那么可以把这一部分内容封装为一个组件，嵌入到其他组件中。

### 02、vue组建的创建

+ 右键单击之间选择创建vue component组件文件
+ 前台项目可以创建组件的位置
  + views目录
    + 该目录下创建的组件对应的是浏览器上的一个页面，比如一个登陆一个注册
    + 组建的访问或者切换通过路由对象负责。
  + components目录
    + 该目录下创建的组件一般用于复用在其他的大组件上，代表可复用的局部内容。
    + 访问或者切换，直接在vue组件中引用，并应用展示。

### 03、组建的组成

+ HTML部分：

  + 当前这个组件要展示的内容，html元素

  + 必须放在组建的template标签，

  + 每个模板标签下，只能有一个唯一的跟标签

  + ```html
    <template>
      <div class="home">
        <img alt="Vue logo" src="../assets/logo.png">
        <HelloWorld msg="Welcome to Your Vue.js App"/>
      </div>
    </template>
    ```

    + template下只能有一个div

+ JavaScript部分：

  + 在js部分，我们首先会定义最外层的一个对象，代表的当前这个vue组件对象

  + 在对象中定义该对象所以拥有的数据和方法等资源信息，这些资源信息都可以应用到当前组建的html元素上

  + ```
    <script>

    //js代码部分
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
          msg:"<h1>Hello Vue</h1>",
          sname:"张三",
            /*将cslName变量赋值给p标签的class属性*/
            clsName:"red",
            count:1,
            isShow:false,
            address:[
                {cid:1,cname:"济南"},
                {cid:2,cname:"青岛"},
                {cid:3,cname:"烟台"},
            ],
            saddress:2,
            strs:["one","two","three"],
            studet:{name:"张三",age:18},
            text:"你好,Vue",
            chgText:"",
            changeName:"",

        }
      },
      methods:{
          /*声明js中所有的全局函数，相当于以前的function函数*/
          show() {
              alert("hello vue")
              /*访问当前vue对象中的data数据*/
              alert(this.sname)
              this.show02()
          },
          show02(){
              let msg = "hello"
              alert(this.msg)
          },
          add(){
              this.count ++
          },
          showOrHide(){
              this.isShow = !this.isShow
          },
          changeStr(){
              return this.chgText = this.text.split(",").reverse().join(",")
          }

      },
        computed:{
        //  计算属性
            /*一般用于对某个变量进行操作，得到结果展示到页面当中*/
            //必须将结果以return形式返回
            reverseStr(){
                return this.text.split(",").reverse().join(",")
            }
        },
        watch:{
        //  侦听器
        //    用于侦听data中某个变量的变化
            changeName(){
                /*以变量名作为当前函数名称，只要变量发生变化，当前函数就会被触发*/
                alert("发生变化")
            }
    ```



        }
    /*  components: {
        HelloWorld
      }*/
    }
    
    </script>
    ​```
    
    + data数据的声明：
    + data：function（）{}    ====ES6语法：data（）{}
    + data中所有的数据都要以return返回值的方式返回
    + return{}
    + methods中所有的的方法都采用ES6语法方式
      + show（){}

+ css样式

  + ```
    <style>
      /*样式部分*/
        .red{
            color: red;
        }
    </style>
    ```

  + 用于修改页面显示

  + 放在当前vue组件的最后

### 04、组件的使用

+ ES6中的莫块化编程

  + 可以将js中的一个方法或者是一个js文件看成是一个单独的模块，vue中一个组件文件也可以就看成一个模块。

  + 我们可以在大模块中引入小模块引用钱我们要保证小模块是对外可见的。把小模块暴露出来，在语法中实现就是利用export关键字

  + 比如，将小组件到处或者暴露出来

  + ```
    <script>
    export default {
      name: 'HelloWorld',
      props: {
        msg: String
      }
    }
    </script>
    ```

  + export default：将当前这个vue组件对象，导出了，或者暴露出去

  + 默认导出，代表当前的模块没有名字

  + 我们在一个大的组件中引入该模块，引用这个Hello World组件，需要先进行导入进来

  + 导入使用import命令

  + ```
    // @ is an alias to /src
    import HelloWorld from '@/components/HelloWorld.vue'
    ```

  + ```
    export function checkAnswer(data) {
      return hussarRequest.postJson('/getBackPwdFront/validateKey',data);
    }
    ```

  + 在模块化编程中，任意的内容都可以进行导入导出操作，比如一个变量，一个方法，设置一个完整的vue组件页面，

  + js文件中方法的导入导出，

  + ```
    import { LoginApi } from "@/api/loginApi";
    ```

  + 本质功能就是资源的引用，就是以前我们通过scrip标签引入js文件，现在通过export和import关键字实现

+ 组件的使用

  + 小组件在大组件中展示

    + 导出小组件

    + ```
      <script>
      export default {
        name: 'HelloWorld',
        props: {
          msg: String
        }
      }
      </script>
      ```

    + 在大组件中导入，并给这个模块定义名字

    + ```
      // @ is an alias to /src
      import HelloWorld from '@/components/HelloWorld.vue'
      ```

    + 将小组件在大组件中注册一下

    + components属性用于注册引入了一个组件

    + 本质作用就是告诉viewMode引入了一个组件

  + 在html结构中使用，也就是展示这个组件的内容

  + ```
    <!--    引用了HelloWord组件-->
        <HelloWorld msg="Welcome to Your Vue.js App"/>
    ```

### 05-组件的切换

+ 在一个大的组件中，实现两个小组件的现实切换。

  + 本质就是组件的隐藏和显示

+ 创建登录和注册组件

+ ```
  <template>
      <div>
          <h3>{{msg}}</h3>
      </div>
  </template>

  <script>
      export default {
          name: "Login",
          data(){
              return{
                  msg:"这是登录组件",
              }
          }
      }
  </script>

  <style scoped>

  </style>
  ```

+ 在父组件中引入组件，再注册

+ ```html
  <template>
    <div class="home">
    <!--  <img alt="Vue logo" src="../assets/logo.png">
  &lt;!&ndash;    引用了HelloWord组件&ndash;&gt;
      <HelloWorld msg="Welcome to Your Vue.js App"/>
      <HelloWorld msg="你好 view"/>-->
      <button @click="chg02">切换</button>
  <!--    <div v-if="flag">
      <Login></Login>
      </div>
      <div v-else>
        <rejster></rejster>
      </div>-->
  <!--    显示组建的其他方式-->
      <div>
  <!--      该标签相当于父组件中的一个占位符，用于展示某个子组件-->
        <component :is="comName"></component>
      </div>
    </div>
  </template>

  <script>
  // @ is an alias to /src
  import HelloWorld from '@/components/HelloWorld.vue'
  import Login from '@/components/Login.vue'
  import rejster from '@/components/rejster.vue'

  export default {
    name: 'HomeView',
    components: {
      HelloWorld,
      Login,
      rejster
    },
    data(){
      return{
        flag:true,
        comName:"Login"
      }
    },
    methods:{
      chg(){
       /* this.flag = !this.flag*/
      },
      chg02(){
        if (this.comName == 'Login'){
          this.comName = "rejster"
        } else {
          this.comName = "Login"
        }
      }
    }
  }
  </script>
  ```

+ 方式一：通过v-if和v-show的指令实现组件的切换

+ chg方法用于改变flag变量的值。

+ 方式二：通过component表签展示子组件并切换

+ is属性用于指定要显示的子组件的名称

+ 通过修改is属性绑定的变量的值来控制子组件的显示。

### 06-组件间的通信

+ 组件之间的传参

  + 父组件可以给子组件传参
  + 子组件也可以给父组件传参

+ 父组件给子组件传参

  + 一个子组件可能会用在多个父组件当中，

  + 但是在不同的父组件中显示的内容可能会不同，一般内容都是根据父组件的应用场景决定的

  + 我们可以创建一个可以接受父组件参数的子组件，父组件传递过来什么参数，子组件就显示什么内容

  + 实现步骤

    + 在父组件中引用子组件时，通过自定义的属性进行参数的传递

    + ```
      <!--    父组件引用子组件-->
      <!--    通过自定义的属性实现向子组件的传参-->
          <Mybutton label="登录" msg="这是登录按钮"></Mybutton>
          <Mybutton label="注册"msg="这是注册按钮"></Mybutton>
      ```

    + label和msg都是自定义属性

    + 再子组件中通过props属性接收参数

    + ```
      <script>
          export default {
              name: "Mybutton",
              /*props属性用于接收父组件传递过来的值*/
              props:{
                  /*变量名要和负组件中自定义的属性名完全一致*/
                  /*这个label的使用和data中的数据完全相同*/
                  label:'',
                  msg:''
              }
          }
      </script>
      ```

    + 变量名称和自定义属性名称一致

    + 接收后作为数据直接使用即可

  + 父组件给子组件传递一个动态值

    + 通过input文本框，输入内容，将这个内容传递给子组件，

    + ```
      <!--    父组件引用子组件-->
      <!--    通过自定义的属性实现向子组件的传参-->
          <input type="text" v-model="conte">
          <Mybutton :label="conte" msg="这是登录按钮"></Mybutton>
          <Mybutton label="注册"msg="这是注册按钮"></Mybutton>
      ```

    + 通过v-model绑定变量，再将这个变量绑定到label属性上。

+ 子组件给父组件传递参数

  + 在父组件引入子组件的位置，定义自定义的事件

  + ```
    <!--    自定义一个事件-->
        <MyCal @getSum="add"></MyCal>
        {{}}
    ```

  + 该自定义事件出发的函数要接受一个参数，这个参数负责接收子组件传底过来的值

  + ```
    add(sumno){
    //  用于接收子组件传递过来的和
      alert(sumno)
    ```

  + 子组件中取出发福组建的自定义事件

  + ```
    sum(){
        let sumNum = parseInt(this.num1) + parseInt(this.num2)
        //把sumMum传给父组件
        //用于触发父组件的自定义事件
        //sumNum变量会作为参数传递给父组件的add方法
        this.$emit("getSum",sumNum)
    }
    ```

    + $emit方法的第一个参数代表的是父组件的事件名称
    + 第二个参数代表的是要传递给父组件的数据
    + 该数据会被负组件中的add方法接收到

### 07-组件的插槽

+ 默认情况下，我们在父组件中引用子组件，页面你只会显示子组件本身的html内容，

+ 如果我们在父组件中的引入处添加了其他的html结果，那么页面并不会显示内容

+ h4标题并不会显示在页面中

+ 这样导致，子组件应用是，无法前任让你和的子标签，样式的内容具有一定的局限性。

+ 插槽

  + 在子组件中设置插槽的作用，就是用于显示父组件中的静态html内容。
  + 相当于给子组件添加了一个占位符，使其能够显示更多的内容，具有更大的扩展性
  + slot，分发，就是将父组件的静态文件内容分发到子组件的某个位置上。
  + 父组件的内容就是先是在slot插槽的位置。slot在什么地方，父组件就显示在什么地方。
  + 这个slot可以显示父组件中指定的所有静态html。
  + 这个插槽没有name，我们称之为匿名插槽。

+ 具名插槽

  + 在子组件中可以定义多个插槽，并指定name属性。

  + ```
       <div>
            <slot name="top"></slot>
            <h4>这是子组件的内容</h4>
    <!--        插槽，作用就是占用一个位置，显示父组件的内容-->
            <slot name="bottom"></slot>
        </div>
    ```

  + 父组件中去设置静态内容时可以通过slot属性显示对应的位置

  + ```
    <MySlot><h4 slot="top">这是父组件的内容1</h4>
      <h4 slot="bottom">这是父组件的内容2</h4>
    </MySlot>
    ```

+ 作用域插槽

  + 可以通过作用域插槽向父组件传递数据

  + 在子组件的slot插槽中，通过自定义值属性值或者绑定变量

  + ```
    <!--        作用域插槽-->
            <slot name="msgSlot" msg="hello 我是子组件的内容" text="你好"></slot>
    ```

  + 父组件中通过slot-scope的属性接受传递过来的值

  + ```
        <MySlot><h4 slot="top">这是父组件的内容1</h4>
          <h4 slot="bottom">这是父组件的内容2</h4>
    <!--      slot-scope用于接收作用域插槽传递过来的数据-->
    <!--      自定义一个名子即可，代表的是作用域插槽传递过来的全部数据-->
          <h4 slot="msgSlot" slot-scope="slotdata">
            <template >
            {{slotdata.msg}}
              {{slotdata.text}}
            </template>
          </h4>
        </MySlot>
    ```

  + <template>用于展示插槽传递过来的值

  + 可以利用作用域插槽实现原生html标签的封装

    + 通过父组件给子组件传递数据

    + ```
      <MySelect :sdata="address">
        <template slot-scope="cdata">
          <option value="cdata.cid">{{cdata.cname}}</option>
        </template>
      </MySelect>
      ```

    + 在子组件中接受address数据

    + ```
      <template>
          <div>
              <select name="" id="">
      <!--            <slot>对应的是父组件中的option标签-->
                  <slot v-for="city in sdata" :cid="city.cid" :cname="city.cname"></slot>
              </select>
          </div>
      </template>

      <script>
          export default {
              name: "MySelect",
              props:{
                  sdata:[]
              }
          }
      </script>

      <style scoped>

      </style>
      ```

    + 在子组件中通过接收到的数组数据，对slot插槽进行循环渲染

    + 再通过插槽的自定义数据将城市的基本信息传递回父组件

  + 在负组件中通过option标签展示传回来的城市信息

### 08-vue的声明周期

+ Vue对象或者是vue组件对象的声明周期

+ 分别从创建，编译到更新到销毁的一系列阶段。

+ 整个项目，在main.js中通过new Vue（）创建了一个Vue对象，这个对象也可以定义数据或者方法，用在整个index.html。

+ 每个页面又可以看成是vue组件对象。

+ Vue和Vue组件对象都有各自的声明周期。

  + 主要包含四个阶段
    + 创建阶段，
    + 编译阶段
    + 更新阶段，只要代码更新，就会进入更新阶段。
    + 销毁阶段

+ 每个生命周期阶段都会自动执行vue对象或者组件对象的一些方法

  + 这些方法我们统一叫做生命周期钩子或者钩子函数
  + 创建阶段
    + beforecreate（）还未创建对象时执行
    + created（）对象创建完成后执行的，data数据methods方法，都在内存中被加载了

+ 编译阶段

  + beforemount（）还没有开始编译
  + mounted（）编译玩成后执行。要么全部渲染完成。

+ 更新阶段

  + beforeupdata（）代码更新之前执行
  + updated（）代码更新完成执行

+ 销毁阶段

  + beforeDestroy（），销毁之前执行的
  + destroyed（）销毁后执行

+ 钩子函数的使用

  + 我们可以在钩子函数中去执行一些页面加载完成后要完成的事情

  + 原生js中window.onload或者layui.use中的代码

  + 直接在组件对象中显式编写钩子函数即可

  + ```
    export default{
      name:"hello",
      data(){},
      methods:{},
      created(){
       //数据的访问或者方法的调用 
       this.cal();
      },
      mounted(){
        this.cal();
        //可以对页面元素进行处理
      }
    }
    ```

  + ​