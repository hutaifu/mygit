//声明一个变量a,同时指定它的类型为number
let a:number;

//a 的类型设置为了number,在以后的使用过程中a的值只能是数字
a = 10;
a = 33;
//a = 'hello';//此行代码会报错，因为变量a的类型是number，不能赋值字符串
let b:String;
b = "hello";
//b = 123;
//let c:boolean = false;
//如果变量的声明和赋值同时进行，ts可以自动对变量进行类型检测
let c = true;
c = false;
//c = 123;

//js中函数不考虑参数的类型和个数
function sum(a:number,b:number):number {
    return a + b;
}

sum(123,456);

//sum(123,'23')  进行参数类型校验
//sum(45,323,545) 进行参数个数校验
let result = sum(123,998)


//类型，number,string,boolean,字面量，any,unknown,void,never,object,array,tuple,enum,
//也可以直接使用字面量进行类型声明
let aa:10;
aa = 10;
//aa = 11;
//可以使用|连接多个类型，联合类型
let bb:'male' | 'female';
bb = 'male';
bb = 'female';
// bb = 'ajkdf'
//any 标识任意类型，一个变量设置为any后，相当于当对于该变量关闭了ts的类型校验
let d:any;//显示any
d = 10;
d = 'hello'
d = true;

//声明变量如果不指定类型，ts解析器会自动判断变量的类型为anY
let dd;
dd = 'skdfj'
dd = 23;

//unknown标识未知类型
let e:unknown;
e = 10;
e = 'hello';
e = true;

let s:string;
//d的类型为any,可以赋值给任意变量，
s = d;
//unknown 类型变量不能赋值给别的类型
//unknown 类型的变量，不能直接赋值给其他变量
e = 'hello';
//s = e;
//赋值前进行类型判断，不会报错
if(typeof e === "string"){
    s = e;
}



