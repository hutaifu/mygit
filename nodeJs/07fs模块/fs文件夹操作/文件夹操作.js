//引入
const fs = require('fs');
//make directory
/*fs.mkdir('./html',err =>{
    if (err){
        //已经存在文件夹，会失败
        console.log("创建失败")
    } else {
        console.log("创建成功")
    }
});*/

//递归创建,连续创建多个文件夹
/*fs.mkdir('./a/b/c',{recursive:true},err =>{
    if (err){
        console.log("创建失败")
    } else {
        console.log("创建成功")
    }
})*/

//读取文件夹，得到文件夹的文件列表
fs.readdir('../重命名和移动',(err,data)=>{
    if (err){
        console.log("读取失败")
    } else {
        console.log(data)
    }
});

//删除文件夹,只能删除空文件夹
/*
fs.rmdir('./html',err =>{
    if (err){
        console.log("删除失败")
    } else {
        console.log("删除成功")
    }
})*/

//删除文件夹，递归删除非空文件夹
/*fs.rmdir('./a',{recursive:true},err =>{
    if (err){
        console.log("删除失败")
        console.log(err)
    } else {
        console.log("删除成功")
    }
})*/

//rmdir将来会被移除，建议使用rm

//rm删除
fs.rm('./a',{recursive:true},err =>{
    if (err){
        console.log("删除失败")
        console.log(err)
    } else {
        console.log("删除成功")
    }
})
