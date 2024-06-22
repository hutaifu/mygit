<template>
  <div id="app" style="text-align:center">
    <img alt="Vue logo" src="./assets/logo.png">
    <div id="hello"></div>
    <HelloWorld :msg="msg" ref="myRef" @click="myClick" :key="new Date().getTime().toString()" v-model="myModel" :class="myClass" id="myId">
        <p>123</p>
      <template v-slot:myslot="scope">测试具名插槽{{scope}}</template>
    </HelloWorld>
    <button @click="msg = '123' ">测试响应式</button>
<!--    <el-input v-model="abc"></el-input>-->
  </div>
</template>


<script>
import HelloWorld from './components/HelloWorld.vue'
import {addComponent} from './js/addCompoent'
import Vue from 'vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
  },
  data(){
    return {
      msg:"Welcome to Your Vue.js App",
      myModel:"",
      myClass:"",
      abc:'abc',
      testColor:'red',
      vForArr:[1,2]
    }
  },
  methods:{
    myClick(){
      console.log("触发了我的点击事件");
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
    let _vm = this;
    let _c = this.$createElement;
    let _render = ()=>{
      let Vnode = this.$createElement(
              HelloWorld,
              {
                key: "5485454",
                ref: "myRef",
                class: _vm.myClass,
                attrs: { msg: _vm.msg, id: "myIdJs" },
                on: { click: _vm.myClick },
                scopedSlots: _vm._u([
                  {
                    key: "myslot",
                    fn: function (scope) {
                      return [_vm._v("测试具名插槽" + _vm._s(scope))]
                    },
                  },
                ]),
                model: {
                  value: _vm.myModel,
                  callback: function ($$v) {
                    _vm.myModel = $$v
                  },
                  expression: "myModel",
                },
              },
              [_c("p", [_vm._v("123")])]
          );
      return Vnode;
    }

    let _vnode = _render();

    let Cons = Vue.extend(HelloWorld);
    console.log(HelloWorld)
    let comVm = new Cons({
      _isComponent:true,
      parent:this,
      _parentVnode:_vnode,
    });
    //替换当前组件虚拟节点
    let index = this._vnode.children.findIndex(item => item?.data?.attrs?.id === 'hello');
    if (index){
      this._vnode.children[index] = _vnode;
    }

    _vnode.componentInstance = comVm;


    let render = this.$options.render.bind(this);
    this.$options.render = ()=>{
      let vnode = render();
      let child = _render();
      //找到选择器id = hello的虚拟节点，替换掉
      let index = vnode.children.findIndex(item => item?.data?.attrs?.id === 'hello');
      if (index){
        vnode.children[index] = child;
      }
      return vnode;
    }
      comVm.$mount("#hello"); // 手动挂载
      console.log(Cons);
    const self = this;

  }
}
</script>

<style scoped>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
    .abc{
      color: red;
    }
</style>
