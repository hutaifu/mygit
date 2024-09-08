
function dealVFor(obj){
    //v-for,的处理
    //接受一个抽象语法树节点对象，obj，attributes 属性，tagName 标签名称，children,子节点
            if (obj.attributes['v-for']){
                //如果存在v-for顺序，
                let vForString = obj.attributes['v-for'];
                let wrods = vForString.split(' ');
                let itemString = '';
                let indexString = '';
                let arrString = '';
                if (wrods[0].includes(",")){
                    wrods[0] = wrods[0].replace(/[(\)]/,"");
                    itemString = wrods[0].split(",")[0];
                    indexString = wrods[0].split(',')[1];
                } else {
                    itemString = wrods[0].replace(/[(\)]/,"");
                }
                arrString = wrods[2];
                console.log(itemString,indexString,arrString)

            }
}

module.exports ={dealVFor}

    dealVFor({attributes:{'v-for':"(item,index) in items"}})