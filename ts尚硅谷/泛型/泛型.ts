function fn(a:any):any {
    return a;
}

function f1(a:unknown):unknown {
    return "skldfj";
}
f1(23);

//如果函数的的参数和返回值类型相同，但同时类型又不明确，使用anY不能体现类型相同的关系
/*
* 在定义函数或是类时，如果遇到类型不明确就可以使用泛型
*
* */
function f<T>(a:T):T {
    return a;
}

//可以直接调用具有泛型的函数
f(10);//不指定泛型，ts可以自动推断，但是复杂情况不一定可以
f<string>("hello");//指定泛型

function f2<T,K>(a:T,b:K):T {
    return a;
}
f2<number,string>(223,"hello");

interface Interface {
    length:number;
}

//泛型可以继承 接口或者类型
function f3<T extends Interface>(a:T):number {
    return a.length;
}

function f4<T extends number>(a:T):T {
 return a;
}