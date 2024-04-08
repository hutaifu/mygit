<template>
  <div>
    <h1>当前求和为{{$store.state.sum}}</h1>
    <button @click="increment"></button>


  </div>
</template>

<script>
export default {
    name:'Count',
    data(){
        return{
            n:1,//用户选择的数字
        }
    },
    methods:{
        increment(){
            this.$store.dispatch('jia',this.n)
            // this.$store.commit('JIA',this.n);
        },
        decrement(){

        },
        incrementOdd(){

        },
        incrementWati(){

        }
    },
    mounted(){

    }
}
</script>

<style>

</style>