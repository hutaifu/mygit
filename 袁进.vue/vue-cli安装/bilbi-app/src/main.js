import Vue from 'vue'
import App from './App.vue'
import getdata from './请求/getdata'

Vue.config.productionTip = false
Vue.config.devtools = true

getdata.getdata()


new Vue({
  render: h => h(App),
}).$mount('#app')
