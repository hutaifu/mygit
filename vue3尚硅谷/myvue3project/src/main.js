//引入的不再是vue构造函数了，引入的是一个名为createApp的工厂函数
import { createApp } from 'vue'
import App from './App.vue'

//创建应用实例对象并挂载(类似于之前vue2中的vm,vue根实例)，但是更加轻量化，没有多余的属性
createApp(App).mount('#app')
