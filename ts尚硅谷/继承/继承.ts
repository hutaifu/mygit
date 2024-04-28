(function () {
    //定义一个表示狗的类
    class Dog {
        name: string;
        age: number;

        constructor(name: string, age: number) {
            this.name = name;
            this.age = age;
        }

        sayHello() {
            console.log("汪汪汪！")
        }
    }

    class Cat {
        name: string;
        age: number;

        constructor(name: string, age: number) {
            this.name = name;
            this.age = age;
        }

        sayHello() {
            console.log("喵喵喵！")
        }
    }

    const dog = new Dog("旺财", 5);
    const cat = new Cat("猫1",5)


    //限制抽象类，不能创建对象
    abstract class Animal{
        name: string;
        age: number;

        constructor(name: string, age: number) {
            this.name = name;
            this.age = age;
        }

        sayHello() {
            console.log("动物在叫")
        }

        //抽象方法，只能定义在抽象类中，子类必须对抽象方法进行重写
        abstract sayMyHello():void;
    }

    //使dog类继承animal类
    class Dog1 extends Animal{
        run(){
            console.log("狗在跑")
        }
        sayMyHello() {
        }

        //支持方法重写
        //super代表父类
        sayHello() {
            super.sayHello();
        }

        constructor(name:string,age:number) {
            //如果子类写了构造函数，必须要调用父类的构造函数
            super(name,age);
        }
    }

    //使cat类继承animal类
    //继承后，子类拥有父类的所有方法
    class Cat1 extends Animal{
        sayMyHello() {
        }
    }








})()