<template>
    <div>
    
    </div>
</template>

<script>
export default {
    data() {
        return {
            
        }
    },
    methods:{
        unbind(){
            this.$off("")//解绑一个自定义事件
            this.$off(['event1',event2])//解绑特点的自定义事件
            this.$off()//所有的自定义事件解绑
            //组件如果被销毁，组件实例上的自定义事件不会奏效了，子组件也会被销毁，原生的事件不受影响，
            //使用$on绑定，组件自己将会调用组件自己绑定的事件
            //###组件也能用原生事件，但是需要加native修饰符，实际上绑定组件的根元素，单根原因之一，（事件，对比）
        }
    }

}
</script>

<style>

</style>