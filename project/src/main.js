import Vue from 'vue/dist/vue'
import App from './App.vue'
// import js from "./js/请求"
import Com from "./router/TestCom"
import VueRouter from "vue-router"
import router from "./router/index"
// js.getChannels();
//引入Element-UI
import ElementUI from "element-ui"
//引入Element-UI的全部样式
import 'element-ui/lib/theme-chalk/index.css'
Vue.config.productionTip = false
//引用ElementUI
Vue.use(ElementUI);

//应用插件
Vue.use(VueRouter);

/*new Vue({
  render: h => h(App),
}).$mount('#app')*/

new Vue({
  render(h) {
    return h(Com)
  },
  el:"#app",
  router:router
})
