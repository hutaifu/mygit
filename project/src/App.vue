<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <div id="hello"></div>
<!--    <HelloWorld :msg="msg" ref="myRef" @click="myClick" :key="new Date().getTime().toString()" v-model="myModel" :class="myClass" id="myId">
        <p>123</p>
      <template v-slot:myslot="scope">测试具名插槽{{scope}}</template>
    </HelloWorld>-->
    <button @click="msg = '123' ">测试响应式</button>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import {addComponent} from './js/addCompoent'
import vue from 'vue'


export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data(){
    return {
      msg:"Welcome to Your Vue.js App",
      myModel:"",
      myClass:"",
    }
  },
  methods:{
    myClick(){
      console.log("触发了我的点击事件")
      alert("触发了app传递给hello的点击事件")
    }
  },
  beforeCreate(){

  },
  created(){

  },
  beforeMount(){
  },
  provide(){
    return{
      msg:this.msg
    }
  },
  mounted(){
    //使用extend
    let [mycom,proxyVue] = addComponent(this,HelloWorld,"#hello",`  <HelloWorld :msg="msg" ref="myRef" @click="myClick" :key="new Date().getTime().toString()" v-model:sk="myModel" :class="myClass" id="myId">
        <p>123</p>
        紫芜丘陵未有雪，我未执枪已十三年
           <template v-slot:myslot="scope">测试作用域插槽{{scope.myslotProp}}</template>
                  <template #myslot1="scope">测试作用域插槽{{scope.myslotProp}}</template>
    </HelloWorld>`);

    console.log(proxyVue);
    proxyVue.msg = '测试代理对象'
    proxyVue.myClick = ()=>{
      console.log(123)
    }

  }
}
</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
</style>
