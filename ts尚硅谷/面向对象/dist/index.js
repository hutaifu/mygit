"use strict";
//使用class关键字定义一个类
/**
 * 对象中主要包含了属性和方法
 */
class Person {
    constructor() {
        //实例属性，创建实例才能访问
        //readonly 开头表示只读属性，无法修改
        this.name = "孙悟空";
        this.name2 = "孙悟空";
    }
    //定义方法
    sayHello() {
        console.log("Hello 大家好！");
    }
}
//在属性前使用static关键字，可以定义类属性,类属性不能在实例上面访问,静态属性
//注意顺序，readonly必须放在static后面
Person.age = 18;
const per = new Person();
console.log(per.name);
per.sayHello();
