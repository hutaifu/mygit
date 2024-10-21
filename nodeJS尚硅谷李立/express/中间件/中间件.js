const e = require('express');
const express = require('express')
const fs = require('fs');
const app = express();
const path = require('path');

app.get('/home',(req,res)=>{
    res.send('前台首页');

})


//声明局部中间件
let checkCodeMiddleware = (req,res,next) =>{
    //判定url中是否code参数等于521
    if(req.query.code === '521'){
        next();
    }else{
        res.send("暗号观察");
    }


}


//第二个参数，局部中间件
app.get('/admin',checkCodeMiddleware,(req,res)=>{
    //居中中间件实践
    //判定rul的code中是否为521
    // if(req.query.code === '521'){
    //     res.send("后台首页")
    // }else{
    //     res.send("暗号错误")
    // }



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



app.use(record);