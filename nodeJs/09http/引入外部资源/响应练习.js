//1.导入http模块
const http = require('http');
const fs = require('fs');
//2.创建服务对象
const server = http.createServer((request,response)=>{
    //获取请求url路径
    let {pathname} = new URL(request.url,'http://127.0.0.1:9000')
    if(pathname === '/'){
        //3.响应头
        response.setHeader('content-type','text/html;charset=utf-8');
        //读取文件
        let html = fs.readFileSync('./练习.html');
        //设置响应体
        response.write(html);//可以写入字符串，也能写入buffer,
        response.end();//
    }else if(pathname === '/index.css'){
        //读取文件内容
        let css = fs.readFileSync(__dirname + '/index.css')
        response.end(css);
    }else if(pathname === '/index.js'){
        //读取文件内容
        let js = fs.readFileSync(__dirname + '/index.js');
        response.end(js)
    }else {
        response.statusCode = 404;
        response.end(`<h1>404 Not Found</h1>`)
    }

});
//监听端口，启动服务
server.listen(9000,()=>{
    console.log("服务已经启动")
})
