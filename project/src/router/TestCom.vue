<template>
    <div>
        <button>切换路由</button>
        <router-link to="/about" active-class="active">About</router-link>
        <br>
        <router-link to="/test" active-class="active">Test</router-link>
        <router-view></router-view>

    </div>
</template>

<script>
    import C1 from "../components/HelloWorld"
    import C2 from "../components/TestPageVue"
    export default {
        name: "TestCom",
        props: {},
        data() {
            return {}
        },
        methods: {},
        created() {
        },
        mounted() {
        },
        beforeDestroy() {
        },
    }
</script>

<style scoped>

</style>