# 虚拟DOM树
为了提高渲染效率，vue会把模板编译成为虚拟DOM树，然后再生成真实的DOM
模板：
```js    <div id="app">
        <!-- 界面模板 -->
        <!-- mustache语法 -->
        <h1>系统名称：{{titile}}</h1>
        <p>{{abc}}</p>
        <ul>
            <li v-for="(item,i) in products">
                <button @click="changeStock(item,item.stock-1)">-</button>
                名称：{{item.name}} <span v-if="item.stock>0">{{item.stock}}</span>
                <span v-else=>无货</span>
                <button @click="item.stock++">+</button>
                <button @click="remove(index)">删除</button></button>
            </li>
        </ul>
    </div>
```
虚拟DOM树：一个一个js对象形成树形结构
当数据更改时，将重新编译成虚拟DOM树，然后前后两颗树进行比对，仅将差异部分反映到真实的DOM,这样即可最小程度的改动真实DOM,提示页面效率
修改js对象效率高，修改真实dom效率低
vue._vnode ，虚拟节点，不是所有的虚拟节点都有对应真实节点，注意是节点，文本节点和注释节点也有对应的虚拟节点，
虚拟节点对事件的处理又有一套逻辑

diiff算法，对比前后虚拟dom树，修改局部的真实dom元素
每次vue对象渲染都是生成一个全新的节点对象

因此，对应vue而言，提升效率着重于两个方面：
+ 减少新的虚拟dom的生成
+ 保证对比之后，只有必要的节点有变化。
vue提供了多种方式生成虚拟DOM树：
1.在挂载的元素内部直接书写，此时将使用元素的outerHTML作为模板
2.在template配置中书写
```js
    <script>
        //vm:vue示例
        let vm = new Vue({//配置
            el:"#app", //css选择器
            templa:`        <!-- 界面模板 -->
        <!-- mustache语法 -->
        <h1>系统名称：{{titile}}</h1>
        <p>{{abc}}</p>
        <ul>
            <li v-for="(item,i) in products">
                <button @click="changeStock(item,item.stock-1)">-</button>
                名称：{{item.name}} <span v-if="item.stock>0">{{item.stock}}</span>
                <span v-else=>无货</span>
                <button @click="item.stock++">+</button>
                <button @click="remove(index)">删除</button></button>
            </li>
        </ul>`,
            data:{//和界面相关的数据
                titile:"库存管理系统",
                products:[{name:"iphone",stock:10},
            {name:"xioami",stock:5},
            {name:"huawei",stock:6}]},
            methods:{
                remove(i){
                    this.products.splice(i,1);
                },
                changeStock(product,newStock){
                    if(newStock < 0){
                        newStock = 0;
                    }
                    product.stock = newStock;
                }
            }
        })
    </script>
```



3.在render配置中用函数直接创建虚拟节点树，此时，完全脱离模板，将省略编译步骤，这些步骤从上到下，优先级逐渐提升(最优先使用render)。
注意:虚拟dom节点树必须是单根的（需要对比，两棵树无法对比）=》所以vue模板只能有一个根元素。 diff算法决定只能对比单根树
```js
    <script>
        //vm:vue示例
        let vm = new Vue({//配置
            el:"#app", //css选择器
            render(h){
                var titles = [];
                for(var i = 1;i<6;i++){
                    titles.push(h(`h${i}`,`${i}级标题`))
                }
                return h("div",[
                    h("h1",this.title),
                    h("p",,"skdjfls"),
                    titles,
                ]);
            },
            data:{//和界面相关的数据
                titile:"库存管理系统",
                products:[{name:"iphone",stock:10},
            {name:"xioami",stock:5},
            {name:"huawei",stock:6}]},
            methods:{
                remove(i){
                    this.products.splice(i,1);
                },
                changeStock(product,newStock){
                    if(newStock < 0){
                        newStock = 0;
                    }
                    product.stock = newStock;
                }
            }
        })
    </script>



```



挂载
将生成的真实DOM树，放置到某个元素（这个元素会被替换为模板的根元素，或者render函数生成的根元素）的位置，称之为挂载。
挂载的方式：
1.通过el:"css选择器"进行配置
2.通过vue实例，$mount("css选择器")进行配置，先不挂载，先生成vue实例，后挂载（方法组件开发）
