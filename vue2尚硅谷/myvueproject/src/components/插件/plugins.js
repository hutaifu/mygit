export default{
    install(Vue){
        console.log("@@@install")
        //全局过滤器
        Vue.filter('myfilter',function(value){

        })
        //定义全局指令
        Vue.directive('fbind',{

        })

        //定义混入
        Vue.mixin({})

        //vue原型添加方法
        Vue.prototype.hello = ()=>{
            
        }



    }
}
