## TS

### 一，介绍

+ TypeScript 是 JavaScript 的一个超集，支持 ECMAScript 6 标准（[ES6 教程](https://www.runoob.com/w3cnote/es6-tutorial.html)）。

  TypeScript 由微软开发的自由和开源的编程语言。

  TypeScript 设计目标是开发大型应用，它可以编译成纯 JavaScript，编译出来的 JavaScript 可以运行在任何浏览器上

### 二、安装

+ ```
  npm install -g typescript
  ```

+ 然后我们新建一个 app.ts 的文件，代码如下：

+ ```
  var message:string = "Hello World" 
  console.log(message)
  ```

+ 通常我们使用 .ts 作为 TypeScript 代码文件的扩展名。

  然后执行以下命令将 TypeScript 转换为 JavaScript 代码：

+ ```
  $ node app.js 
  Hello World
  ```

### 三、基础类型

+ 任意类型：any

+ 数字类型：number

+ 字符串类型：string

+ 布尔类型：Boolean

+ 数组类型：number【】

+ 元组:已知元素数量和类型的数组【string，number】

+ 枚举  enum     Color【red，creen，blue】

+ void 方法没有返回值 function hello（）void{}

+ null   对象缺失

+ undefined 用于初始化一个未定义值

+ never 其他类型的子类型，代表从不会出现的值

+ 任意值是 TypeScript 针对编程时类型不明确的变量使用的一种数据类型，它常用于以下三种情况。

  1、变量的值会动态改变时，比如来自用户的输入，任意值类型可以让这些变量跳过编译阶段的类型检查，示例代码如下：

  ```
  let x: any = 1;    // 数字类型
  x = 'I am who I am';    // 字符串类型
  x = false;    // 布尔类型
  ```

+ 改写现有代码时，任意值允许在编译时可选择地包含或移除类型检查，示例代码如下

+ ```
  let x: any = 4;
  x.ifItExists();    // 正确，ifItExists方法在运行时可能存在，但这里并不会检查
  x.toFixed();    // 正确
  ```

+ 定义存储各种类型数据的数组时，示例代码如下

+ ```
  let arrayList: any[] = [1, false, 'fine'];
  arrayList[1] = 100;
  ```

+ ### null

  在 JavaScript 中 null 表示 "什么都没有"。

  null是一个只有一个值的特殊类型。表示一个空对象引用。

  用 typeof 检测 null 返回是 object。

+ ### undefined

  在 JavaScript 中, undefined 是一个没有设置值的变量。

  typeof 一个没有值的变量会返回 undefined。

  Null 和 Undefined 是其他任何类型（包括 void）的子类型，可以赋值给其它类型，如数字类型，此时，赋值后的类型会变成 null 或 undefined。而在TypeScript中启用严格的空校验（--strictNullChecks）特性，就可以使得null 和 undefined 只能被赋值给 void 或本身对应的类型，示例代码如下：

+ ## never 类型

  never 是其它类型（包括 null 和 undefined）的子类型，代表从不会出现的值。这意味着声明为 never 类型的变量只能被 never 类型所赋值，在函数中它通常表现为抛出异常或无法执行到终止点（例如无限循环），示例代码如下：

+ ```
  let x: never;
  let y: number;

  // 编译错误，数字类型不能转为 never 类型
  x = 123;

  // 运行正确，never 类型可以赋值给 never类型
  x = (()=>{ throw new Error('exception')})();

  // 运行正确，never 类型可以赋值给 数字类型
  y = (()=>{ throw new Error('exception')})();

  // 返回值为 never 的函数可以是抛出异常的情况
  function error(message: string): never {
      throw new Error(message);
  }

  // 返回值为 never 的函数可以是无法被执行到的终止点的情况
  function loop(): never {
      while (true) {}
  }
  ```

### ts变量声明

+ 变量是一种使用方便的占位符，用于引用计算机内存地址。

  我们可以把变量看做存储数据的容器。

  TypeScript 变量的命名规则：

  - 变量名称可以包含数字和字母。
  - 除了下划线 _ 和美元 $ 符号外，不能包含其他特殊字符，包括空格。
  - 变量名不能以数字开头。

  变量使用前必须先声明，我们可以使用 var 来声明变量。

  我们可以使用以下四种方式来声明变量：

  声明变量的类型及初始值：

+ ```
  var [变量名] : [类型] = 值;
  ```

+ 声明变量的类型，但没有初始值，变量值会设置为 undefined：

+ ```
  var [变量名] : [类型];
  ```

+ 声明变量并初始值，但不设置类型，该变量可以是任意类型：

+ ```
  var [变量名] = 值;
  ```

+ 声明变量没有设置类型和初始值，类型可以是任意类型，默认初始值为 undefined：

+ ```
  var [变量名];
  ```

+ 类型断言

+ 类型断言可以用来手动指定一个值的类型，即允许变量从一种类型更改为另一种类型。

  语法格式：

+ ```
  var str = '1' 
  var str2:number = <number> <any> str   //str、str2 是 string 类型
  console.log(str2)
  ```

+ 当类型没有给出时，TypeScript 编译器利用类型推断来推断类型。

  如果由于缺乏声明而不能推断出类型，那么它的类型被视作默认的动态 any 类型。

+ ```
  var num = 2;    // 类型推断为 number
  console.log("num 变量的值为 "+num); 
  num = "12";    // 编译错误
  console.log(num);
  ```

### 变量作用域

+ 变量作用域指定了变量定义的位置。

  程序中变量的可用性由变量作用域决定。

  TypeScript 有以下几种作用域：

  - **全局作用域** − 全局变量定义在程序结构的外部，它可以在你代码的任何位置使用。
  - **类作用域** − 这个变量也可以称为 **字段**。类变量声明在一个类里头，但在类的方法外面。 该变量可以通过类的对象来访问。类变量也可以是静态的，静态的变量可以通过类名直接访问。
  - **局部作用域** − 局部变量，局部变量只能在声明它的一个代码块（如：方法）中使用。

+ ```
  var global_num = 12          // 全局变量
  class Numbers { 
     num_val = 13;             // 实例变量
     static sval = 10;         // 静态变量
     
     storeNum():void { 
        var local_num = 14;    // 局部变量
     } 
  } 
  console.log("全局变量为: "+global_num)  
  console.log(Numbers.sval)   // 静态变量
  var obj = new Numbers(); 
  console.log("实例变量: "+obj.num_val)
  ```

### ts运算符

### 循环

+ for...in 语句用于一组值的集合或列表进行迭代输出

+ ```
  for (var val in list) { 
      //语句 
  }
  ```

+ ```
  var j:any; 
  var n:any = "a b c" 
   
  for(j in n) {
      console.log(n[j])  
  }
  ```

+ 此外，TypeScript 还支持 for…of 、forEach、every 和 some 循环。

  for...of 语句创建一个循环来迭代可迭代的对象。在 ES6 中引入的 for...of 循环，以替代 for...in 和 forEach() ，并支持新的迭代协议。for...of 允许你遍历 Arrays（数组）, Strings（字符串）, Maps（映射）, Sets（集合）等可迭代的数据结构等。

+ ```
  let someArray = [1, "string", false];
   
  for (let entry of someArray) {
      console.log(entry); // 1, "string", false
  }
  ```

+ ```
  let list = [4, 5, 6];
  list.forEach((val, idx, array) => {
      // val: 当前值
      // idx：当前index
      // array: Array
  });
  ```

+ ```
  let list = [4, 5, 6];
  list.every((val, idx, array) => {
      // val: 当前值
      // idx：当前index
      // array: Array
      return true; // Continues
      // Return false will quit the iteration
  });
  ```

+ 在 TypeScript 函数里，如果我们定义了参数，则我们必须传入这些参数，除非将这些参数设置为可选，可选参数使用问号标识 ？

+ ```
  function buildName(firstName: string, lastName?: string) {
      if (lastName)
          return firstName + " " + lastName;
      else
          return firstName;
  }
   
  let result1 = buildName("Bob");  // 正确
  let result2 = buildName("Bob", "Adams", "Sr.");  // 错误，参数太多了
  let result3 = buildName("Bob", "Adams");  // 正确
  ```

+ 可选参数必须跟在必需参数后面。 如果上例我们想让 firstName 是可选的，lastName 必选，那么就要调整它们的位置，把 firstName 放在后面。

  如果都是可选参数就没关系。

+ 我们也可以设置参数的默认值，这样在调用函数的时候，如果不传入该参数的值，则使用默认参数，语法格式为：

+ ```
  function function_name(param1[:type],param2[:type] = default_value) { 
  }
  ```

+ ```
  function calculate_discount(price:number,rate:number = 0.50) { 
      var discount = price * rate; 
      console.log("计算结果: ",discount); 
  } 
  calculate_discount(1000) 
  calculate_discount(1000,0.30)
  ```

+ 有一种情况，我们不知道要向函数传入多少个参数，这时候我们就可以使用剩余参数来定义。

  剩余参数语法允许我们将一个不确定数量的参数作为一个数组传入。

+ ```
  function buildName(firstName: string, ...restOfName: string[]) {
      return firstName + " " + restOfName.join(" ");
  }
    
  let employeeName = buildName("Joseph", "Samuel", "Lucas", "MacKinzie");
  ```

### 匿名函数

+ ```
  var res = function(a:number,b:number) { 
      return a*b;  
  }; 
  console.log(res(12,2))
  ```

+ 匿名函数自调用

+ ```
  (function () { 
      var x = "Hello!!";   
      console.log(x)     
   })()
  ```

+ TypeScript 也支持使用 JavaScript 内置的构造函数 Function() 来定义函数：

+ ```
  var myFunction = new Function("a", "b", "return a * b"); 
  var x = myFunction(4, 3); 
  console.log(x);
  ```

+ 箭头函数

+ 单个参数是可选的

+ ```
  var display = x => { 
      console.log("输出为 "+x) 
  } 
  display(12)
  ```

### 函数的重载

### Number的属性

+ ```
  console.log("TypeScript Number 属性: "); 
  console.log("最大值为: " + Number.MAX_VALUE); 
  console.log("最小值为: " + Number.MIN_VALUE); 
  console.log("负无穷大: " + Number.NEGATIVE_INFINITY); 
  console.log("正无穷大:" + Number.POSITIVE_INFINITY);
  ```

+ 方法

+ toExponential()把对象的值转换为指数计数法

+ toFixed()把数字转换为字符串，并对小数点指定位数

+ toLocaleString()

  把数字转换为字符串，使用本地数字格式顺序。

+ toPrecision()

  把数字格式化为指定的长度

+ toString()

  把数字转换为字符串，使用指定的基数。数字的基数是 2 ~ 36 之间的整数。若省略该参数，则使用基数 10。

+ valueOf()返回一个 Number 对象的原始数字值

### ts字符串

+ 属性

  + constructor对创建该对象的函数的引用。

  + length

    返回字符串的长度。

  + prototype允许您向对象添加属性和方法。

  + ```
    function employee(id:number,name:string) { 
        this.id = id 
        this.name = name 
     } 
     var emp = new employee(123,"admin") 
     employee.prototype.email="admin@runoob.com" // 添加属性 email
     console.log("员工号: "+emp.id) 
     console.log("员工姓名: "+emp.name) 
     console.log("员工邮箱: "+emp.email)
    ```

+ 方法

  + charAt()

    返回在指定位置的字符。

  + charCodeAt()

    返回在指定的位置的字符的 Unicode 编码。

  + concat()

    连接两个或更多字符串，并返回新的字符串。

  + indexOf()返回某个指定的字符串值在字符串中首次出现的位置。

  + lastIndexOf()

    从后向前搜索字符串，并从起始位置（0）开始计算返回字符串最后出现的位置。

  + localeCompare()

    用本地特定的顺序来比较两个字符串

  + **match()**查找找到一个或多个正则表达式的匹配。

  + replace()

    替换与正则表达式匹配的子串

  + search()

    检索与正则表达式相匹配的值

  + slice()提取字符串的片断，并在新的字符串中返回被提取的部分

  + split()

    把字符串分割为子字符串数组。

  + substr()

    从起始索引号提取字符串中指定数目的字符。

  + substring()

    提取字符串中两个指定的索引号之间的字符。

  + toLocaleLowerCase()

    根据主机的语言环境把字符串转换为小写，只有几种语言（如土耳其语）具有地方特有的大小写映射。

  + toLocaleUpperCase()

    据主机的语言环境把字符串转换为大写，只有几种语言（如土耳其语）具有地方特有的大小写映射。

  + toLowerCase()

    把字符串转换为小写。

  + toString()

    返回字符串。

  + toUpperCase()

    把字符串转换为大写。

  + valueOf()

    返回指定字符串对象的原始值。

### ts数组

+ 数组结构

+ 数组循环

+ ```
  var j:any; 
  var nums:number[] = [1001,1002,1003,1004] 
   
  for(j in nums) { 
      console.log(nums[j]) 
  }
  ```

+ 方法

  + concat()

    连接两个或更多的数组，并返回结果。

  + every()

    检测数值元素的每个元素是否都符合条件。

  + filter()检测数值元素，并返回符合条件所有元素的数组。

  + forEach()

    数组每个元素都执行一次回调函数。

  + indexOf()搜索数组中的元素，并返回它所在的位置。如果搜索不到，返回值 -1，代表没有此项。

  + join()

    把数组的所有元素放入一个字符串。

  + lastIndexOf()返回一个指定的字符串值最后出现的位置，在一个字符串中的指定位置从后向前搜索

  + map()

    通过指定函数处理数组的每个元素，并返回处理后的数组。

  + pop()

    删除数组的最后一个元素并返回删除的元素。

  + push()

    向数组的末尾添加一个或更多元素，并返回新的长度。

  + reduce()

    将数组元素计算为一个值（从左到右）。

  + reduceRight()

    将数组元素计算为一个值（从右到左）。

  + reverse()

    反转数组的元素顺序。

  + shift()

    删除并返回数组的第一个元素

  + slice()

    选取数组的的一部分，并返回一个新数组。

  + some()

    检测数组元素中是否有元素符合指定条件。

  + sort()

    对数组的元素进行排序。

  + splice()从数组中添加或删除元素

  + toString()

    把数组转换为字符串，并返回结果。

  + unshift()

    向数组的开头添加一个或更多元素，并返回新的长度。

### Map对象

+ Map 相关的函数与属性：

  - map.clear() – 移除 Map 对象的所有键/值对 。
  - map.set() – 设置键值对，返回该 Map 对象。
  - map.get() – 返回键对应的值，如果不存在，则返回 undefined。
  - map.has() – 返回一个布尔值，用于判断 Map 中是否包含键对应的值。
  - map.delete() – 删除 Map 中的元素，删除成功返回 true，失败返回 false。
  - map.size – 返回 Map 对象键/值对的数量。
  - map.keys() - 返回一个 Iterator 对象， 包含了 Map 对象中每个元素的键 。
  - map.values() – 返回一个新的Iterator对象，包含了Map对象中每个元素的值 

+ ```
  let myMap = new Map();
  ```

+ ```
  let myMap = new Map([
          ["key1", "value1"],
          ["key2", "value2"]
      ]); 
  ```

+ Map 对象中的元素是按顺序插入的，我们可以迭代 Map 对象，每一次迭代返回 [key, value] 数组。

  TypeScript使用 for...of 来实现迭代：

+ ```
  let nameSiteMapping = new Map();
   
  nameSiteMapping.set("Google", 1);
  nameSiteMapping.set("Runoob", 2);
  nameSiteMapping.set("Taobao", 3);
   
  // 迭代 Map 中的 key
  for (let key of nameSiteMapping.keys()) {
      console.log(key);                  
  }
   
  // 迭代 Map 中的 value
  for (let value of nameSiteMapping.values()) {
      console.log(value);                 
  }
   
  // 迭代 Map 中的 key => value
  for (let entry of nameSiteMapping.entries()) {
      console.log(entry[0], entry[1]);   
  }
   
  // 使用对象解析
  for (let [key, value] of nameSiteMapping) {
      console.log(key, value)
  ```

### ts元组

+ 创建元组的语法格式如下

+ ```
  var tuple_name = [value1,value2,value3,…value n]
  ```

+ ```
  var mytuple = [10,"Runoob"];
  ```

+ ```
  var mytuple = []; 
  mytuple[0] = 120 
  mytuple[1] = 234
  ```

+ 我们可以使用以下两个函数向元组添加新元素或者删除元素：

  - push() 向元组添加元素，添加在最后面。
  - pop() 从元组中移除元素（最后一个），并返回移除的元素。
  - 元组是可变的，这意味着我们可以对元组进行更新操作：

### TS联合类型

+ 联合类型（Union Types）可以通过管道(|)将变量设置多种类型，赋值时可以根据设置的类型来赋值。

  **注意**：只能赋值指定的类型，如果赋值其它类型就会报错。

  创建联合类型的语法格式如下

+ ```
  Type1|Type2|Type3 
  ```

+ ```
  var val:string|number 
  val = 12 
  console.log("数字为 "+ val) 
  val = "Runoob" 
  console.log("字符串为 " + val)
  ```

+ 我们也可以将数组声明为联合类型

+ ```
  var arr:number[]|string[]; 
  var i:number; 
  arr = [1,2,4] 
  console.log("**数字数组**")  
   
  for(i = 0;i<arr.length;i++) { 
     console.log(arr[i]) 
  }  
   
  arr = ["Runoob","Google","Taobao"] 
  console.log("**字符串数组**")  
   
  for(i = 0;i<arr.length;i++) { 
     console.log(arr[i]) 
  ```

### TS接口

+ 接口是一系列抽象方法的声明，是一些方法特征的集合，这些方法都应该是抽象的，需要由具体的类去实现，然后第三方就可以通过这组抽象方法调用，让具体的类执行具体的方法。

  TypeScript 接口定义如下：

+ ```
  interface interface_name { 
  }
  ```

+ 以下实例中，我们定义了一个接口 IPerson，接着定义了一个变量 customer，它的类型是 IPerson。

  customer 实现了接口 IPerson 的属性和方法。

+ ```
  interface IPerson { 
      firstName:string, 
      lastName:string, 
      sayHi: ()=>string 
  } 
   
  var customer:IPerson = { 
      firstName:"Tom",
      lastName:"Hanks", 
      sayHi: ():string =>{return "Hi there"} 
  } 
   
  console.log("Customer 对象 ") 
  console.log(customer.firstName) 
  console.log(customer.lastName) 
  console.log(customer.sayHi())  
   
  var employee:IPerson = { 
      firstName:"Jim",
      lastName:"Blakes", 
      sayHi: ():string =>{return "Hello!!!"} 
  } 
   
  console.log("Employee  对象 ") 
  console.log(employee.firstName) 
  console.log(employee.lastName)
  ```

+ 接口就是具有什么东西，里面可以声明变量，抽象方法，和常量。

+ 有时候我们不一定要设置对象里的某个属性，接口里可以用 "?" 来表示一个属性是否是可选的。

+ ```
  interface Human {
      gender: string,
      age?: number
  }

  let jack: Human = {
      gender: 'Male'
      // 可以不赋值 age 属性，因为是可选的
  }
  ```

+ 除此之外，我们还可以控制接口里属性规定的写法，不懂？看代码

+ ```
  interface Rect {
      height: number;
      width: number;
      [propName: string]: number
  }
  ```

+ 因为函数也是对象，所以我们也可以通过接口来对函数做“规定”。

+ ```
  interface Fn {
      (a: number, b: number): number;
  }

  let add: Fn = function(a: number, b: number): number {
      return a + b
  }

  console.log(add(1, 2))
  ```

+ 这里定义了 Fn 接口，规定了参数的类型为 number，返回值的类型为 number。

+ 接口中我们可以将数组的索引值和元素设置为不同类型，索引值可以是数字或字符串。

+ ```
  interface namelist { 
     [index:number]:string 
  } 
   
  // 类型一致，正确
  var list2:namelist = ["Google","Runoob","Taobao"]
  // 错误元素 1 不是 string 类型
  // var list2:namelist = ["Runoob",1,"Taobao"]
  ```

### TS类

+ 定义类的关键字为 class，后面紧跟类名，类可以包含以下几个模块（类的数据成员）：

  - **字段** − 字段是类里面声明的变量。字段表示对象的有关数据。
  - **构造函数** − 类实例化时调用，可以为类的对象分配内存。
  - **方法** − 方法为对象要执行的操作

+ ```
  class Car { 
      // 字段 
      engine:string; 
   
      // 构造函数 
      constructor(engine:string) { 
          this.engine = engine 
      }  
   
      // 方法 
      disp():void { 
          console.log("发动机为 :   "+this.engine) 
      } 
  }
  ```

+ 我们使用 new 关键字来实例化类的对象，语法格式如下：

+ ```
  var object_name = new class_name([ arguments ])
  ```

+ TypeScript 支持继承类，即我们可以在创建类的时候继承一个已存在的类，这个已存在的类称为父类，继承它的类称为子类。

  类继承使用关键字 extends，子类除了不能继承父类的私有成员(方法和属性)和构造函数，其他的都可以继承。

  TypeScript 一次只能继承一个类，不支持继承多个类，但 TypeScript 支持多重继承（A 继承 B，B 继承 C）。

+ 类继承后，子类可以对父类的方法重新定义，这个过程称之为方法的重写。

  其中 super 关键字是对父类的直接引用，该关键字可以引用父类的属性和方法。

+ static 关键字用于定义类的数据成员（属性和方法）为静态的，静态成员可以直接通过类名调用。

+ TypeScript 中，可以使用访问控制符来保护对类、变量、方法和构造方法的访问。TypeScript 支持 3 种不同的访问权限。

  - **public（默认）** : 公有，可以在任何地方被访问。
  - **protected** : 受保护，可以被其自身以及其子类访问。
  - **private** : 私有，只能被其定义所在的类访问。

+ 类可以实现接口，使用关键字 implements，并将 interest 字段作为类的属性使用。

  以下实例红 AgriLoan 类实现了 ILoan 接口：

### TS对象

TypeScript 类型模板

假如我们在 JavaScript 定义了一个对象

+ ```
  var sites = { 
     site1:"Runoob", 
     site2:"Google" 
  };
  ```

+ 这时如果我们想在对象中添加方法，可以做以下修改：

+ ```
  sites.sayHello = function(){ return "hello";}
  ```

+ 如果在 TypeScript 中使用以上方式则会出现编译错误，因为Typescript 中的对象必须是特定类型的实例。

### 命名空间

+ 当应用变得越来越大时，我们需要将代码分离到不同的文件中以便于维护。

  多文件中的命名空间

  现在，我们把`Validation`命名空间分割成多个文件。 尽管是不同的文件，它们仍是同一个命名空间，并且在使用的时候就如同它们在一个文件中定义的一样。 因为不同文件之间存在依赖关系，所以我们加入了引用标签来告诉编译器文件之间的关联。 我们的测试代码保持不变。

  TypeScript 中命名空间使用 namespace 来定义，语法格式如下：

+ ```
  namespace SomeNameSpaceName { 
     export interface ISomeInterfaceName {      }  
     export class SomeClassName {      }  
  }
  ```

+ 以上定义了一个命名空间 SomeNameSpaceName，如果我们需要在外部可以调用 SomeNameSpaceName 中的类和接口，则需要在类和接口添加 export 关键字。

+ ```
  SomeNameSpaceName.SomeClassName;
  ```

+ 如果一个命名空间在一个单独的 TypeScript 文件中，则应使用三斜杠 /// 引用它，语法格式如下：

+ ```
  /// <reference path = "SomeFileName.ts" />
  ```

+ 以下实例演示了命名空间的使用，定义在不同文件中：

+ ```
  IShape.ts 文件代码：
  namespace Drawing { 
      export interface IShape { 
          draw(); 
      }
  }
  Circle.ts 文件代码：
  /// <reference path = "IShape.ts" /> 
  namespace Drawing { 
      export class Circle implements IShape { 
          public draw() { 
              console.log("Circle is drawn"); 
          }  
      }
  }
  Triangle.ts 文件代码：
  /// <reference path = "IShape.ts" /> 
  namespace Drawing { 
      export class Triangle implements IShape { 
          public draw() { 
              console.log("Triangle is drawn"); 
          } 
      } 
  }
  TestShape.ts 文件代码：
  /// <reference path = "IShape.ts" />   
  /// <reference path = "Circle.ts" /> 
  /// <reference path = "Triangle.ts" />  
  function drawAllShapes(shape:Drawing.IShape) { 
      shape.draw(); 
  } 
  drawAllShapes(new Drawing.Circle());
  drawAllShapes(new Drawing.Triangle());
  ```

+ 命名空间支持嵌套，即你可以将命名空间定义在另外一个命名空间里头。

+ 在ts1.5版本，命名空间又叫model，其实就是内部模块

### 声明文件

+ TypeScript 作为 JavaScript 的超集，在开发过程中不可避免要引用其他第三方的 JavaScript 的库。虽然通过直接引用可以调用库的类和方法，但是却无法使用TypeScript 诸如类型检查等特性功能。为了解决这个问题，需要将这些库里的函数和方法体去掉后只保留导出类型声明，而产生了一个描述 JavaScript 库和模块信息的声明文件。通过引用这个声明文件，就可以借用 TypeScript 的各种特性来使用库文件了。

  假如我们想使用第三方库，比如 jQuery，我们通常这样获取一个 id 是 foo 的元素：

+ ```
  $('#foo');
  // 或
  jQuery('#foo');
  ```

+ 但是在 TypeScript 中，我们并不知道 $ 或 jQuery 是什么东西：

+ 这时，我们需要使用 declare 关键字来定义它的类型，帮助 TypeScript 判断我们传入的参数类型对不对：

+ ```
  declare var jQuery: (selector: string) => any;

  jQuery('#foo');
  ```

+ 声明文件以 .d.ts 为后缀，例如：

+ ```
  runoob.d.ts
  ```

+ 声明文件或模块的语法格式如下：

+ ```
  declare module Module_Name {
  }
  ```

+ ​