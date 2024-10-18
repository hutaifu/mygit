
export default function dealVFor(obj,parentVue){
            //v-for,的处理
            //接受一个抽象语法树节点对象，obj，attributes 属性，tagName 标签名称，
            if (obj.attributes && obj.attributes['v-for']){
              let [itemString,indexString,arrString] = getKeyString(obj.attributes['v-for']);
                //得到循环的集合
                let arr = parentVue[arrString];
              if (typeof arr === "object"){
                  //返回信息
                  return {
                      itemString,
                      indexString,
                      arr,
                  }
              }
            }else {
                return null;
            }
}