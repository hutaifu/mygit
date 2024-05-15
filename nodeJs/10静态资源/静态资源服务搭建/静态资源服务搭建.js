/*
* 创建一个http服务，端口9000，满足如下需求
* get /index.html  响应page/index.html文件内容
* get /css/app.css 响应page/css/app.css 的文件内容
* get /image/logo.png 响应page/images/logo.png的文件内容
*
* */

//1.导入http模块
const http = require('http');
const fs = require('fs');
const path = require('path');

//声明一个变量
let mimes = {
    html:'text/html',
    css:'text/css',
    js:'text/javascript',
    png:'image/png',
    jpg:'iamge/jpg',
    gif:'image/gif',
}


//2.创建服务对象
const server = http.createServer((request,response)=>{
    //判断请求方法
    if(response.method !== "GET"){
        response.statusCode = 405;
        response.setHeader("content-type","text/html;charset=utf-8");
        response.end("<h1>405 Method Not Allowed</h1>")
        return;
    }


    //获取请求url路径
    let {pathname} = new URL(request.url,'http://127.0.0.1:9000')
    //拼接文件路径
    let filePath = __dirname + '/page' + pathname;
    //读取文件fs异步
    fs.readFile(filePath,(err,data)=>{
        if (err){
            if (err.code === 'ENOENT') {
                response.statusCode = 404;
                response.setHeader("content-type","text/html;charset=utf-8");
                response.end("<h1>404 Not Found</h1>")
                return;
            }

            response.statusCode = 500;
            response.setHeader("content-type","text/html;charset=utf-8");
            response.end("文件读取失败");
            return;
        }
        //设置响应文件类型，媒体类型，mmie
        let ext = path.extname(filePath).slice(1);
        //获取对应类型
        let type = mimes[ext];
        if (type){
            response.setHeader('content-type',type + ";charset=utf-8");
            //设置响应头字符串比设置html源标签字符集的优先级要高
        } else {
            response.setHeader('content-type','application/octet-stream')
        }

        response.end(data);
    })

});
//监听端口，启动服务
server.listen(9000,()=>{
    console.log("服务已经启动")
})