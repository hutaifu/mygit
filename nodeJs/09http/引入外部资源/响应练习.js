//1.导入http模块
const http = require('http');
const fs = require('fs');
//2.创建服务对象
const server = http.createServer((request,response)=>{
    //获取请求url路径
    let {pathname} = new URL(request.url)
    //3.响应头
    response.setHeader('content-type','text/html;charset=utf-8');
    //读取文件
    let html = fs.readFileSync('./练习.html');
    //设置响应体
    response.write(html);//可以写入字符串，也能写入buffer,
    response.end();//
    // response.end("response")

});
//监听端口，启动服务
server.listen(9000,()=>{
    console.log("服务已经启动")
})
