//1.引入
const fs = require('fs')

//2.stat方法 status 缩写，状态
fs.stat('../座右铭.txt',(err,data)=>{
    if (err){
        console.log("操作失败")
    } else {
        console.log(data)
        //isFile
        console.log(data.isFile());
        //isDirectory
        console.log(data.isDirectory());
    }
})

//