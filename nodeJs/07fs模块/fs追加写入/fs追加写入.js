//1.引入fs模块
const fs = require('fs');

//调用appendFile
/*fs.appendFile('./座右铭.txt','，则其善者而从之，则其不善者而改之',err =>{
    //判断
    if(err){
        console.log("写入失败")
        return;
    }
    console.log("追加写入成功")
})*/

fs.appendFileSync('./座右铭.txt','\r\n，温故而知新，可以为师矣',err =>{
    //判断
    if(err){
        console.log("写入失败")
        return;
    }
    console.log("追加写入成功")
})

//writeFile 实现追加写入，
fs.writeFile('./座右铭.txt','love love love',{flag:'a'},err =>{
    //判断
    if(err){
        console.log("写入失败")
        return;
    }
    console.log("追加写入成功")
})