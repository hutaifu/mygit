<template>
  <div class="demo">
    <h2>学校名称：{{schoolName}}</h2>
    <h2>学校地址: {{adress}}</h2>
  </div>
</template>

<script>
export default {
    data() {
        return {
            schollName:"学校",
            address:"地址"
        }
    },

}
</script>
<!-- style标签加上scoped，样式就只在本页面生效，使用data-v属性，使用了scope后才能穿透,lang属性指定使用什么类型语言，less,scss,... -->
<style scoped>
    .demo{
        background-color: orange;
    }
</style>