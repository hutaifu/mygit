import App from "./App.js";
//注册组件，使用模板使用组件
// new Vue({
//     components:{
//         App,
//     },
//     template:`<App/>`
// }).$mount("#app");

//将组件作为虚拟节点传到render箭头函数里面
// new Vue({
//     render:(h) => h(App),
// }).$mount('#app')
//render函数另一种写法，es6速写属性
new Vue({
    render(h){
        return h(App)
    },
}).$mount('#app')