//导入 fs
const fs = require('fs');
const path = require('path')

//写入文件
// fs.writeFileSync(__dirname + '/index.html','love');
console.log(__dirname + "/index.html")

//resolve
console.log(path.resolve(__dirname,'./index.html'));
console.log(path.resolve(__dirname,'index.html'));//使用的时候，第一个参数给绝对路径，后面的参数给相对路径，

//sep,分隔符  路径分隔符，不同的操作系统路径分隔符不同，window \  linux  /
console.log(path.sep)

//pares方法           __filename,文件的绝对路径
console.log(__filename);
let str = 'D:\\mygit\\nodeJs\\08path模块\\path模块.js';
console.log(path.parse(str))


//basename  文件命
console.log(path.basename(str))

//dirname 文件夹命
console.log(path.dirname(str))

//extname 扩展命
console.log(path.extname(str))