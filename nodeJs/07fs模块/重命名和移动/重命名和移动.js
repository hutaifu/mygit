//1.导入fs模块
const fs = require('fs');

//2.调用rename方法
/*fs.rename('./座右铭.txt','./论语.txt',err =>{
    if (err){
        console.log("操作失败")
    } else {
        console.log("操作成功")
    }
});*/

//文件的移动
fs.rename('./论语.txt','../论语.txt',err =>{
    if (err){
        console.log("操作失败")
        console.log(err)
    } else {
        console.log("操作成功")
    }
})

//同步方法
// fs.renameSync()
