//buffer与字符串的转换
let buf_4 = Buffer.from([105,108,111,118,101,121,111,117])
console.log(buf_4.toString())//utf-8,默认编码

//[]
let buf = Buffer.from("hello");
console.log(buf[0])
console.log(buf[0].toString(2))//  011001000 八位二进制，第一位0被省略掉
buf[0] = 95
console.log(buf)
console.log(buf.toString())


//溢出
buf[0] = 361;//舍弃高位的数字  0001  0110 1001  =》 0110 1001
console.log(buf)
console.log(parseInt('01101001',2).toString(16))



//中文
let buf_5 = Buffer.from("你好");
console.log(buf_5)
//utf-8，一个中文一般是三个字节