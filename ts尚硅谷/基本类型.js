//声明一个变量a,同时指定它的类型为number
var a;
//a 的类型设置为了number,在以后的使用过程中a的值只能是数字
a = 10;
a = 33;
//a = 'hello';//此行代码会报错，因为变量a的类型是number，不能赋值字符串
var b;
b = "hello";
//b = 123;
//let c:boolean = false;
//如果变量的声明和赋值同时进行，ts可以自动对变量进行类型检测
var c = true;
c = false;
//c = 123;
//js中函数不考虑参数的类型和个数
function sum(a, b) {
    return a + b;
}
sum(123, 456);
//sum(123,'23')  进行参数类型校验
//sum(45,323,545) 进行参数个数校验
var result = sum(123, 998);
