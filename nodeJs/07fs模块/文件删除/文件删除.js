//1.导入
const fs = require('fs');

//2.调用unlink方法
/*fs.unlink('../论语.txt',err =>{
    if (err){
        console.log("删除失败")
    } else {
        console.log("删除成功")
    }
});*/

//2.调用rm方法，14.4引入新方法
fs.rm('../座右铭.txt',err =>{
    if (err){
        console.log("删除失败")
    } else {
        console.log("删除成功")
    }
})
//也有对应的同步方法，rmSync,unlinkSync