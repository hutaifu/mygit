
export default function dealVFor(obj,parentVue,callback){
            //v-for,的处理
            //接受一个抽象语法树节点对象，obj，attributes 属性，tagName 标签名称，
            if (obj.attributes && obj.attributes['v-for']){
              let [itemString,indexString,arrString] = getKeyString(obj.attributes['v-for']);
                //得到循环的集合
                let arr = parentVue[arrString];
              if (typeof arr === "object"){
                  //进行循环
                  for(let item in arr){
                      //得到顺序
                      let index;
                      if (Array.isArray(arr)){
                          index = arr.indexOf(item);
                      }
                      let obj = {[itemString]:item}
                      if (indexString){
                          obj[indexString] = index;
                      }
                      if (callback && typeof callback === "function"){
                          callback(obj);
                      }
                  }
              }
            }else {
                if (callback && typeof callback === "function"){
                    callback()
                }
            }
}