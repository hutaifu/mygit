//1.引入fs模块
const fs = require('fs');

//2.创建读取对象
const rs = fs.createReadStream('./图片.jpg');

//3.绑定data
rs.on('data',chunk =>{
    console.log(chunk.length)//65536 字节 =》64kb
})

//4.end,可选事件
rs.on('end',()=>{
    console.log("读取完成")
})