//1.导入http模块
const http = require('http');

//2.创建服务对象
const server = http.createServer((request,response)=>{
    response.setHeader("content-type","text/html;charset=utf-8")//不设置格式，中文会乱码
    response.end("hello http serve,你好");//设置响应体并结束

});
//监听端口，启动服务
server.listen(9000,()=>{
    console.log("服务已经启动")
})

//