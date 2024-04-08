<template>
    <div class="container">
        <Chacao title="美食" :listData="foods"></Chacao>
        <Chacao title="游戏" :listData="games"></Chacao>
        <Chacao title="电影" :listData="films"></Chacao>
    </div>
</template>

<script>
    //引入组件
import chacao from "./components/插槽/index.vue"
export default {
    name:"App",
    components:{
        // School,
        Chacao:chacao
    },
    data(){
        return {
            foods:["火锅","烧烤","小龙虾","牛排"],
            games:["红色警察","穿越火线",'劲舞团',"超级玛丽"],
            films:["《教父》","《拆弹专家》","《你好，李焕英》","《尚硅谷》"]
        }
    },
    methods:{
   
    }
};
</script>

<style scoped>
    .container{
        display: flex;
        justify-content: space-around;
    }
</style>