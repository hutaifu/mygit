<template>
  <div id="app" style="text-align:center">
    <img alt="Vue logo" src="./assets/logo.png">
    <div id="hello"></div>
    <HelloWorld :msg="msg" ref="myRef" @click="myClick" :key="new Date().getTime().toString()" v-model="myModel"
                :class="myClass" id="myId">
      <p>123</p>
      <template v-slot:myslot="scope">测试具名插槽{{ scope }}</template>
    </HelloWorld>
    <button @click="msg = '123' ">测试响应式</button>
  </div>
</template>


<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
  },
  data() {
    return {
      msg: "Welcome to Your Vue.js App",
      myModel: "",
      myClass: "",
      abc: 'abc',
      testColor: 'red',
      vForArr: [1, 2]
    }
  },
  methods: {
    myClick() {
      console.log("触发了我的点击事件");
      alert("触发了app传递给hello的点击事件")
    }
  },
  beforeCreate() {

  },
  created() {

  },
  beforeMount() {
  },
  provide() {

  },
  mounted() {
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

.abc {
  color: red;
}
</style>
