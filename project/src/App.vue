<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <div id="hello"></div>
    <HelloWorld :msg="msg" ref="myRef" @click="myClick" :key="new Date().getTime().toString()" v-model="myModel" :class="myClass" id="myId">
        <p>123</p>
      <template v-slot:myslot>测试具名插槽</template>
    </HelloWorld>
    <button @click="msg = '123' ">测试响应式</button> 
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
// import Vue from "vue"
// import { CreateElement } from 'vue';
import { addComponent } from './js/addCompoent.js';

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
    }
  },
  beforeCreate(){
  
  },
  created(){
  
  },
  beforeMount(){
  },
  mounted(){
    //使用extend
  //   let Cons = Vue.extend(HelloWorld);
  //   console.log(HelloWorld)
  //   let comVm = new Cons({
  //     _isComponent:true,
  //     parent:this,
  //     _parentVnode:this.$createElement('HelloWorld',{on:{
  //       click:function(){
  //         console.log("js增加的点击事件")
  //       },},
  //       class: {
  //   foo: true,
  //   bar: false
  // },
  // key: 'myKey',
  // ref: 'myRef',
  // nativeOn: {
  //   // click: this.nativeClickHandler
  // },//原生的事件会绑定在组件跟元素上，不是组件内部定义并且使用$emit触发的事件
  //  attrs: {
  //   id: 'foo'
  // }, // 普通的 HTML attribute
  // props:{
  //   msg:this.msg
  // }
  //     },['紫芜丘陵未有雪，我未执枪已十三年'])
  //
  //   });
  //   comVm.$mount("#hello"); // 手动挂载
  //   console.log(Cons);
  //   this.$watch('msg',{
  //     handler(n,o){
  //       comVm.msg = this.msg;
  //       comVm.$forceUpdate();
  //     },deep:false
  //   });
    addComponent(this,HelloWorld,"#hello",`  <HelloWorld :msg="msg" ref="myRef" @click="myClick" :key="new Date().getTime().toString()" v-model:sk="myModel" :class="myClass" id="myId" v-on="muClick" @click.native="myTest" @blur.native="myBlur">
        <p>123</p>
        '紫芜丘陵未有雪，我未执枪已十三年'
    </HelloWorld>`)
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
