// 1.引入fs模块
// import * as fs from "node:fs"
const fs = require('fs');

//2.调用方法读取文件
// fs.readFile('./resources/为学md',(err,data)=>{
//     //如果失败，则抛出错误
//     if(err){
//         throw err;
//         console.log(data.toString());
//     }
// })

//3.使用promise封装
const p = new Promise(function(resolve,reject){
    fs.readFile('./resource/为学.md',(err,data)=>{
        //判断如果失败
        if(err){
            reject(err)
        }
        //如果成功
        resolve(data)
    })
}).then(function(value){
    console.log(value.toString())
},function(reson){
    console.log("读取失败")
});
