//使用class关键字定义一个类
/**
 * 对象中主要包含了属性和方法
 */
class Person {
    //实例属性，创建实例才能访问
    //readonly 开头表示只读属性，无法修改
    readonly name:string = "孙悟空";
    //在属性前使用static关键字，可以定义类属性,类属性不能在实例上面访问,静态属性
    //注意顺序，readonly必须放在static后面
    static readonly age:number = 18;

    name2 = "孙悟空";

    //定义方法
    sayHello(){
     console.log("Hello 大家好！");
    }
}

const per = new Person();
console.log(per.name)

per.sayHello();
