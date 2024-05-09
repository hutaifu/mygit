/*
* 新建一个文件，座右铭.txt,写入内容，三人行，则必有我师焉
* */

//1.导入fs模块
const fs = require('fs');

//2.写入文件,如果文件不存在，会自动创建
fs.writeFile('./座右铭.txt','三人行，则必有我师焉',err =>{
    //如果写入失败 err 是错误对象，写入成功，null
    if (err){
        console.log("写入失败")
    } else {
        console.log("写入成功")
    }
})

