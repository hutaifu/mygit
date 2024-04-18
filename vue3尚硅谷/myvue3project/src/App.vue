<template>
    <!--  vue3组件中的模板结构可以没有跟标签，因为增加了虚拟根节点-->
      <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App" sklsf="skldfjl" @myClick="showHello"><p>slkdjklsjfd</p>
    <template #akdf>
        sjdlsjf
    </template>

    </HelloWorld>
    <h1>一个人的信息</h1>
    <h2>姓名：{{name}}</h2>
    <h2>年龄：{{age}}</h2>
    <h2>性别：{{sex}}</h2>
    <h3>工作种类：{{job.type}}</h3>
    <h3>工作薪水：{{job.salary}}</h3>
    <button @click="sayWelcome">欢迎</button>
    <button @click="sayHello">讲话</button>
    <button @click="chnageInfo">修改人的信息</button>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'
    import {h} from "vue"
    import {ref,reactive} from 'vue'

    export default {
        name: 'App',
        components: {
            HelloWorld
        },
        //vue2中data只能是函数
        data() {
            return {
                sex: "男"
            }
        },
        methods: {
            sayWelcome() {
                alert("欢迎" + this.sex)
                console.log(this)
                //vue2中能够读取vue3中的配置
            }
        },
        //此处只是测试setup,暂时不考虑响应式
        setup() {
            //数据
            let name = ref("张三")
            let age = ref(18);
            //基本数据类型底层实现还是属性定义
            let job = ref({
                type:"前端工程师",
                salary:'30K'
            })
            //对象属性的监听底层实现响应的是proxy
            //ref接收的数据是对象类型时，这个对象内部的监听内部使用了reactive函数，
            //reactive函数，
            //作用：定义一个对象类型的响应式数据，内部基于es6的proxy实现
            job = reactive({
                type:"前端工程师",
                salary:'30K'
            })
            //使用reactive处理数组，直接修改索引值也能触发响应式

            let person = reactive({
                name:'张三',
                age:18,
                job:{
                    type:"测试",
                    salary:"jsklf",
                },
                hobby:["吸烟","喝酒","套头"]
            })


            //方法
            function sayHello() {
                alert(`我叫${name}，我${age}岁了，你好啊`)
                console.log(this);
                //vue3中不能读取vue2中的配置，冲突的时候以vue3为主，setup不能是async函数，
            }

            function chnageInfo() {
                // name = "李四";
                // age = 48;
                name.value = '李四'
                age.value = 48;
                // job.value.type = "被修改了"
                // job.type = "被修改了"
                job.salary = "slkdfj";
            }
            function showHello() {
                alert("你好啊，触发了父组件的事件哦")
            }

            //返回一个对象，可以再实例上面访问
            return {
                name,
                age,
                sayHello,
                chnageInfo,
                job,
                person,
                showHello
            }

            //返回一个函数，函数返回值是虚拟节点
            //      return ()=> h("h1",{},"好家伙")

        }
    }
</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
</style>
