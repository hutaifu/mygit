<template>
    <!--1.当props和属性和data属性冲突时，以外部传进来的props为主，
        2.所有props的属性比data属性优先接收放在vue组件实例上面
        3.利用这个在data里面定义一个变量去接收props里面的属性，以后要修改就修改data里面的这个属性
    
    
    
    -->
  <div>
    <h2>学校名称：{{name}}</h2>
    <h2>学校地址：{{address}}</h2>
    <h1>年龄：{{myAge}}}</h1>
    <button @click="showName">点击</button>
  </div>
</template>

<script>
export default {
    name:'MySchool',
    //props:['age','sex'],//简单声明接收
    //接收的同时对类型进行限制
    // props:{
    //     age:Number,
    //     sex:String
    // },
    props:{
        sex:{
            type:String,//类型
            required:false,//必填项
            default:"测试"//默认值
        },
        age:{
            type:Number,
            default:10,
        }
    },
    data() {
        return {
            name:"名称",
            address:"地址",
            myAge:this.age,
        }
    },
    methods: {
        showName(){
            alert(this.name)
        }
    },

}
</script>

<style>

</style>