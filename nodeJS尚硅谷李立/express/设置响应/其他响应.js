//1.导入express
const express = require('express');

//2.创建应用对象
const app = express();

//创建路由
app.get('/other',(req,res)=>{
    //跳转响应
    // res.redirect('http://atguigu.com');
    //下载响应
    // res.download(__dirname + '/响应设置.js');
    //响应json格式数据
    // res.json({
    //     name:'尚硅谷'
    //     ,slogon:"天下没有难学的技术"
    // })
    //响应文件内容
    res.sendFile(__dirname + '/练习.html')
})



//监听端口，启动服务
app.listen(3000,()=>{
    console.log('服务已经启动，端口3000正在监听中')
})