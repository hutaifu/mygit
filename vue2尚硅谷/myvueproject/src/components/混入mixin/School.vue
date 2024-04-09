<template>
    <!--
    定义的属性如果冲突，以组件本身为主，
    钩子函数先调用混合后调用组件钩子
    全局混合：
    Vue.mixin(mixin)
    
    
    -->
  <div>
    <h2 @click="showName">学校名称：{{name}}</h2>
    <h2>学生性别：{{sex}}</h2>
  </div>
</template>

<script>
import {mixin} from "./mixin"
export default {
    name:'MySchool',
    data() {
        return {
            name:"名称",
            sex:"男"
        }
    },
    methods: {
        showName(){
            alert(this.name)
        }
    },
    //必须写成一个数组，
    mixins:[mixin],

}
</script>

<style>

</style>