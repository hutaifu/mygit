"use strict";
(function () {
    var obj = {
        name: 'sss',
        age: 111,
    };
    var boj1 = {
        name: 'sss',
        age: 111,
        gender: "男"
    };
    /**
     * 定义类时，可以使类去实现一个接口
     *
     *
     */
    var MyClass = /** @class */ (function () {
        function MyClass(name) {
            this.name = name;
        }
        MyClass.prototype.sayHello = function () {
        };
        return MyClass;
    }());
    //接口就是定义一个规范，只要你满足了这个规范，就能在某个场景应用，
    //接口就是对类的限制
})();
//# sourceMappingURL=%E6%8E%A5%E5%8F%A3.js.map