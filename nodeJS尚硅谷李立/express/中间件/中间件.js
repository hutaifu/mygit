const express = require('express')
const fs = require('fs');
const app = express();
const path = require('path');

app.get('/home',(req,res)=>{
    res.send('前台首页');

})

app.get('/admin',(req,res)=>{
    res.send("后台首页")
})

app.all('*',(req,res)=>{
    console.log(123)
    res.send('404 NOT Found')
})

app.listen(3000,()=>{
    console.log("服务已经启动")
})

//全局中间件
function record(req,res,next){
    let {url,ip} = req;
    //将信息存在文件中
    console.log(url)
    console.log(ip)
    fs.appendFileSync(path.resolve(__dirname,'./access.log'),`${url} ${ip}\r\n`)
    //调用next
    next();
}

//局部中间件，放在路由参数后面
// app.get('/jvbu',record,(req,res)=>{
//
// })



app.use(record);