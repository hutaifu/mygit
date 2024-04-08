<template>
  <div class="category">
    <h3>{{ title}}</h3>
    <li v-for="(item,index) in listData" :key="index">{{ item }}}</li>
  </div>
</template>

<script>
export default {
    name:"Category",
    props:["listData","title"],
    data() {
        return {
           
        }
    },
}
</script>

<style scoped>
    .category{
        background-color: skyblue;
        width: 200px;
        height: 300px;
    }
    h3{
        text-align: center;
        background-color: orange;
    }
</style>