"use strict";
(function () {
    //定义一个表示人的类
    class Person {
        constructor(name, age, size) {
            this._name = name;
            this._age = age;
            this._size = size;
        }
    }
    const per = new Person("孙悟空", 18, "ksjf");
    /**
     *
     * 现在属性是直接在对象中设置的，属性可以被任意修改
     * 属性可以被任意修改会导致对象中的数据变得不安全
     */
    per._name = "猪八戒";
    // per._age = -39;
    class C {
        //可以直接将属性定义在构造函数中
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }
    }
    let c = new C("测试", 30);
})();
//# sourceMappingURL=%E5%B1%9E%E6%80%A7%E5%B0%81%E8%A3%85.js.map