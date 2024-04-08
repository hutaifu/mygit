<template>
  <div>
    <div style="width: 100px;height: 60px;border: 1px solid;">
    <Item :is-active="curActive === '动漫'" @active="active">
      <span>动漫</span>
    </Item>
  </div>
  <div style="width: 100px;height: 60px;border: 1px solid;">
    <Item :is-active="curActive === '电竞'">
      <span>电竞</span>
    </Item>
  </div>

  </div>
</template>

<script>



import Item from "./components/Item.vue";//后缀名可以省略，webpack的功能
export default {
  name: 'App',
  components: {
    Item
  },
  data(){
    return{
      curActive:"动漫"
    }
  },
  methods:{
    active(data){
      console.log(data)
    }
  }
}
</script>

<style>
</style>
