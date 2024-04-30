(function () {
   //描述一个对象的类型
    type myType = {
        name:string,
        age:number,
    }

    const obj:myType = {
        name:'sss',
        age:111,
    }

/*    type myType = {

    }*/



    /**
     * 接口用来定义也给类的结构,用来定义一个类中应该包含哪些属性和方法，同时接口也可以当作类型声明使用
     * 类型声明不能重复声明
     * 接口可以重复声明
     *
     *
     */


    interface myInterface{
        name:string;
        age:number;
    }

    interface myInterface{
        gender:string;
    }

    const boj1:myInterface = {
        name:'sss',
        age:111,
        gender:"男"
    };

    /**
     * 接口可以在定义类的时候去限制类的结构
     * 接口中所有的属性不能有试剂值，
     * 接口指定要对象结构，而不考虑试剂值
     */

    interface myInter{
        name:string,
        sayHello():void
    }

    /**
     * 定义类时，可以使类去实现一个接口
     *
     *
     */
    class MyClass implements myInter{
        name:string;
        sayHello(){

        }
        constructor(name:string){
            this.name = name;
        }
    }

    //接口就是定义一个规范，只要你满足了这个规范，就能在某个场景应用，
    //接口就是对类的限制



})();