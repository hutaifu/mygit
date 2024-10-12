<template>
  <div id="app" style="text-align:center">
    <img alt="Vue logo" src="./assets/logo.png">
    <div id="hello"></div>
    <div id="elInput"></div>
    <HelloWorld :msg="msg" ref="myRef" @click="myClick" :key="new Date().getTime().toString()" v-model="myModel" :class="myClass" id="myId">
        <p>123</p>
      <template v-slot:myslot="scope">测试具名插槽{{scope}}</template>
    </HelloWorld>
    <button @click="msg = '123' ">测试响应式</button>
<!--    <el-input v-model="abc" :class="abc" ref="templateMyElInputRef" v-for="item in vForArr"></el-input>-->
  </div>
</template>


<script>
import HelloWorld from './components/HelloWorld.vue'
import Vue from 'vue'
import myaddCom from "./js/myAddCompoent/myAddCompont"
import getComponent from "./js/myAddCompoent/getComponent"

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
/*    let _vm = this;
    let _c = this.$createElement;
    let _render = ()=>{
      let Vnode =             _c("el-input", {
        ref: "templateMyElInputRef",
        class: _vm.abc,
        model: {
          value: _vm.abc,
          callback: function ($$v) {
            _vm.abc = $$v
          },
          expression: "abc",
        },
      });
      return Vnode;
    }*/

    /*let _vnode = _render();*/

    /*let Cons = Vue.extend(getComponent("el-input"));*/


/*    let comVm = new Cons({
      _isComponent:true,
      parent:this,
      _parentVnode:_vnode,
    });*/
    //替换当前组件虚拟节点
/*    let index = this._vnode.children.findIndex(item => item?.data?.attrs?.id === 'hello');
    if (index){
      this._vnode.children[index] = _vnode;
    }*/

 /*   _vnode.componentInstance = comVm;*/

/*
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
     /!* comVm.$mount("#hello"); // 手动挂载*!/
      // console.log(Cons);
    //重新渲染
    this.$forceUpdate()
    const self = this;*/

/*    let myCom = myaddCom(this,HelloWorld,"hello",`  <HelloWorld :msg="msg" ref="testMyRef" @click="myClick" :key="new Date().getTime().toString()" v-model:sk="myModel" :class="myClass" id="myId">
        <p>123</p>
        紫芜丘陵未有雪，我未执枪已十三年
           <template v-slot:myslot="scope">测试作用域插槽{{scope.myslotProp}}</template>
                  <template #myslot1="scope">测试作用域插槽{{scope.myslotProp}}</template>
    </HelloWorld>`);*/





    myaddCom(this,'ElInput','elInput',`<el-input v-model="abc" v-for="item in vForArr" :class="abc" ref="myElInput"></el-input>`)

    setTimeout(()=>{
      this.abc = "abcdsf"
    },3000)





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
      width: 100px;
    }
</style>
