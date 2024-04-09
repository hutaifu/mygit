import Vuex from 'vuex'
//准备一个action,用于响应组件的动作
import Vue from 'vue';
//使用插件
Vue.use(Vuex)
const actions = {
    jia(miniStore,value){
//第一个参数，阉割版Store实例
//第二个参数，dispatch传的参数
        miniStore.commit("JIA",value)
        console.log("触发了加")
    }
}

//准备mutations--用于操作数据
const mutations = {
    JIA(state,value){
        console.log("mutation中的加")
        state.sum = value;
    }
};

//准备一个state,用于存储数据
const state = {
    value:0,
}
export default new Vuex.Store(
    actions,
    mutations,
    state,
);
