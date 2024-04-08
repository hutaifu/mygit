### 滚动条相关操作

window.scrollTo()`方法用于改变浏览器窗口或者包含指定元素的容器元素的滚动条的位置。

当我们在浏览器中滚动滚动条时，实际上是在改变浏览器窗口或者容器元素的滚动条位置。因此，当我们调用`window.scrollTo()`方法时，它会改变当前窗口或容器元素的滚动条位置，从而实现滚动的效果。

如果我们想要改变某个特定元素的滚动条位置，可以使用该元素的`scrollTop`和`scrollLeft`属性。例如，如果要将一个包含内容的`div`元素向下滚动100像素，可以使用以下代码：

```
const element = document.getElementById('my-element');
element.scrollTop += 100;

```

这样就可以将该`div`元素向下滚动100像素。如果想要向右滚动，可以使用`scrollLeft`属性来实现。



### 组件通信

Vue 中组件外的方法可以通过 props 或者事件的方式传递到组件内，然后在组件内部使用 $emit 触发事件或者调用 props 中的方法来实现在组件内部触发组件外部的方法。

以下是一个示例：

假设我们有一个父组件 MyParentComponent，其中有一个方法 parentMethod：

```
export default {
  methods: {
    parentMethod() {
      console.log('我是父组件的方法');
    }
  }
}

```

现在我们有一个子组件 MyChildComponent，需要在组件内部调用父组件的 parentMethod 方法，我们可以通过 props 或者事件的方式来实现：

1. 使用 props 传递方法

在父组件中定义一个方法，并且把它作为 props 传递给子组件：

```
<template>
  <div>
    <my-child-component :parent-method="parentMethod"></my-child-component>
  </div>
</template>

<script>
import MyChildComponent from './MyChildComponent.vue';

export default {
  components: {
    MyChildComponent
  },
  methods: {
    parentMethod() {
      console.log('我是父组件的方法');
    }
  }
}
</script>

```

在子组件中，我们可以通过 props 获取到父组件传递过来的方法，并在需要的时候调用它：

```
<template>
  <div>
    <button @click="handleClick">在子组件中调用父组件方法</button>
  </div>
</template>

<script>
export default {
  props: {
    parentMethod: {
      type: Function,
      required: true
    }
  },
  methods: {
    handleClick() {
      this.parentMethod();
    }
  }
}
</script>

```

1. 使用事件触发方法

在父组件中，我们可以使用 $emit 触发一个事件，并把需要执行的方法名作为事件名称：

```
<template>
  <div>
    <my-child-component @call-parent-method="parentMethod"></my-child-component>
  </div>
</template>

<script>
import MyChildComponent from './MyChildComponent.vue';

export default {
  components: {
    MyChildComponent
  },
  methods: {
    parentMethod() {
      console.log('我是父组件的方法');
    }
  }
}
</script>

```

在子组件中，我们可以在需要的时候使用 $emit 触发父组件的事件：

```
<template>
  <div>
    <button @click="handleClick">在子组件中调用父组件方法</button>
  </div>
</template>

<script>
export default {
  methods: {
    handleClick() {
      this.$emit('call-parent-method');
    }
  }
}
</script>

```

这样，当我们点击子组件中的按钮时，就会触发父组件中的 parentMethod 方法。



### 数组深度复制

在Vue中，可以使用多种方法进行数组深度复制，以下是其中的几种方法：

1. 使用JSON对象的parse和stringify方法

这是最简单的一种方法，可以将数组对象转换成JSON字符串后再转换回数组对象。例如：

```
let arr = [{name: 'apple'}, {name: 'banana'}, {name: 'orange'}];
let newArr = JSON.parse(JSON.stringify(arr));

```

这种方法的缺点是无法复制函数、RegExp等特殊对象。

1. 使用Array.from方法

可以使用ES6的Array.from方法进行数组复制。例如：

```
let arr = [{name: 'apple'}, {name: 'banana'}, {name: 'orange'}];
let newArr = Array.from(arr);

```

这种方法可以复制函数、RegExp等特殊对象，但无法复制对象的属性描述符。

1. 使用扩展运算符

可以使用ES6的扩展运算符（...）进行数组复制。例如：

```
let arr = [{name: 'apple'}, {name: 'banana'}, {name: 'orange'}];
let newArr = [...arr];

```

这种方法可以复制函数、RegExp等特殊对象，但无法复制对象的属性描述符。

1. 使用递归

可以使用递归函数遍历数组进行复制。例如：

```
function deepCopy(obj) {
  if (Array.isArray(obj)) {
    return obj.map(deepCopy);
  } else if (typeof obj === 'object' && obj !== null) {
    let newObj = {};
    for (let key in obj) {
      newObj[key] = deepCopy(obj[key]);
    }
    return newObj;
  } else {
    return obj;
  }
}

