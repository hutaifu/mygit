(function () {
   //定义一个表示人的类
    class Person{
        //ts可以在属性前添加属性修饰符
        public _name:string;//默认值
        private _age:number;//私有属性，只能在当前类内部进行修改
        protected _size:string;//受保护属性，只能在当前类和子类中访问

        constructor(name:string,age:number,size:string){
            this._name = name;
            this._age = age;
            this._size = size;
        }

    }

    const per = new Person("孙悟空",18,"ksjf");

    /**
     *
     * 现在属性是直接在对象中设置的，属性可以被任意修改
     * 属性可以被任意修改会导致对象中的数据变得不安全
     */
    per._name = "猪八戒"
    // per._age = -39;


    class C{
        //可以直接将属性定义在构造函数中
        constructor(public name:string,public age:number){

        }
    }

    let c = new C("测试",30);


})()