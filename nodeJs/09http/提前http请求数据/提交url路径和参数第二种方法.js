//1.导入http模块
const http = require('http');

//2.创建服务对象
const server = http.createServer((request,response)=>{
 /*   let url = new URL('/search?a=100&b=20','http://127.0.0.1:9000');
    console.log(url);*/
    let url = new URL(request.url,'http://127.0.0.1:9000');
    console.log(url);
    console.log(url.pathname)
    console.log(url.searchParams.get('key'))
    //URL类在浏览器端也能用，新版，
    response.setHeader("content-type","text/html;charset=utf-8")//不设置格式，中文会乱码
    response.end("hello http serve,你好");//设置响应体并结束

});
//监听端口，启动服务
server.listen(9000,()=>{
    console.log("服务已经启动")
})

//