let arr = [{name: 'apple'}, {name: 'banana'}, {name: 'orange'}];
let newArr = deepCopy(arr);

```

这种方法可以复制所有类型的对象，但比较耗时。

综上所述，以上是几种常见的数组深度复制方法，开发者可以根据实际情况选择合适的方法;



### 事件修饰符

在 Vue 中，修饰符是用于修饰绑定在元素上的指令或事件的特殊标记，可以改变它们的行为或增加额外的功能。下面是一些常用的修饰符及其作用：

1. `.prevent` 修饰符：阻止默认事件。例如：`<a v-on:click.prevent="doSomething">`。
2. `.stop` 修饰符：阻止事件冒泡。例如：`<div v-on:click.stop="doSomething">`。
3. `.capture` 修饰符：使用事件捕获模式。例如：`<div v-on:click.capture="doSomething">`。
4. `.self` 修饰符：只在元素自身触发事件时触发处理函数。例如：`<div v-on:click.self="doSomething">`。
5. `.once` 修饰符：只触发一次事件。例如：`<button v-on:click.once="doSomething">`。
6. `.passive` 修饰符：告知浏览器不需要在滚动时执行 preventDefault()。用于提高移动端的性能。例如：`<div v-on:touchmove.passive="doSomething">`。
7. `.native` 修饰符：监听组件根元素上的原生事件。例如：`<my-component v-on:click.native="doSomething">`。
8. `.sync` 修饰符：用于实现子组件双向绑定。例如：`<child-component :foo.sync="bar">`。

这些修饰符都可以组合使用，例如：`<a v-on:click.stop.prevent="doSomething">` 表示阻止默认事件并阻止事件冒泡



###  组件内部节点追加复制以及事件的复制

+ 关于vue组件的选中以及节点的复制和追加

  + 使用this.$refs选中的为一个vue组件，可以调用相关的方法和参数

  + vue组件.$el得到当前组件dom元素，

  + this.$el得到当前页面所有根节点dom元素

  + document也可以选中得到dom元素

  + dom元素拥有appendChidren()方法，向里面追加子元素

  + 同时dom元素也有cloneNode()方法复制当前元素

    ```js
      setbuttom(){
        let buttom3 = this.$refs.jxd_265Ref;
       let buttom4 = this.$el.querySelector('.jxd_265')
          let buttom = this.$refs.jxd_264Ref;
          let buttom1 = this.$el.querySelector('.el-tabs__nav-scroll');
         let buttom2 = document.getElementsByClassName('el-tabs__nav-scroll');
         let a = document.createElement('div');
        a.textContent = 'my Chidren';
         let a = buttom3.$el.cloneNode(true);
        buttom3.$el.style.display = 'none'
          buttom1.appendChild(a);
         element.appendChild(buttom)
      },
    ```



+ 关于组件追加的补充

  + dom元素的cloneNode()方法只复制元素的样式，内容，但是元素所带的事件没有复制过来

  + 如果要把自带的事件复制过来，看示例

  + ```
    let oldButton = this.$refs.jxd_265Ref;
    let newButton = oldButton.$el.cloneNode(true);
    oldButton.$el.style.display = 'none';
    this.$el.querySelector('.el-tabs__nav-scroll').appendChild(newButton);

    // 遍历组件上所有绑定的事件类型
    Object.keys(oldButton.$listeners).forEach(eventName => {
      // 在新按钮上添加事件处理程序
      newButton.addEventListener(eventName, () => {
        oldButton.$emit(eventName);
      });
    });
    ```

chatgpt:  另一种不依赖于`__events`属性的方法是，使用Vue的内置事件监听器函数`$listeners`来获取组件上绑定的所有事件处理程序。在新创建的按钮上使用`$emit`方法触发旧按钮上对应的事件，从而复制其事件处理程序。

具体代码实现如下：

```
复制代码setbuttom() {
  let oldButton = this.$refs.jxd_265Ref;
  let newButton = oldButton.$el.cloneNode(true);
  oldButton.$el.style.display = 'none';
  this.$el.querySelector('.el-tabs__nav-scroll').appendChild(newButton);

  // 遍历组件上所有绑定的事件类型
  Object.keys(oldButton.$listeners).forEach(eventName => {
    // 在新按钮上添加事件处理程序
    newButton.addEventListener(eventName, () => {
      oldButton.$emit(eventName);
    });
  });
}

