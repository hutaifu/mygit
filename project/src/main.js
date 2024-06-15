import Vue from 'vue'
import App from './App.vue'
// import js from "./js/请求"
/*import Com from "./router/TestCom"
import VueRouter from "vue-router"
import router from "./router/index"*/
// js.getChannels();
//引入Element-UI//完整引入

/*import ElementUI from "element-ui"
//引入Element-UI的全部样式
import 'element-ui/lib/theme-chalk/index.css'
//引用ElementUI
Vue.use(ElementUI);*/

//按需引入
import { Button, Select,Input} from 'element-ui';
Vue.component(Button.name, Button);
Vue.component(Select.name, Select);
Vue.component(Input.name,Input)
/* 或写为
 * Vue.use(Button)
 * Vue.use(Select)
 */




Vue.config.productionTip = false

//应用插件
// Vue.use(VueRouter);

new Vue({
  render: h => h(App),
}).$mount('#app')



/*new Vue({
  render(h) {
    return h(Com)
  },
  el:"#app",
  router:router
})*/
