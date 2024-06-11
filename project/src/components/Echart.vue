<template>
    <div>
    <p>测试组件</p>
    <div>
        <!-- 为 ECharts 准备一个具有大小的 DOM 元素 -->
        <div ref="chart" style="height: 400px;"></div>
    </div>
    </div>
</template>

<script>
    import echarts from 'echarts';
    export default {
        name: "Echart",
        props: {},
        data() {
            return {
                chartInstance: null
            }
        },
        methods: {
            initChart() {
                this.chartInstance = echarts.init(this.$refs.chart);

                const option = {
                    xAxis: {
                        type: 'category',
                        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: [150, 230, 224, 218, 135, 147, 260],
                        type: 'line'
                    }]
                };

                // 使用 setOption 方法设置图表配置项并显示图表
                this.chartInstance.setOption(option);
            }
        },
        created() {
        },
        mounted() {
            // 在 mounted 生命周期钩子中初始化 ECharts 实例并绘制图表
            console.log(echarts)
            this.initChart();
        },
        beforeDestroy() {
        },
    }
</script>

<style scoped>

</style>