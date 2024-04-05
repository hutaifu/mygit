import Vue from 'vue/dist/vue'
import App from './App.vue'
import js from "./js/请求"

js.getChannels();

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
