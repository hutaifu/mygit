// 1.alloc
let buf = Buffer.alloc(10);
console.log(buf)
//这样创建每个二进制都会归零
//

//2.allocUnsafe
let buf_2 = Buffer.allocUnsafe(10);
console.log(buf_2)

//这样创建不安全，创建的Buffer可能包含旧的内存数据，内存空间可以被复用，这样创建的内存空间中旧的内存数据不会归零
//但是这样速度快


//3.from
let buf_3 = Buffer.from("hello");
//每个字节都是十六进制
//每个字符串对应的unicode编码转成十六进制显示，二进制存储
console.log(buf_3)
let buf_4 = Buffer.from([105,108,111,118,101,121,111,117])
console.log(buf_4)

