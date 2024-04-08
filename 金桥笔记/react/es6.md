### 一，环境搭建

+ 目前各大浏览器基本上都支持 ES6 的新特性，其中 Chrome 和 Firefox 浏览器对 ES6 新特性最友好，IE7~11 基本不支持 ES6。
+ Node.js 是运行在服务端的 JavaScript，它对 ES6 的支持度更高。如果你还不了解 Node.js 可以阅读我们的 [Node.js 教程]

### 二，let和const

let：不存在变量提升，只能在当前大括号中起效

const：声明只读变量，声明必须初始化，之后不能改变

三，解构赋值

let [a, b, c] = [1, 2, 3];
// a = 1
// b = 2
// c = 3



let {a, b, ...rest} = {a: 10, b: 20, c: 30, d: 40};
// a = 10
// b = 20
// rest = {c: 30, d: 40}



### 三，symbol

+ let sy = Symbol("KK");
  console.log(sy);   // Symbol(KK)
  typeof(sy);        // "symbol"

  // 相同参数 Symbol() 返回的值不相等
  let sy1 = Symbol("kk"); 
  sy === sy1;       // false

### 四，map和set

 Map 对象

Map 对象保存键值对。任何值(对象或者原始值) 都可以作为一个键或一个值。

Maps 和 Objects 的区别

- 一个 Object 的键只能是字符串或者 Symbols，但一个 Map 的键可以是任意值。
- Map 中的键值是有序的（FIFO 原则），而添加到对象中的键则不是。
- Map 的键值对个数可以从 size 属性获取，而 Object 的键值对个数只能手动计算。
- Object 都有自己的原型，原型链上的键名有可能和你自己在对象上的设置的键名产生冲突。
- 略

### 五，reflext与proxy略

### 六，字符串

模板字符串

