//声明一个函数
function tiemo() {
    console.log("贴膜...");
}


function niejiao(){
    console.log("捏脚")
}

//暴露数据第一种
// module.exports = {tiemo,niejiao};



//exports 暴露数据 第二种
exports.niejiao = niejiao;
exports.tiemo = tiemo;
