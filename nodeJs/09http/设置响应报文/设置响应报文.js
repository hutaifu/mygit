//1.导入http模块
const http = require('http');

//2.创建服务对象
const server = http.createServer((request,response)=>{
    //1.设置响应状态码
    response.statusCode = 200;
    //2.设置响应状态描述
    response.statusMessage = "iloveyou"
    //3.响应头
    response.setHeader('content-type','text/html;charset=utf-8');
    response.setHeader('Server','Node.js')//server响应头，服务端名称
    //多个同名响应头
    response.setHeader('test',['a','b','c'])
    //设置响应体
    response.write('love');
    response.write("love")
    response.end();//
    // response.end("response")

});
//监听端口，启动服务
server.listen(9000,()=>{
    console.log("服务已经启动")
})
