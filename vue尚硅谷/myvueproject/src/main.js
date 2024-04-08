// 该文件是整个项目的入口文件
//引入完整Vue
// import Vue from 'vue/dist/vue.js'
// 引入运行版本vue，没有模板解析器,减少打包体积，打包后不需要解析模板
import Vue from 'vue'
//引入App组件，是所有组件的父组件
import App from './App.vue'
//关闭vue的生产提示
Vue.config.productionTip = false
//创建vue的实例对象
//使用插件
import plugins from './components/插件/plugins'
Vue.use(plugins)


new Vue({
  //将App组件放入容器中
  render: h => h(App),
  // template:`<App></App>`,
  // components:{App}
  // render(createElement){
  //   let element = createElement("h1","你好啊")
  //   return element
  // }
}).$mount('#app')