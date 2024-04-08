<template>
  <div class="item" :class="{active:isActive}" @click="active">
    <!-- 插槽 -->
    <slot><!-- optional fallback --></slot>
  </div>
</template>

<script>
export default {
    props:{
       isActive:{
        type:Boolean,//约束该属性类型是布尔，
        // required:true,//约束该属性必须需要传递
        default:false,
       }
    },
    methods:{
        active(){
            this.$emit("active",123)
        }
    }

}
</script>


<style scoped>
    .active{
        background-color: #e7e7e7;
    }
    .item:hover{
        background: #f4f4f4;
        transition: 0.2s;
    }
    .item{
        cursor: pointer;
        width: 100%;
        height: 100%;
    }
</style>