//导入fs模块
const fs = require('fs');

//读取code文件夹
const files = fs.readdirSync('./code');

console.log(files)

files.forEach(item =>{
    //拆分
    //重命名
    console.log(typeof item)
    fs.renameSync(`./code/${item}`,`./code/重命名后${item}`)
})