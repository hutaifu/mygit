"use strict";
class Dog {
    //构造函数，this执行创建的实例，创建实例时执行
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    bark() {
        // alert("汪汪汪！");
        console.log(this);
    }
}
const dog = new Dog("小河", 4);
const dog2 = new Dog("小白", 2);
const dog3 = new Dog("小天", 3);
const dog4 = new Dog("小狗", 4);
console.log(dog);
console.log(dog2);
console.log(dog3);
console.log(dog4);