模板字符串相当于加强版的字符串，用反引号 `,除了作为普通字符串，还可以用来定义多行字符串，还可以在字符串中加入变量和表达式。

**基本用法**

普通字符串

let string = `Hello'\n'world`;console.log(string); // "Hello'// 'world"

多行字符串:

let string1 =  `Hey,can you stop angry now?`;console.log(string1);// Hey,// can you stop angry now?



字符串插入变量和表达式。

变量名写在 ${} 中，${} 中可以放入 JavaScript 表达式。

let name = "Mike";let age = 27;let info = `My Name is ${name},I am ${age+1} years old next year.`console.log(info);// My Name is Mike,I am 28 years old next year.

字符串中调用函数：

function f(){  return "have fun!";}let string2= `Game start,${f()}`;console.log(string2);  // Game start,have fun!

标签模板

标签模板，是一个函数的调用，其中调用的参数是模板字符串。

alert`Hello world!`;// 等价于alert('Hello world!');

### 七，数值，略

### 八，对象

对象字面量

 属性的简洁表示法

ES6允许对象的属性直接写变量，这时候属性名是变量名，属性值是变量值。

const age = 12;const name = "Amy";const person = {age, name};person   //{age: 12, name: "Amy"}//等同于const person = {age: age, name: name}

方法名也可以简写

const person = {  sayHi(){    console.log("Hi");  }}person.sayHi();  //"Hi"//等同于const person = {  sayHi:function(){    console.log("Hi");  }}person.sayHi();//"Hi"

如果是Generator 函数，则要在前面加一个星号:

const obj = {  * myGenerator() {    yield 'hello world';  }};//等同于const obj = {  myGenerator: function* () {    yield 'hello world';  }};

属性名表达式

ES6允许用表达式作为属性名，但是一定要将表达式放在方括号内。

const obj = { ["he"+"llo"](){   return "Hi";  }}obj.hello();  //"Hi"

注意点：属性的简洁表示法和属性名表达式不能同时使用，否则会报错。

const hello = "Hello";const obj = { [hello]};obj  //SyntaxError: Unexpected token } const hello = "Hello";const obj = { [hello+"2"]:"world"};obj  //{Hello2: "world"}

对象的拓展运算符

拓展运算符（...）用于取出参数对象所有可遍历属性然后拷贝到当前对象。

 基本用法

let person = {name: "Amy", age: 15};let someone = { ...person };someone;  //{name: "Amy", age: 15}

可用于合并两个对象

let age = {age: 15};let name = {name: "Amy"};let person = {...age, ...name};person;  //{age: 15, name: "Amy"}

注意点

自定义的属性和拓展运算符对象里面属性的相同的时候：**自定义的属性在拓展运算符后面，则拓展运算符对象内部同名的属性将被覆盖掉。**

let person = {name: "Amy", age: 15};let someone = { ...person, name: "Mike", age: 17};someone;  //{name: "Mike", age: 17}

自定义的属性在拓展运算度前面，则变成设置新对象默认属性值。

let person = {name: "Amy", age: 15};let someone = {name: "Mike", age: 17, ...person};someone;  //{name: "Amy", age: 15}

拓展运算符后面是空对象，没有任何效果也不会报错。

let a = {...{}, a: 1, b: 2};a;  //{a: 1, b: 2}

拓展运算符后面是null或者undefined，没有效果也不会报错。

let b = {...null, ...undefined, a: 1, b: 2};b;  //{a: 1, b: 2}

 对象的新方法

Object.assign(target, source_1, ···)

用于将源对象的所有可枚举属性复制到目标对象中。

**基本用法**

let target = {a: 1};let object2 = {b: 2};let object3 = {c: 3};Object.assign(target,object2,object3);  // 第一个参数是目标对象，后面的参数是源对象target;  // {a: 1, b: 2, c: 3

- 如果目标对象和源对象有同名属性，或者多个源对象有同名属性，则后面的属性会覆盖前面的属性。
- 如果该函数只有一个参数，当参数为对象时，直接返回该对象；当参数不是对象时，会先将参数转为对象然后返回。

Object.assign(3);         // Number {3}typeof Object.assign(3);  // "object"

因为 null 和 undefined 不能转化为对象，所以会报错:

Object.assign(null);       // TypeError: Cannot convert undefined or null to objectObject.assign(undefined);  // TypeError: Cannot convert undefined or null to object当参数不止一个时，null 和 undefined 不放第一个，即不为目标对象时，会跳过 null 和 undefined ，不报错Object.assign(1,undefined);  // Number {1}Object.assign({a: 1},null);  // {a: 1} Object.assign(undefined,{a: 1});  // TypeError: Cannot convert undefined or null to object

**注意点**

assign 的属性拷贝是浅拷贝:

let sourceObj = { a: { b: 1}};let targetObj = {c: 3};Object.assign(targetObj, sourceObj);targetObj.a.b = 2;sourceObj.a.b;  // 2

同名属性替换

targetObj = { a: { b: 1, c:2}};sourceObj = { a: { b: "hh"}};Object.assign(targetObj, sourceObj);targetObj;  // {a: {b: "hh"}}

数组的处理

Object.assign([2,3], [5]);  // [5,3]

会将数组处理成对象，所以先将 [2,3] 转为 {0:2,1:3} ，然后再进行属性复制，所以源对象的 0 号属性覆盖了目标对象的 0。

 Object.is(value1, value2)

用来比较两个值是否严格相等，与（===）基本类似。

**基本用法**

**基本用法**

Object.is("q","q");      // trueObject.is(1,1);          // trueObject.is([1],[1]);      // falseObject.is({q:1},{q:1});  // false

与（===）的区别

//一是+0不等于-0Object.is(+0,-0);  //false+0 === -0  //true//二是NaN等于本身Object.is(NaN,NaN); //trueNaN === NaN  //false

### 九，数组

数组创建

 Array.of()

将参数中所有值作为元素形成数组。

console.log(Array.of(1, 2, 3, 4)); // [1, 2, 3, 4] // 参数值可为不同类型console.log(Array.of(1, '2', true)); // [1, '2', true] // 参数为空时返回空数组console.log(Array.of()); // []

Array.from()

将类数组对象或可迭代对象转化为数组。

// 参数为数组,返回与原数组一样的数组console.log(Array.from([1, 2])); // [1, 2] // 参数含空位console.log(Array.from([1, , 3])); // [1, undefined, 3]

**参数**

```
Array.from(arrayLike[, mapFn[, thisArg]])
```

返回值为转换后的数组。

**arrayLike**

想要转换的类数组对象或可迭代对象。

console.log(Array.from([1, 2, 3])); // [1, 2, 3]

**mapFn**

可选，map 函数，用于对每个元素进行处理，放入数组的是处理后的元素。

```
console.log(Array.from([1, 2, 3], (n) => n * 2)); // [2, 4, 6]
```

**thisArg**

可选，用于指定 map 函数执行时的 this 对象。

let map = {    do: function(n) {        return n * 2;    }}let arrayLike = [1, 2, 3];console.log(Array.from(arrayLike, function (n){    return this.do(n);}, map)); // [2, 4, 6]

类数组对象

一个类数组对象必须含有 length 属性，且元素属性名必须是数值或者可转换为数值的字符。

let arr = Array.from({  0: '1',  1: '2',  2: 3,  length: 3});console.log(arr); // ['1', '2', 3] // 没有 length 属性,则返回空数组let array = Array.from({  0: '1',  1: '2',  2: 3,});console.log(array); // [] // 元素属性名不为数值且无法转换为数值，返回长度为 length 元素值为 undefined 的数组  let array1 = Array.from({  a: 1,  b: 2,  length: 2});console.log(array1); // [undefined, undefined]

转换可迭代对象

**转换 map**

let map = new Map();map.set('key0', 'value0');map.set('key1', 'value1');console.log(Array.from(map)); // [['key0', 'value0'],['key1',// 'value1']]

**转换 set**

let arr = [1, 2, 3];let set = new Set(arr);console.log(Array.from(set)); // [1, 2, 3]

**转换字符串**

let str = 'abc';console.log(Array.from(str)); // ["a", "b", "c"]

扩展的方法

查找

**find()**

查找数组中符合条件的元素,若有多个符合条件的元素，则返回第一个元素。

let arr = Array.of(1, 2, 3, 4);console.log(arr.find(item => item > 2)); // 3 // 数组空位处理为 undefinedconsole.log([, 1].find(n => true)); // undefined

**findIndex()**

查找数组中符合条件的元素索引，若有多个符合条件的元素，则返回第一个元素索引。

let arr = Array.of(1, 2, 1, 3);// 参数1：回调函数// 参数2(可选)：指定回调函数中的 this 值console.log(arr.findIndex(item => item == 2)); // 1 // 数组空位处理为 undefinedconsole.log([, 1].findIndex(n => true)); //0

填充

**fill()**

将一定范围索引的数组元素内容填充为单个指定的值。

let arr = Array.of(1, 2, 3, 4);// 参数1：用来填充的值// 参数2：被填充的起始索引// 参数3(可选)：被填充的结束索引，默认为数组末尾console.log(arr.fill(0,1,2)); // [1, 0, 3, 4]

**copyWithin()**

将一定范围索引的数组元素修改为此数组另一指定范围索引的元素。

// 参数1：被修改的起始索引// 参数2：被用来覆盖的数据的起始索引// 参数3(可选)：被用来覆盖的数据的结束索引，默认为数组末尾console.log([1, 2, 3, 4].copyWithin(0,2,4)); // [3, 4, 3, 4] // 参数1为负数表示倒数console.log([1, 2, 3, 4].copyWithin(-2, 0)); // [1, 2, 1, 2] console.log([1, 2, ,4].copyWithin(0, 2, 4)); // [, 4, , 4]

遍历

**entries()**

遍历键值对。

for(let [key, value] of ['a', 'b'].entries()){    console.log(key, value);}// 0 "a"// 1 "b" // 不使用 for... of 循环let entries = ['a', 'b'].entries();console.log(entries.next().value); // [0, "a"]console.log(entries.next().value); // [1, "b"] // 数组含空位console.log([...[,'a'].entries()]); // [[0, undefined], [1, "a"]]

**keys()**

遍历键名。

for(let key of ['a', 'b'].keys()){    console.log(key);}// 0// 1 // 数组含空位console.log([...[,'a'].keys()]); // [0, 1]

**values()**

遍历键值。

for(let value of ['a', 'b'].values()){    console.log(value);}// "a"// "b" // 数组含空位console.log([...[,'a'].values()]); // [undefined, "a"]

 包含

**includes()**

数组是否包含指定值。

注意：与 Set 和 Map 的 has 方法区分；Set 的 has 方法用于查找值；Map 的 has 方法用于查找键名。

// 参数1：包含的指定值[1, 2, 3].includes(1);    // true // 参数2：可选，搜索的起始索引，默认为0[1, 2, 3].includes(1, 2); // false // NaN 的包含判断[1, NaN, 3].includes(NaN); // true

 嵌套数组转一维数组

**flat()**

console.log([1 ,[2, 3]].flat()); // [1, 2, 3] // 指定转换的嵌套层数console.log([1, [2, [3, [4, 5]]]].flat(2)); // [1, 2, 3, [4, 5]] // 不管嵌套多少层console.log([1, [2, [3, [4, 5]]]].flat(Infinity)); // [1, 2, 3, 4, 5] // 自动跳过空位console.log([1, [2, , 3]].flat());<p> // [1, 2, 3]

flatMap()

先对数组中每个元素进行了的处理，再对数组执行 flat() 方法。

// 参数1：遍历函数，该遍历函数可接受3个参数：当前元素、当前元素索引、原数组// 参数2：指定遍历函数中 this 的指向console.log([1, 2, 3].flatMap(n => [n * 2])); // [2, 4, 6]

 数组缓冲区

数组缓冲区是内存中的一段地址。

定型数组的基础。

实际字节数在创建时确定，之后只可修改其中的数据，不可修改大小。

创建数组缓冲区

通过构造函数创建:

let buffer = new ArrayBuffer(10);console.log(buffer.byteLength); // 10分割已有数组缓冲区let buffer = new ArrayBuffer(10);let buffer1 = buffer.slice(1, 3);console.log(buffer1.byteLength); // 2

视图

视图是用来操作内存的接口。

视图可以操作数组缓冲区或缓冲区字节的子集,并按照其中一种数值数据类型来读取和写入数据。

DataView 类型是一种通用的数组缓冲区视图,其支持所有8种数值型数据类型。

创建:

// 默认 DataView 可操作数组缓冲区全部内容let buffer = new ArrayBuffer(10);    dataView = new DataView(buffer); dataView.setInt8(0,1);console.log(dataView.getInt8(0)); // 1 // 通过设定偏移量(参数2)与长度(参数3)指定 DataView 可操作的字节范围let buffer1 = new ArrayBuffer(10);    dataView1 = new DataView(buffer1, 0, 3);dataView1.setInt8(5,1); // RangeError
 定型数组

数组缓冲区的特定类型的视图。

可以强制使用特定的数据类型，而不是使用通用的 DataView 对象来操作数组缓冲区。

 创建

通过数组缓冲区生成

let buffer = new ArrayBuffer(10),    view = new Int8Array(buffer);console.log(view.byteLength); // 10

通过构造函数

let view = new Int32Array(10);console.log(view.byteLength); // 40console.log(view.length);     // 10 // 不传参则默认长度为0// 在这种情况下数组缓冲区分配不到空间，创建的定型数组不能用来保存数据let view1 = new Int32Array();console.log(view1.byteLength); // 0console.log(view1.length);     // 0 // 可接受参数包括定型数组、可迭代对象、数组、类数组对象let arr = Array.from({  0: '1',  1: '2',  2: 3,  length: 3});let view2 = new Int16Array([1, 2]),    view3 = new Int32Array(view2),    view4 = new Int16Array(new Set([1, 2, 3])),    view5 = new Int16Array([1, 2, 3]),    view6 = new Int16Array(arr);console.log(view2 .buffer === view3.buffer); // falseconsole.log(view4.byteLength); // 6console.log(view5.byteLength); // 6console.log(view6.byteLength); // 6

 注意要点

length 属性不可写，如果尝试修改这个值，在非严格模式下会直接忽略该操作，在严格模式下会抛出错误。

let view = new Int16Array([1, 2]);view.length = 3;console.log(view.length); // 2

定型数组可使用 entries()、keys()、values()进行迭代。

let view = new Int16Array([1, 2]);for(let [k, v] of view.entries()){    console.log(k, v);}// 0 1// 1 2

find() 等方法也可用于定型数组，但是定型数组中的方法会额外检查数值类型是否安全,也会通过 Symbol.species 确认方法的返回值是定型数组而非普通数组。concat() 方法由于两个定型数组合并结果不确定，故不能用于定型数组；另外，由于定型数组的尺寸不可更改,可以改变数组的尺寸的方法，例如 splice() ，不适用于定型数组。

let view = new Int16Array([1, 2]);view.find((n) > 1); // 2

所有定型数组都含有静态 of() 方法和 from() 方法,运行效果分别与 Array.of() 方法和 Array.from() 方法相似,区别是定型数组的方法返回定型数组,而普通数组的方法返回普通数组。

let view = Int16Array.of(1, 2);console.log(view instanceof Int16Array); // true

定型数组不是普通数组，不继承自 Array 。

let view = new Int16Array([1, 2]);console.log(Array.isArray(view)); // false

定型数组中增加了 set() 与 subarray() 方法。 set() 方法用于将其他数组复制到已有定型数组, subarray() 用于提取已有定型数组的一部分形成新的定型数组。

// set 方法// 参数1：一个定型数组或普通数组// 参数2：可选，偏移量，开始插入数据的位置，默认为0let view= new Int16Array(4);view.set([1, 2]);view.set([3, 4], 2);console.log(view); // [1, 2, 3, 4] // subarray 方法// 参数1：可选，开始位置// 参数2：可选，结束位置(不包含结束位置)let view= new Int16Array([1, 2, 3, 4]),     subview1 = view.subarray(),     subview2 = view.subarray(1),     subview3 = view.subarray(1, 3);console.log(subview1); // [1, 2, 3, 4]console.log(subview2); // [2, 3, 4]console.log(subview3); // [2, 3]

扩展运算符

 复制数组

let arr = [1, 2],    arr1 = [...arr];console.log(arr1); // [1, 2] // 数组含空位let arr2 = [1, , 3],    arr3 = [...arr2];console.log(arr3); [1, undefined, 3]

合并数组

console.log([...[1, 2],...[3, 4]]); // [1, 2, 3, 4]

### 十，函数

 函数参数的扩展

默认参数

基本用法

function fn(name,age=17){ console.log(name+","+age);}fn("Amy",18);  // Amy,18fn("Amy","");  // Amy,fn("Amy");     // Amy,17

注意点：使用函数默认参数时，不允许有同名参数。

// 不报错function fn(name,name){ console.log(name);} // 报错//SyntaxError: Duplicate parameter name not allowed in this contextfunction fn(name,name,age=17){ console.log(name+","+age);}

只有在未传递参数，或者参数为 undefined 时，才会使用默认参数，null 值被认为是有效的值传递。

function fn(name,age=17){    console.log(name+","+age);}fn("Amy",null); // Amy,null

函数参数默认值存在暂时性死区，在函数参数默认值表达式中，还未初始化赋值的参数值无法作为其他参数的默认值。

function f(x,y=x){    console.log(x,y);}f(1);  // 1 1 function f(x=y){    console.log(x);}f();  // ReferenceError: y is not defined

 不定参数

不定参数用来表示不确定参数个数，形如，...变量名，由...加上一个具名参数标识符组成。具名参数只能放在参数组的最后，并且有且只有一个不定参数。

基本用法

function f(...values){    console.log(values.length);}f(1,2);      //2f(1,2,3,4);  //4

###十一 箭头函数

箭头函数提供了一种更加简洁的函数书写方式。基本语法是：

```
参数 => 函数体
```

基本用法：

var f = v => v;//等价于var f = function(a){ return a;}f(1);  //1

当箭头函数没有参数或者有多个参数，要用 () 括起来。

var f = (a,b) => a+b;f(6,2);  //8

当箭头函数函数体有多行语句，用 {} 包裹起来，表示代码块，当只有一行语句，并且需要返回结果时，可以省略 {} , 结果会自动返回。

var f = (a,b) => { let result = a+b; return result;}f(6,2);  // 8

当箭头函数要返回对象的时候，为了区分于代码块，要用 () 将对象包裹起来

// 报错var f = (id,name) => {id: id, name: name};f(6,2);  // SyntaxError: Unexpected token : // 不报错var f = (id,name) => ({id: id, name: name});f(6,2);  // {id: 6, name: 2}

注意点：没有 this、super、arguments 和 new.target 绑定。

var func = () => {  // 箭头函数里面没有 this 对象，  // 此时的 this 是外层的 this 对象，即 Window   console.log(this)}func(55)  // Window  var func = () => {      console.log(arguments)}func(55);  // ReferenceError: arguments is not defined

箭头函数体中的 this 对象，是定义函数时的对象，而不是使用函数时的对象。

function fn(){  setTimeout(()=>{    // 定义时，this 绑定的是 fn 中的 this 对象    console.log(this.a);  },0)}var a = 20;// fn 的 this 对象为 {a: 18}fn.call({a: 18});  // 18

不可以作为构造函数，也就是不能使用 new 命令，否则会报错

适合使用的场景

ES6 之前，JavaScript 的 this 对象一直很令人头大，回调函数，经常看到 var self = this 这样的代码，为了将外部 this 传递到回调函数中，那么有了箭头函数，就不需要这样做了，直接使用 this 就行。

// 回调函数var Person = {    'age': 18,    'sayHello': function () {      setTimeout(function () {        console.log(this.age);      });    }};var age = 20;Person.sayHello();  // 20 var Person1 = {    'age': 18,    'sayHello': function () {      setTimeout(()=>{        console.log(this.age);      });    }};var age = 20;Person1.sayHello();  // 18

所以，当我们需要维护一个 this 上下文的时候，就可以使用箭头函数。

不适合使用的场景

定义函数的方法，且该方法中包含 this

var Person = {    'age': 18,    'sayHello': ()=>{        console.log(this.age);      }};var age = 20;Person.sayHello();  // 20// 此时 this 指向的是全局对象 var Person1 = {    'age': 18,    'sayHello': function () {        console.log(this.age);    }};var age = 20;Person1.sayHello();   // 18// 此时的 this 指向 Person1 对象

需要动态 this 的时候

var button = document.getElementById('userClick');button.addEventListener('click', () => {     this.classList.toggle('on');});

button 的监听函数是箭头函数，所以监听函数里面的 this 指向的是定义的时候外层的 this 对象，即 Window，导致无法操作到被点击的按钮对象。

### 十二，类

概述

在ES6中，class (类)作为对象的模板被引入，可以通过 class 关键字定义类。

class 的本质是 function。

它可以看作一个语法糖，让对象原型的写法更加清晰、更像面向对象编程的语法。

基础用法

类定义

类表达式可以为匿名或命名。

// 匿名类let Example = class {    constructor(a) {        this.a = a;    }}// 命名类let Example = class Example {    constructor(a) {        this.a = a;    }}

类声明

class Example {    constructor(a) {        this.a = a;    }}

注意要点：不可重复声明。

class Example{}class Example{}// Uncaught SyntaxError: Identifier 'Example' has already been // declared let Example1 = class{}class Example{}// Uncaught SyntaxError: Identifier 'Example' has already been // declared

注意要点

类定义不会被提升，这意味着，必须在访问前对类进行定义，否则就会报错。

类中方法不需要 function 关键字。

方法间不能加分号。

new Example(); class Example {}

类的主体

**属性**

prototype

ES6 中，prototype 仍旧存在，虽然可以直接自类中定义方法，但是其实方法还是定义在 prototype 上的。 覆盖方法 / 初始化时添加方法

Example.prototype={    //methods}

添加方法

Object.assign(Example.prototype,{    //methods})

静态属性

静态属性：class 本身的属性，即直接定义在类内部的属性（ Class.propname ），不需要实例化。 ES6 中规定，Class 内部只有静态方法，没有静态属性。

class Example {// 新提案    static a = 2;}// 目前可行写法Example.b = 2;

公共属性

class Example{}Example.prototype.a = 2;

实例属性

实例属性：定义在实例对象（ this ）上的属性。

class Example {    a = 2;    constructor () {        console.log(this.a);    }}

name 属性

返回跟在 class 后的类名(存在时)。

let Example=class Exam {    constructor(a) {        this.a = a;    }}console.log(Example.name); // Exam let Example=class {    constructor(a) {        this.a = a;    }}console.log(Example.name); // Example

**方法**

constructor 方法

constructor 方法是类的默认方法，创建类的实例化对象时被调用。

class Example{    constructor(){      console.log('我是constructor');    }}new Example(); // 我是constructor

返回对象

class Test {    constructor(){        // 默认返回实例对象 this    }}console.log(new Test() instanceof Test); // true class Example {    constructor(){        // 指定返回对象        return new Test();    }}console.log(new Example() instanceof Example); // false

静态方法

class Example{    static sum(a, b) {        console.log(a+b);    }}Example.sum(1, 2); // 3

原型方法

class Example {    sum(a, b) {        console.log(a + b);    }}let exam = new Example();exam.sum(1, 2); // 3

实例方法

class Example {    constructor() {        this.sum = (a, b) => {            console.log(a + b);        }    }}

类的实例化

**new**

class 的实例化必须通过 new 关键字。

class Example {} let exam1 = Example(); // Class constructor Example cannot be invoked without 'new'

**实例化对象**

共享原型对象

class Example {    constructor(a, b) {        this.a = a;        this.b = b;        console.log('Example');    }    sum() {        return this.a + this.b;    }}let exam1 = new Example(2, 1);let exam2 = new Example(3, 1); // __proto__ 已废弃，不建议使用// console.log(exam1.__proto__ == exam2.__proto__);  console.log(Object.getPrototypeOf(exam1) === Object.getPrototypeOf(exam2));// true Object.getPrototypeOf(exam1).sub = function() {    return this.a - this.b;}console.log(exam1.sub()); // 1console.log(exam2.sub()); // 2

 decorator

decorator 是一个函数，用来修改类的行为，在代码编译时产生作用。

 类修饰

一个参数

第一个参数 target，指向类本身。

function testable(target) {    target.isTestable = true;}@testableclass Example {}Example.isTestable; // true

多个参数——嵌套实现

function testable(isTestable) {    return function(target) {        target.isTestable=isTestable;    }}@testable(true)class Example {}Example.isTestable; // true

实例属性

上面两个例子添加的是静态属性，若要添加实例属性，在类的 prototype 上操作即可。

 方法修饰

3个参数：target（类的原型对象）、name（修饰的属性名）、descriptor（该属性的描述对象）。

class Example {    @writable    sum(a, b) {        return a + b;    }}function writable(target, name, descriptor) {    descriptor.writable = false;    return descriptor; // 必须返回}

修饰器执行顺序

由外向内进入，由内向外执行。

class Example {    @logMethod(1)    @logMethod(2)    sum(a, b){        return a + b;    }}function logMethod(id) {    console.log('evaluated logMethod'+id);    return (target, name, desctiptor) => console.log('excuted         logMethod '+id);}// evaluated logMethod 1// evaluated logMethod 2// excuted logMethod 2// excuted logMethod 1

封装与继承

getter / setter

定义

class Example{    constructor(a, b) {        this.a = a; // 实例化时调用 set 方法        this.b = b;    }    get a(){        console.log('getter');        return this.a;    }    set a(a){        console.log('setter');        this.a = a; // 自身递归调用    }}let exam = new Example(1,2); // 不断输出 setter ，最终导致 RangeErrorclass Example1{    constructor(a, b) {        this.a = a;        this.b = b;    }    get a(){        console.log('getter');        return this._a;    }    set a(a){        console.log('setter');        this._a = a;    }}let exam1 = new Example1(1,2); // 只输出 setter , 不会调用 getter 方法console.log(exam1._a); // 1, 可以直接访问

getter 不可单独出现

class Example {    constructor(a) {        this.a = a;     }    get a() {        return this.a;    }}let exam = new Example(1); // Uncaught TypeError: Cannot set property // a of #<Example> which has only a getter

getter 与 setter 必须同级出现

class Father {    constructor(){}    get a() {        return this._a;    }}class Child extends Father {    constructor(){        super();    }    set a(a) {        this._a = a;    }}let test = new Child();test.a = 2;console.log(test.a); // undefined class Father1 {    constructor(){}    // 或者都放在子类中    get a() {        return this._a;    }    set a(a) {        this._a = a;    }}class Child1 extends Father1 {    constructor(){        super();    }}let test1 = new Child1();test1.a = 2;console.log(test1.a); // 2

extends

通过 extends 实现类的继承。

class Child extends Father { ... }

super

子类 constructor 方法中必须有 super ，且必须出现在 this 之前。

class Father {    constructor() {}}class Child extends Father {    constructor() {}    // or     // constructor(a) {        // this.a = a;        // super();    // }}let test = new Child(); // Uncaught ReferenceError: Must call super // constructor in derived class before accessing 'this' or returning // from derived constructor

调用父类构造函数,只能出现在子类的构造函数。

class Father {    test(){        return 0;    }    static test1(){        return 1;    }}class Child extends Father {    constructor(){        super();    }}class Child1 extends Father {    test2() {        super(); // Uncaught SyntaxError: 'super' keyword unexpected             // here    }}

调用父类方法, super 作为对象，在普通方法中，指向父类的原型对象，在静态方法中，指向父类

class Child2 extends Father {    constructor(){        super();        // 调用父类普通方法        console.log(super.test()); // 0    }    static test3(){        // 调用父类静态方法        return super.test1+2;    }}Child2.test3(); // 3

注意要点

不可继承常规对象。

var Father = {    // ...}class Child extends Father {     // ...}// Uncaught TypeError: Class extends value #<Object> is not a constructor or null // 解决方案Object.setPrototypeOf(Child.prototype, Father);

### 十三，模块化

 概述

在 ES6 前， 实现模块化使用的是 RequireJS 或者 seaJS（分别是基于 AMD 规范的模块化库，  和基于 CMD 规范的模块化库）。

ES6 引入了模块化，其设计思想是在编译时就能确定模块的依赖关系，以及输入和输出的变量。

ES6 的模块化分为导出（export） @与导入（import）两个模块。

特点

ES6 的模块自动开启严格模式，不管你有没有在模块头部加上 use strict;。

模块中可以导入和导出各种类型的变量，如函数，对象，字符串，数字，布尔值，类等。

每个模块都有自己的上下文，每一个模块内声明的变量都是局部变量，不会污染全局作用域。

每一个模块只加载一次（是单例的）， 若再去加载同目录下同文件，直接从内存中读取。

export 与 import

 基本用法

模块导入导出各种类型的变量，如字符串，数值，函数，类。

- 导出的函数声明与类声明必须要有名称（export default 命令另外考虑）。 
- 不仅能导出声明还能导出引用（例如函数）。
- export 命令可以出现在模块的任何位置，但必需处于模块顶层。
- import 命令会提升到整个模块的头部，首先执行。

/*-----export [test.js]-----*/let myName = "Tom";let myAge = 20;let myfn = function(){    return "My name is" + myName + "! I'm '" + myAge + "years old."}let myClass =  class myClass {    static a = "yeah!";}export { myName, myAge, myfn, myClass } /*-----import [xxx.js]-----*/import { myName, myAge, myfn, myClass } from "./test.js";console.log(myfn());// My name is Tom! I'm 20 years old.console.log(myAge);// 20console.log(myName);// Tomconsole.log(myClass.a );// yeah!

建议使用大括号指定所要输出的一组变量写在文档尾部，明确导出的接口。

函数与类都需要有对应的名称，导出文档尾部也避免了无对应名称。

as 的用法

export 命令导出的接口名称，须和模块内部的变量有一一对应关系。

导入的变量名，须和导出的接口名称相同，即顺序可以不一致。

/*-----export [test.js]-----*/let myName = "Tom";export { myName as exportName } /*-----import [xxx.js]-----*/import { exportName } from "./test.js";console.log(exportName);// Tom使用 as 重新定义导出的接口名称，隐藏模块内部的变量/*-----export [test1.js]-----*/let myName = "Tom";export { myName }/*-----export [test2.js]-----*/let myName = "Jerry";export { myName }/*-----import [xxx.js]-----*/import { myName as name1 } from "./test1.js";import { myName as name2 } from "./test2.js";console.log(name1);// Tomconsole.log(name2);// Jerry

不同模块导出接口名称命名重复， 使用 as 重新定义变量名。

import 命令的特点

**只读属性**：不允许在加载模块的脚本里面，改写接口的引用指向，即可以改写 import 变量类型为对象的属性值，不能改写 import 变量类型为基本类型的值。

import {a} from "./xxx.js"a = {}; // error import {a} from "./xxx.js"a.foo = "hello"; // a = { foo : 'hello' }

**单例模式**：多次重复执行同一句 import 语句，那么只会执行一次，而不会执行多次。import 同一模块，声明不同接口引用，会声明对应变量，但只执行一次 import 。

import { a } "./xxx.js";import { a } "./xxx.js";// 相当于 import { a } "./xxx.js"; import { a } from "./xxx.js";import { b } from "./xxx.js";// 相当于 import { a, b } from "./xxx.js";

静态执行特性：import 是静态执行，所以不能使用表达式和变量。

import { "f" + "oo" } from "methods";// errorlet module = "methods";import { foo } from module;// errorif (true) {  import { foo } from "method1";} else {  import { foo } from "method2";}// error

export default 命令

- 在一个文件或模块中，export、import 可以有多个，export default 仅有一个。
- export default 中的 default 是对应的导出接口变量。
- 通过 export 方式导出，在导入时要加{ }，export default 则不需要。
- export default 向外暴露的成员，可以使用任意变量来接收。

var a = "My name is Tom!";export default a; // 仅有一个export default var c = "error"; // error，default 已经是对应的导出变量，不能跟着变量声明语句 import b from "./xxx.js"; // 不需要加{}， 使用任意变量接收

复合使用

> **注**：import() 是提案，这边暂时不延伸讲解。

export 与 import 可以在同一模块使用，使用特点：

- 可以将导出接口改名，包括 default。
- 复合使用 export 与 import ，也可以导出全部，当前模块导出的接口会覆盖继承导出的。

export { foo, bar } from "methods"; // 约等于下面两段语句，不过上面导入导出方式该模块没有导入 foo 与 barimport { foo, bar } from "methods";export { foo, bar }; /* ------- 特点 1 --------*/// 普通改名export { foo as bar } from "methods";// 将 foo 转导成 defaultexport { foo as default } from "methods";// 将 default 转导成 fooexport { default as foo } from "methods"; /* ------- 特点 2 --------*/export * from "methods";

### promise对象

概述
是异步编程的一种解决方案。

从语法上说，Promise 是一个对象，从它可以获取异步操作的消息。

Promise 状态

状态的特点

Promise 异步操作有三种状态：pending（进行中）、fulfilled（已成功）和 rejected（已失败）。除了异步操作的结果，任何其他操作都无法改变这个状态。

Promise 对象只有：从 pending 变为 fulfilled 和从 pending 变为 rejected 的状态改变。只要处于 fulfilled 和 rejected ，状态就不会再变了即 resolved（已定型）。

const p1 = new Promise(function(resolve,reject){    resolve('success1');    resolve('success2');}); const p2 = new Promise(function(resolve,reject){      resolve('success3');     reject('reject');});p1.then(function(value){      console.log(value); // success1});p2.then(function(value){     console.log(value); // success3});

状态的缺点

无法取消 Promise ，一旦新建它就会立即执行，无法中途取消。

如果不设置回调函数，Promise 内部抛出的错误，不会反应到外部。

当处于 pending 状态时，无法得知目前进展到哪一个阶段（刚刚开始还是即将完成）。

 then 方法

then 方法接收两个函数作为参数，第一个参数是 Promise 执行成功时的回调，第二个参数是 Promise 执行失败时的回调，两个函数只会有一个被调用。

 then 方法的特点

在 JavaScript 事件队列的当前运行完成之前，回调函数永远不会被调用。

const p = new Promise(function(resolve,reject){  resolve('success');}); p.then(function(value){  console.log(value);}); console.log('first');// first// success

通过 .then 形式添加的回调函数，不论什么时候，都会被调用。

通过多次调用

.then

，可以添加多个回调函数，它们会按照插入顺序并且独立运行。

const p = new Promise(function(resolve,reject){  resolve(1);}).then(function(value){ // 第一个then // 1  console.log(value);  return value * 2;}).then(function(value){ // 第二个then // 2  console.log(value);}).then(function(value){ // 第三个then // undefined  console.log(value);  return Promise.resolve('resolve'); }).then(function(value){ // 第四个then // resolve  console.log(value);  return Promise.reject('reject'); }).then(function(value){ // 第五个then //reject:reject  console.log('resolve:' + value);}, function(err) {  console.log('reject:' + err);});

then 方法将返回一个 resolved 或 rejected 状态的 Promise 对象用于链式调用，且 Promise 对象的值就是这个返回值。

 then 方法注意点

简便的 Promise 链式编程最好保持扁平化，不要嵌套 Promise。

注意总是返回或终止 Promise 链。

const p1 = new Promise(function(resolve,reject){  resolve(1);}).then(function(result) {  p2(result).then(newResult => p3(newResult));}).then(() => p4());

创建新 Promise 但忘记返回它时，对应链条被打破，导致 p4 会与 p2 和 p3 同时进行。

大多数浏览器中不能终止的 Promise 链里的 rejection，建议后面都跟上 .catch(error => console.log(error));

### Generator，函数，异步编程，

ES6 新引入了 Generator 函数，可以通过 yield 关键字，把函数的执行流挂起，为改变执行流程提供了可能，从而为异步编程提供解决方案。 基本用法

 Generator 函数组成

Generator 有两个区分于普通函数的部分：

- 一是在 function 后面，函数名之前有个 * ；
- 函数内部有 yield 表达式。

其中 * 用来表示函数为 Generator 函数，yield 用来定义函数内部的状态。

function* func(){ console.log("one"); yield '1'; console.log("two"); yield '2';  console.log("three"); return '3';}

执行机制

调用 Generator 函数和调用普通函数一样，在函数名后面加上()即可，但是 Generator 函数不会像普通函数一样立即执行，而是返回一个指向内部状态对象的指针，所以要调用遍历器对象Iterator 的 next 方法，指针就会从函数头部或者上一次停下来的地方开始执行。

f.next();// one// {value: "1", done: false} f.next();// two// {value: "2", done: false} f.next();// three// {value: "3", done: true} f.next();// {value: undefined, done: true}

第一次调用 next 方法时，从 Generator 函数的头部开始执行，先是打印了 one ,执行到 yield 就停下来，并将yield 后边表达式的值 '1'，作为返回对象的 value 属性值，此时函数还没有执行完， 返回对象的 done 属性值是 false。

第二次调用 next 方法时，同上步 。

第三次调用 next 方法时，先是打印了 three ，然后执行了函数的返回操作，并将 return 后面的表达式的值，作为返回对象的 value 属性值，此时函数已经结束，多以 done 属性值为true 。

第四次调用 next 方法时， 此时函数已经执行完了，所以返回 value 属性值是 undefined ，done 属性值是 true 。如果执行第三步时，没有 return 语句的话，就直接返回 {value: undefined, done: true}。

 函数返回的遍历器对象的方法

**next 方法**

一般情况下，next 方法不传入参数的时候，yield 表达式的返回值是 undefined 。当 next 传入参数的时候，该参数会作为上一步yield的返回值。

function* sendParameter(){    console.log("start");    var x = yield '2';    console.log("one:" + x);    var y = yield '3';    console.log("two:" + y);    console.log("total:" + (x + y));}

next不传参

var sendp1 = sendParameter();sendp1.next();// start// {value: "2", done: false}sendp1.next();// one:undefined// {value: "3", done: false}sendp1.next();// two:undefined// total:NaN// {value: undefined, done: true}next传参var sendp2 = sendParameter();sendp2.next(10);// start// {value: "2", done: false}sendp2.next(20);// one:20// {value: "3", done: false}sendp2.next(30);// two:30// total:50// {value: undefined, done: true}

除了使用 next ，还可以使用 for... of 循环遍历 Generator 函数生产的 Iterator 对象。

**return 方法**

return 方法返回给定值，并结束遍历 Generator 函数。

return 方法提供参数时，返回该参数；不提供参数时，返回 undefined 。

function* foo(){    yield 1;    yield 2;    yield 3;}var f = foo();f.next();// {value: 1, done: false}f.return("foo");// {value: "foo", done: true}f.next();// {value: undefined, done: true}throw 方法throw 方法可以再 Generator 函数体外面抛出异常，再函数体内部捕获。var g = function* () {  try {    yield;  } catch (e) {    console.log('catch inner', e);  }}; var i = g();i.next(); try {  i.throw('a');  i.throw('b');} catch (e) {  console.log('catch outside', e);}// catch inner a// catch outside b

遍历器对象抛出了两个错误，第一个被 Generator 函数内部捕获，第二个因为函数体内部的catch 函数已经执行过了，不会再捕获这个错误，所以这个错误就抛出 Generator 函数体，被函数体外的 catch 捕获。

**yield\* 表达式**

yield* 表达式表示 yield 返回一个遍历器对象，用于在 Generator 函数内部，调用另一个 Generator 函数。

function* callee() {    console.log('callee: ' + (yield));}function* caller() {    while (true) {        yield* callee();    }}const callerObj = caller();callerObj.next();// {value: undefined, done: false}callerObj.next("a");// callee: a// {value: undefined, done: false}callerObj.next("b");// callee: b// {value: undefined, done: false} // 等同于function* caller() {    while (true) {        for (var value of callee) {          yield value;        }    }}

使用场景
**实现 Iterator**

为不具备 Iterator 接口的对象提供遍历方法。

function* objectEntries(obj) {    const propKeys = Reflect.ownKeys(obj);    for (const propKey of propKeys) {        yield [propKey, obj[propKey]];    }} const jane = { first: 'Jane', last: 'Doe' };for (const [key,value] of objectEntries(jane)) {    console.log(`${key}: ${value}`);}// first: Jane// last: Doe

Reflect.ownKeys() 返回对象所有的属性，不管属性是否可枚举，包括 Symbol。

jane 原生是不具备 Iterator 接口无法通过 for... of遍历。这边用了 Generator 函数加上了 Iterator 接口，所以就可以遍历 jane 对象了。

### assyns函数

async

async 是 ES7 才有的与异步操作有关的关键字，和 Promise ， Generator 有很大关联的。

语法

```
async function name([param[, param[, ... param]]]) { statements }
```

- name: 函数名称。
- param: 要传递给函数的参数的名称。
- statements: 函数体语句。

 返回值

async 函数返回一个 Promise 对象，可以使用 then 方法添加回调函数。

async function helloAsync(){    return "helloAsync";  }  console.log(helloAsync())  // Promise {<resolved>: "helloAsync"} helloAsync().then(v=>{   console.log(v);         // helloAsync})

async 函数中可能会有 await 表达式，async 函数执行时，如果遇到 await 就会先暂停执行 ，等到触发的异步操作完成后，恢复 async 函数的执行并返回解析值。

await 关键字仅在 async function 中有效。如果在 async function 函数体外使用 await ，你只会得到一个语法错误。

function testAwait(){   return new Promise((resolve) => {       setTimeout(function(){          console.log("testAwait");          resolve();       }, 1000);   });} async function helloAsync(){   await testAwait();   console.log("helloAsync"); }helloAsync();// testAwait// helloAsync

await

await 操作符用于等待一个 Promise 对象, 它只能在异步函数 async function 内部使用。

 语法

```
[return_value] = await expression;
```

- expression: 一个 Promise 对象或者任何要等待的值。

 返回值

返回 Promise 对象的处理结果。如果等待的不是 Promise 对象，则返回该值本身。

如果一个 Promise 被传递给一个 await 操作符，await 将等待 Promise 正常处理完成并返回其处理结果。

function testAwait (x) {  return new Promise(resolve => {    setTimeout(() => {      resolve(x);    }, 2000);  });} async function helloAsync() {  var x = await testAwait ("hello world");  console.log(x); }helloAsync ();// hello world

正常情况下，await 命令后面是一个 Promise 对象，它也可以跟其他值，如字符串，布尔值，数值以及普通函数。

function testAwait(){   console.log("testAwait");}async function helloAsync(){   await testAwait();   console.log("helloAsync");}helloAsync();// testAwait// helloAsync

await针对所跟不同表达式的处理方式：

- Promise 对象：await 会暂停执行，等待 Promise 对象 resolve，然后恢复 async 函数的执行并返回解析值。
- 非 Promise 对象：直接返回对应的值。


### 异步相关

+ Promise对象，里面放一个将来才会执行的方法，比如settimeout（），使用了promise后，将会异步执行，promise里面的方法没有执行完，就可以执行后面的方法，后面可以加.then()，里面可以放两个或者一个方法，第一个方法参数是异步执行成功的参数，第二个是执行失败的参数。
+ async 返回值是一个promise对象，async里面的promise方法前加上await关键字，就可以取消promise的异步。