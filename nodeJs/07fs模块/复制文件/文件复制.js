//复制文件
//方式一，readFile
//读取文件内容
const fs = require('fs');
const process = require('process');

let data = fs.readFileSync('./图片.jpg');
//写入文件
fs.writeFileSync('./图片复制.jpg',data)
console.log(process.memoryUsage())



//方式二 ，流式操作,占用内存空间小
const rs = fs.createReadStream('./图片.jpg');
const ws = fs.createWriteStream('./图片2.jpg');
rs.on('data',chunk =>{
    ws.write(chunk)
})
rs.on('end',()=>{
    console.log(process.memoryUsage())
})

//rs.pipe(ws);//这样也能快速复制