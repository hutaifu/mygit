<template>
  <div>
    <button @click="this.isShow = !this.isShow">显示/隐藏</button>
    <transition name="hello" appear>
        <h1 v-show="isShow">你好啊</h1>
    </transition>
    <!-- 多个元素过滤 -->
    <transition-group>
        <h1 :key="1"></h1>
        <h1 :key="2"></h1>
    </transition-group>
    <!-- 使用第三方库 网址：animate.style -->
    <transition name="animate__animated animate__bounce"
                appear
                enter-active-class="animate__backInRight"
                leave-active-class="animate__backOutDown">
        <div>
            <h1 v-show="isShow">你好啊</h1>
            <h1></h1>
        </div>
    </transition>
  </div>
</template>

<script>
import 'animate.css'
export default {
    data() {
        return {
            isShow:true,
        }
    },
    created(){
        fetch()
    }
}
</script>

<style scoped>
    h1{
        background-color: orange;
    }
    /* 动画实现 */
    @keyframes atogui{
        from{
            transform: translateX(-100%);
        }
        to{
            transform: translateX(0px);
        }
    }
    .v-enter-active{
        animation: atogui 1s;   
    }
    .v-leave-active{
        animation: atogui 1s reverse;
    }
    /* .hello-enter-active{
        animation: atogui 1s;   
    }
    .hello-leave-active{
        animation: atogui 1s reverse;
    } */

    
    /* 过渡实现 */
    /* 进入的起点 */ /* 离开的终点 */
    .hello-enter,.hello-leave-to{
        transform: translateX(-100%);

    }
    /* 进入的终点 */ /* 离开的起点 */
    .hello-enter-to,.hello-leave{
        transform: translateX(0);
    }
    .hello-enter-active,.hello-leave-active{
        transition: 1s linear;
    }
</style>