```

在该实现中，首先克隆旧按钮并隐藏它，然后遍历组件上所有已绑定的事件类型，并在新创建的按钮上为每个事件类型添加一个事件处理程序。在这个事件处理程序中，使用`$emit`方法触发旧按钮上对应的事件，从而复制该事件的所有处理程序。

需要注意的是，如果组件上同时绑定了多个相同类型的事件处理程序，可能会出现无法正确复制所有事件处理程序的情况。因此，在使用该方法时需要仔细检查组件上所有已绑定的事件类型。



### 可编辑下拉框插槽页面滚动处理（建议滚动收起下拉框）

可编辑表格使用下拉框插槽，:popper-append-to-body="true"，下拉框展开在body上面，增加滚动条监听事件

```js
addScroll(){
    const element = document.querySelector('.jxd_2');
    element.addEventListener('scroll', function(e) {
        debugger;
        // Handle scroll event here
        const scrollTop = e.target.scrollTop
        const scrollLeft = e.target.scrollLeft
        const myrr = document.getElementsByClassName("el-select-dropdown");
        let my = myrr[2]
        my.style.top = 445 - scrollTop + "px"
    })
},
```





自定义滚动条监听事件

 使用v-scroll绑定事件，该元素滚动滚动时触发改函数

```js
    directives: {
        scroll: {
            inserted: function (el, binding) {
                const fn = binding.value
                el.addEventListener('scroll', fn)
            },
            unbind: function (el, binding) {
                const fn = binding.value
                el.removeEventListener('scroll', fn)
            }
        }
    },
```

这段代码是一个自定义指令，名称为 "scroll"。它有两个钩子函数：

1. "inserted" - 当绑定的元素插入到DOM中时执行。在这个函数中，通过获取指令绑定的值（binding.value）来获取函数参数，并将该函数添加为元素的滚动事件监听器。
2. "unbind" - 当指令与元素解除绑定时执行。在这个函数中，通过获取指令绑定的值（binding.value）来获取函数参数，并将该函数从元素的滚动事件监听器中移除。

因此，当使用这个自定义指令时，可以将一个函数作为指令的值传递给它，该函数将在元素滚动时被调用。

### 组件使用key = new Date()处理

要创建一个新的 Promise 对象，可以使用 Promise 构造函数。Promise 构造函数接受一个回调函数作为参数，这个回调函数又接受两个参数：resolve 和 reject 函数。

resolve 函数用于将 Promise 对象标记为已完成（fulfilled），并返回一个可选的结果值。reject 函数则用于将 Promise 对象标记为已失败（rejected），并返回一个错误对象或错误消息。

以下是创建 Promise 对象的示例代码：

```
复制代码const promise = new Promise((resolve, reject) => {
  // ... 在这里编写异步操作的逻辑 ...
  if (/* 异步操作成功 */) {
    resolve(/* 可选的成功结果值 */);
  } else {
    reject(/* 错误对象或错误消息 */);
  }
});

```

在 Promise 构造函数中编写的异步操作逻辑需要返回一个 Promise 实例，以便在后续可以使用 Promise 的方法链式调用。



这个报错通常出现在使用 Vue.js 的 v-for 指令渲染列表时，使用了非原始值（比如对象或数组）作为 key。这可能会导致性能问题和不稳定的行为，因为 Vue 在进行虚拟 DOM 渲染时需要跟踪每个元素的身份，而如果使用非原始值作为 key，Vue 就无法准确地判断两个元素是否相同，从而可能出现错误行为。

使用字符串或数字作为 key 是一个更好的做法，确保它们是唯一的且不变的。可以使用项目的 ID 作为 key，而不是整个项目对象。使用 new Date() 作为 key 可能会导致每次重新渲染组件时都生成新的 key，这样可能会影响性能，并且可能会导致不必要的重新渲染。因此，不建议使用 new Date() 作为 key。

### 合并数组

```
export default {
  data() {
    return {
      array1: [1, 2, 3],
      array2: [4, 5, 6]
    };
  },
  computed: {
    mergedArray() {
      return [...this.array1, ...this.array2];
    }
  }
}
```

```
Array.from(this.array1).concat(this.array2);
```

### map方法

```
const newArr = arr.map((elem, index) => {
  return `Element ${index} is ${elem}`;
});
```

### 判断数组

Array.isArray()；

### 对于组件样式相关理解

在Vue中，组件是可以设置class和style的。这是因为组件在渲染时会被转换成HTML元素，而HTML元素可以设置class和style属性来控制它的样式。所以无论是内置的组件还是自定义的组件，都可以通过设置class和style来改变其样式。不过需要注意的是，如果你自定义的组件具有子组件，则你需要在父组件的样式中使用深度选择器（deep selector）或者scoped CSS来控制子组件的样式。



是的，你说的很对。在Vue中，组件可以通过设置class和style属性来控制其样式。由于组件在渲染时会被转换成HTML元素，所以无论是内置的组件还是自定义的组件，都可以使用这些属性来改变它们的样式。

然而，如果一个自定义组件包含子组件，那么直接在父组件的样式中设置class和style可能只会影响到组件的根元素，并不能影响子组件的样式。这是因为Vue默认会使用scoped CSS来隔离每个组件的样式作用域，防止它们相互干扰。所以如果你要控制子组件的样式，需要使用深度选择器或者scoped CSS。

深度选择器使用>>>或者/deep/来表示。例如，如果你有一个名为"my-component"的组件，且其中包含一个名为"child-component"的子组件，那么你可以使用以下方式来控制子组件的样式：

```
复制代码<template>
  <div class="my-component">
    <child-component></child-component>
  </div>
