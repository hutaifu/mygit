//商品列表组件
let template =   `<ul>
<li :key="item.id" v-for="(item,i) in products">
    <button @click="changeStock(item,item.stock-1)">-</button>
    名称：{{item.name}} <span v-if="item.stock>0">{{item.stock}}</span>
    <span v-else>无货</span>
    <button @click="item.stock++">+</button>
    <button @click="remove(index)">删除</button>
</li>
</ul>`;
export default{
    template,
    data(){
        return{
            products:[{id:1,name:"ipone",stock:10},
            {id:2,name:"xiaomi",stock:10},
            {id:3,name:"hauwei",stock:10}]
        }
    },
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
}