"use strict";
function fn(a) {
    return a;
}
function f1(a) {
    return "skldfj";
}
f1(23);
//如果函数的的参数和返回值类型相同，但同时类型又不明确，使用anY不能体现类型相同的关系
/*
* 在定义函数或是类时，如果遇到类型不明确就可以使用泛型
*
* */
function f(a) {
    return a;
}
//可以直接调用具有泛型的函数
f(10); //不指定泛型，ts可以自动推断，但是复杂情况不一定可以
f("hello"); //指定泛型
function f2(a, b) {
    return a;
}
f2(223, "hello");
//泛型可以继承 接口或者类型
function f3(a) {
    return a.length;
}
function f4(a) {
    return a;
}
//# sourceMappingURL=%E6%B3%9B%E5%9E%8B.js.map