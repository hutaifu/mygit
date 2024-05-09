//
const fs = require('fs');

// fs.writeFileSync('./index.html','love');
//相对路径参照的是命令行的工作目录，不是当前代码的路径

//绝对路径 '全局变量',保存的是所在文件的所在目录的绝对路径。
console.log(__dirname)

fs.writeFileSync(__dirname +  '/index.html','love');
