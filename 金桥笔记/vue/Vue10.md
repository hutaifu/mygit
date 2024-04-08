# Vue项目开发

### 01-箭头函数

+ 匿名函数的定义方式

  ```javascript
  var show = function(){
      alert("hello")
  }
  
  var showName = function(name){
      console.log(name)
  }
  ```

+ 在ES6语法规范中，可以修改为箭头函数格式：

  ```javascript
  var show = () => {
      alert("hello")
  }
  
  var shwoName = (name) => {
      console.log(name)
  }
  ```

+ 说明：

  + 箭头函数其实匿名函数的简写

  + 箭头为=>

  + 箭头左侧为小括号，里面放函数的参数，没有参数就放一个空的()

  + 箭头右侧是大括号，代表方法体。

  + 当某一个方法的参数为一个function匿名函数时，我们就可以使用箭头函数替代

    ```javascript
    //表单验证validate方法需要的参数就是一个匿名函数
    this.$refs['loginForm'].validate()
    //可以写成
    this.$refs['loginForm'].validate(function(valid){
        //valid是验证结果
    })
    //箭头函数格式
    this.$refs['loginForm'].validate((valid) => {
        
    })
    
    ```

### 02-跨域访问

+ 通过js从一个8080的资源去访问另外一个端口8086上的资源，这属于跨域访问

+ 不同IP或者不同端口都属于跨域访问

+ 浏览器有个同源策略，要求js在发送请求时，只能请求同一个域的资源。

+ js的跨域访问会被浏览器的同源策略给拦截。

+ w3c提出提出跨域访问，cors机制，cross-origin resource share，在一定情况下，允许js进行跨域访问。

+ SpringMVC框架基于cors机制实现了对应的功能，允许js访问后台不同域的资源。

+ 在后台实现跨域设置，前台就可以直接访问了。

  ```java
  @Configuration
  public class CrosConfig implements WebMvcConfigurer {
      public void addCorsMappings(CorsRegistry registry){
          ///**匹配的是我们所有后台的路径，代表后台共享了什么资源
          registry.addMapping("/**")
                  //匹配的前台的服务器地址
                  .allowedOrigins("*")
                  //允许的前台的请求方式
                  .allowedMethods("GET","HEAD","POST","DELETE","OPTIONS")
                  .allowCredentials(true)
                  .maxAge(3600)
                  .allowedHeaders("*");
      }
  }
  ```

### 03-前台请求后台资源

+ 通过axios请求后台资源

+ 通过axios脱离浏览器，直接向后台发生请求，后台接收请求，并响应数据返回给axios，前台再认同返回的数据实现也也页面的展示或者切换。

+ 类似于web阶段的ajax功能。

+ axios的使用

  + 项目中安装：npm  install axios

  + 在main.js中引用,注意后台端口发生变化时，修改这里的信息

    ```javascript
    /*全局配置axios*/
    //导入axios
    import axios from 'axios';
    //设置访问根路径
    axios.defaults.baseURL='http://localhost:8086/';
    //挂载axios
    Vue.prototype.$http = axios;
    ```

  + 调用后台

    ```javascript
    this.$http.post("login",this.loginForm).then((res) => {
    
                                console.log(res)
                                if(res.data == 'success'){
                                    //存储用户名信息
                                    sessionStorage.setItem("uname",this.loginForm.uname)
    
                                    //将用户名存储到vuex的store仓库中
                                    //调用actions中方法
                                    this.$store.dispatch("saveUname",this.loginForm.uname)
    
                                    //登录成功，跳转页面
                                    this.$router.push({
                                        path:'/home'
                                    })
                                }
                            }).catch(() => {
                                this.$message.error("服务器错误")
                            })
    ```

    ```javascript
     this.$http.get("getOne/" + empno).then(res => {
                        //返回的员工对象直接赋值给empForm对象
                        this.empForm = res.data
                        //展示弹框
                        this.dialogFormVisible = true
                        //清空校验信息
                        if(this.$refs['empForm'] != undefined){
                            this.$refs['empForm'].resetFields()
                        }
                        //修改标题
                        this.formTitle = "修改员工信息"
                    })
    ```

  + axios提供了两种方法

    + get和post
    + get在路径上拼接参数即可
    + post一般以json对象或者json数组方式传递参数
    + then()方法代表后台执行成功后的回调，参数时一个箭头函数，其中res就是后台响应回的数据
    + catch()方法代表后台执行失败的回调。

### 04-Vuex

+ vue中的状态管理
  + 用于存储用户数据或者其他信息

+ vuex的使用

  + 安装 npm install vuex --save
  + store下是仓库位置

+ vuex中的属性

+ 01-state属性用于声明要存储的变量
  			const store = new Vuex.Store({
  				state:{
  					uname: null  //默认初值为null，成功登录后给其赋值
  				}
  			})

+ 02-mutations属性用于定义事件或者方法，来操作state中的数据

  + 这是修改数据的唯一入口

    ```javascript
    const store = new Vuex.Store({
    	mutations:{//定义事件，用于修改状态数据,但是他是同步操作
    	//一个参数为state，代表要修改的数据，第二个为外部传递进来的数据
    		setUser:function (state,user) {
    			//类似于java中的set方法
    			 state.uname = user;
    		}
    	},
    })
    
    //成功登录后，使用commit触发该方法，并将用户名传递进来
    //setUser为方法名称
    this.$store.commit("setUser",this.form.uname);
    
    ```

+ 03-actions属性，功能类似于mutations属性，用于定义事件操作数据

  + actions中方法参数不是state，而是mutations对象

  + 其操作也是调用mutations中的方法，类似于我们之前业务逻辑层调用dao层

    ```javascript
    const store = new Vuex.Store({
    	actions:{//功能类似于mutations，是异步操作，参数为mutations对象
    		setUser:function (context,user) { //context代表mutations对象
    			context.commit("setUser",user); //调用mutations对象的方法
    		}
    		//简写为
    		/*setUser({commit},user){
    			commit("setUser",user)
                }*/
    		}
    	})
    	//登录后的代码修改为：调用action方法
    		this.$store.dispatch("setUser",this.form.name)
    	//actions支持异步操作mutations属于同步操作
    		//登录后在列表页面显示用户名
    	<div>欢迎你，{{$store.state.uname}}</div>		
    ```

+ Store其他属性	

  + getters

    + 可以根据当前仓库中所存储的值，通过判断或者过滤得到其他的数据值并返回

    ```javascript
    getters:{
        uname:state=>{
            return state.currentUser;
        }
    }
    》获取值
    $store.getters.uname
    ```

  + modules

    + 如果我们需要集中管理的数据很多，那么store可能会很臃肿

    + 这个时候我们可以分模块

      ```javascript
      const moduleA = {
      		  state: () => ({ ... }),
      		  mutations: { ... },
      		  actions: { ... },
      		  getters: { ... }
      }
      const moduleB = {
      	  state: () => ({ ... }),
      	  mutations: { ... },
      	  actions: { ... }
      	}
      const store = new Vuex.Store({
      	modules: {
      		a: moduleA,
      		b: moduleB
      	  }
      	})
      	》使用
      	$store.state.a // -> moduleA 的状态
      	$store.state.b // -> moduleB 的状态
      ```

      

  ​		

		
## 