</template>

<style scoped>
.my-component >>> .child-component {
  /* 这里是作用于子组件的样式 */
}
</style>

```

注意，使用深度选择器可能会导致样式的耦合性增加，应当谨慎使用。如果你希望更好地控制样式的作用范围，可以考虑使用scoped CSS。scoped CSS会自动将样式限制在当前组件的作用域内，不需要使用深度选择器。

```
复制代码<template>
  <div class="my-component">
    <child-component></child-component>
  </div>
</template>

<style scoped>
.child-component {
  /* 这里是作用于子组件的样式 */
}
</style>

```

这样就能够控制子组件的样式了。总之，在Vue中，组件可以设置class和style属性来控制其样式，但是需要注意scoped CSS对样式作用域的限制，以及使用深度选择器来控制子组件的样式时可能带来的副作用。



在Vue中，一个组件必须有且仅有一个根元素。这是因为Vue在渲染组件时，会将组件模板编译成一个渲染函数，并将其挂载到组件的根实例上进行渲染。如果组件包含多个根元素，那么在编译渲染函数时就无法确定要渲染哪一个元素。因此，为了确保组件能够被正确地渲染，每个组件都必须只有一个根元素。如果需要在组件内部渲染多个元素，可以使用一个外层容器来包裹它们，然后将该容器作为组件的根元素。例如：`<template>  <div class="my-component">    <h1>标题</h1>    <p>段落</p>  </div></template><style>.my-component {  /* 样式 */}</style>`在这个例子中，`<div>` 元素是 `my-component` 组件的根元素，它包含了一个 `<h1>` 元素和一个 `<p>` 元素。组件的样式可以通过 `.my-component` 类名来设置。



### 关于promise的简单理解

+ 我们还可以在Vue中使用Promise来处理其他异步操作，例如在计时器中使用Promise来实现延迟执行：

```
复制代码export default {
  data() {
    return {
      message: 'Hello, world!'
    }
  },
  mounted() {
    const delay = 1000 // 毫秒数
    new Promise(resolve => setTimeout(resolve, delay))
      .then(() => {
        this.message = 'Delayed Hello, world!'
      })
  }
}

```

在上面的代码中，我们使用Promise来实现一个延迟1秒钟后修改Vue组件的data属性中的message变量的值。我们首先创建一个Promise对象，在其中使用setTimeout函数模拟一个1秒钟的延迟，然后在Promise的then()方法中修改message变量的值。

总之，Promise是Vue中非常常见且强大的异步编程工具，可以帮助我们更加简单高效地处理异步操作。

+ 在这个例子中，Promise的构造函数接受一个函数作为参数，该函数会被立即执行。这个函数有一个参数resolve，它是一个函数，用于将Promise对象从Pending状态转换为Fulfilled状态。在这个例子中，我们使用setTimeout来模拟一个1秒钟的延迟，并且将resolve函数传递给setTimeout函数，以便当延迟结束时调用它。一旦resolve函数被调用，Promise对象就会完成，并且通过.then()方法注册的回调函数会被执行。在这个例子中，我们将新值赋给Vue组件的data属性中的message变量。如果Promise被拒绝（Rejected），则通过.catch()方法注册的回调函数会被执行。
+ 在Vue中，Promise的resolve函数和reject函数都可以接受参数。

当Promise被resolved时，resolve函数的第一个参数会作为成功回调函数的参数值，在then方法中可以捕获到。例如：

```
复制代码new Promise((resolve, reject) => {
  resolve('Success!')
}).then(value => {
  console.log(value); // 输出 'Success!'
});

