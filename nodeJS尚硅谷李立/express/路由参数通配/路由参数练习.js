//1.导入express
const express = require('express');
//导入json 文件
const {singers} = require('./singers.js');

console.log(singers)

//2.创建应用对象
const app = express();

//创建路由
app.get('/singer/:id.html',(req,res)=>{
    //获取路由参数
    let {id} = req.params;
    //在数组中寻找对应的数据
    let result = singers.find(item =>
        item.id === parseInt(id)
    )
    //原生操作
    res.setHeader("content-type","text/html;charset=utf-8");
    if (!result){
        res.end("404 NOT Found");
        result;
    }
    res.end(result.name);
})


//监听端口，启动服务
app.listen(3000,()=>{
    console.log('服务已经启动，端口3000正在监听中')
})