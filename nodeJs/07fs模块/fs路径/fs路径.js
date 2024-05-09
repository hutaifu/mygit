//1.导入
const fs = require('fs');

//相对路径
fs.writeFileSync('index.html','love');
fs.writeFileSync('./index.html','love'); //和上面等价

//绝对路径
// fs.writeFileSync('D:/index.html','love');//C盘权限不够
fs.writeFileSync('/index.html','love');//,在盘符根目录下创建





