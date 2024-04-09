import Vue from "vue";

// let Demo = Vue.extend({})
// Vue.prototype.$x = new Vue Demo();
new Vue({
    beforeCreate() {
        Vue.prototype.$bus = this//安装全局事件总线
        //注意注册事件的组件销毁，需要移除bus注册的事件，
        //注意名称的冲突，使用配置文件记录一下事件作用
    },
}).$mount("#root")