```

当Promise被rejected时，reject函数的第一个参数会作为失败回调函数的参数值，在catch方法中可以捕获到。例如：

```
复制代码new Promise((resolve, reject) => {
  reject(new Error('Failed!'))
}).catch(error => {
  console.error(error); // 输出 'Error: Failed!'
});

```

需要注意的是，resolve和reject函数只能接受单个参数。如果需要传递多个参数，可以使用数组或对象的方式进行包装传递。

### 关于vue中的this指向问题

1.箭头函数里面默认没有this，this不会改变

2.类似js的原生写法中this就会改变，funtion(){

}里面的this就会改变

### 关于复制问题

var arr = Array.from(this.jxd_57Data);

这行代码将会创建一个新的数组 `arr`，其中包含与 `this.jxd_57Data` 相同的元素。这是一种浅复制，因为仅复制了数组中元素的引用。

如果您对 `arr` 进行更改，则 `this.jxd_57Data` 不会受到影响，因为它们是两个不同的数组。

但是，如果 `this.jxd_57Data` 中的任何元素本身是对象或数组，则这些对象或数组的引用也将被复制。因此，更改 `arr` 中的这些元素将反映在 `this.jxd_57Data` 中的相应元素中，因为它们引用相同的对象或数组。这些更改被称为浅层次的，因为只有对嵌套的对象和数组的引用进行了复制。

如果要进行深拷贝，请考虑使用递归或第三方库（例如 lodash 的 `cloneDeep` 方法），以确保所有嵌套的对象和数组也被完全复制。

`cloneDeep()` 是 lodash 库中的一个方法，可以用来进行深层次的复制。要使用 `cloneDeep()` 方法，首先需要安装 lodash 库，可以使用 npm 命令行工具来进行安装：`npm install lodash`。

然后，在代码中导入该库和方法：

```
javascript复制代码import _ from 'lodash';

const originalObject = { 
  a: 1, 
  b: { 
    c: 2, 
    d: [3, 4] 
  } 
};

const clonedObject = _.cloneDeep(originalObject);

```

在上面的示例中，`_.cloneDeep()` 方法被调用并传递了 `originalObject` 对象作为参数。这将返回 `clonedObject` 的完全独立副本，其中包含与 `originalObject` 相同的值。

注意，`cloneDeep()` 可以处理包含对象和数组的任何数据结构，并且会递归地进行复制。如果您需要对数组进行深度复制，则可以使用 `_.cloneDeep()` 或刚才提到的 `deepCopyArray()` 函数。

### js文件自调用相关

在 Vue 中，如果在一个 js 文件中调用了本文件中的方法，在打包后测试可能会出现错误。这通常是因为在打包后，webpack 将多个 js 文件合并成一个文件，导致变量和函数名重复。考虑再写一个js,相互调用。

### js接受参数

如果一个 JavaScript 方法接受一个对象作为参数，并且在方法内部修改该对象的属性，则外部对象也会随之改变，因为传递给该方法的是引用，而不是值的副本。

这意味着，在方法内对对象做的任何更改都会反映在原始对象上

如果方法接受的是对象的一个属性而不是整个对象，则在方法内部修改该属性的值不会影响原始对象。这是因为在 JavaScript 中，函数参数传递的是值的副本，而不是引用类型。因此，如果您在方法内部更改了传递的属性值，则只会更改该属性所对应的副本，而不会更改原始对象的属性。例如：

### 循环的异步操作

+ 在forEach的循环里面进行异步操作的时候，并不一定是在最后一次循环里面所有异步操作都被完成。


### 动态样式的添加

:class="{ 'snake': isSnakeCell(row, col), 'food': isFoodCell(row, col) }" 

这个样式是用来动态绑定元素的class属性的。在这个例子中，我们使用了Vue的:class指令来根据条件来动态设置元素的class。

:class指令接受一个对象作为参数，对象的键是class名称，值是一个布尔表达式，如果为true，则添加该class，如果为false，则不添加该class。

在这个例子中，我们根据isSnakeCell(row, col)和isFoodCell(row, col)的返回值来决定是否添加'snake'和'food'这两个class。如果isSnakeCell(row, col)返回true，则添加'snake'这个class；如果isFoodCell(row, col)返回true，则添加'food'这个class。

这样，根据蛇和食物的位置，我们可以动态地为相应的格子添加不同的class，从而改变它们的样式。

:class后面能接对象，也能接字符串。