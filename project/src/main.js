import Vue from 'vue/dist/vue'
import App from './App.vue'
import js from "./js/请求"
import Com from "./router/TestCom"
import VueRouter from "vue-router"
js.getChannels();

Vue.config.productionTip = false

//应用插件
Vue.use(VueRouter);

/*new Vue({
  render: h => h(App),
}).$mount('#app')*/

new Vue({
  render(h) {
    return h(Com)
  },
  el:"#app"
})
