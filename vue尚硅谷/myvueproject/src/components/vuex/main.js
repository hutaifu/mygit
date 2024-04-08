import Vue from 'vue'
//引入App组件，是所有组件的父组件
import App from './App.vue'

// import Vuex from 'vuex'
//关闭vue的生产提示
Vue.config.productionTip = false
import store from "./store"
//使用插件
// Vue.use(Vuex)

//脚手架存在引入提升，类似预编译，但是在创建一个store之前必须要
//使用vuex插件，所有使用插件最好写在store.js里面



//创建vue的实例对象
//传入store
new Vue({
  render: h => h(App),
  store,
}).$mount('#app')