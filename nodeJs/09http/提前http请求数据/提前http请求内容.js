//1.导入http模块
const http = require('http');
//导入url模块
const url = require('url')

//2.创建服务对象
const server = http.createServer((request,response)=>{
    //获取请求方法
    console.log(request.method)
    //获取请求的url
    console.log(request.url)//只包含url中的路径和查询字符串
    //获取http协议版本号
    console.log(request.httpVersion)
    //获取http请求头,
    console.log(request.headers)
    //请求头的host
    console.log(request.headers.host)
    //获取请求体
    //1.声明一个变量
    let body = "";
    request.on('data',chunk =>{
        //chunk是一个Buffer
        body += chunk;  //内存空间做加法运行，会自动转为字符串
    })

    //3.绑定end事件
    request.on('end',()=>{
        console.log(body)
    })

    //提取url中的路径和查询字符串
    let res = url.parse(request.url,true)//第二个参数如果为true,query会变成对象，否则是字符串
    console.log(res)
    let pathname = res.pathname;
    console.log(pathname)
    console.log(res.query.key)






    response.setHeader("content-type","text/html;charset=utf-8")//不设置格式，中文会乱码
    response.end("hello http serve,你好");//设置响应体并结束

});
//监听端口，启动服务
server.listen(9000,()=>{
    console.log("服务已经启动")
})

//