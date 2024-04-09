//该文件专门用于创建整个应用的路由器
import VueRouter from "vue-router"
import About from "../components/HelloWorld"
import Test from "../components/TestPageVue"

const router = new VueRouter({
    routes:[
        {path:"/about/:id/:msg",//使用占位符，接收params参数，不常用，这时侯不能使用别名
        component:About,
        name:"guanyu",//别名   除了使用path,也能使用别名， :to={name:"guanyu"}
        meta:{isAuth:true},//meta，路由元信息，自定义
            //独享路由守卫
            beforeEnter:(to,from,next)=>{
            next()
            }
        },
        {path:"/test",
        component: Test,
        children:[
            {
                path:"news",//子路由不需要加 /
                component:About,//使用时路径要写全。
            },
            {
             path:"msg",
             component:Test,
                //props的第一种写法，值为对象
                // props:{a:1,b:"hello"},//传给对应组件，死数据屁用没有
                //props的第二种写法,布尔值,如果为true,
                // props:true,//只能将params参数变成props传给组件，也没啥用
                props($route){
                 return {id:$route.id,title:$route.title}
                }//第三种写法，值为函数,接收参数可以使用嵌套解构赋值

            }
        ]},
    ]
})
//全局前置路由守卫———每次路由切换和初始化被调用
router.beforeEach((to,from,next)=>{
 /*   if (!to.meta.isAuto){
        return;
    }*/
    next();
})

//后置路由守卫
router.afterEach()((to,from)=>{
    if (!to.meta.isAuto){
        // return;
    }
    document.title = to.meta.title || "尚硅谷";
})






export default router;



