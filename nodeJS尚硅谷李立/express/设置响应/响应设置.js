//1.导入express
const express = require('express');

//2.创建应用对象
const app = express();

//创建路由
app.get('/123',(req,res)=>{
    //原生响应
    // res.statusCode = 404;
    // res.statusMessage = 'love';
    // res.setHeader('xxx','yyy',);
    // res.write('hello express');
    // res.end(' response');


    //express内置响应
    // res.status(500);
    // res.set('aaa','bbb');
    // res.send("你好 express");
    res.status(500).set('abac','arase').send('这都是ok')

})


//监听端口，启动服务
app.listen(3000,()=>{
    console.log('服务已经启动，端口3000正在监听中')
})