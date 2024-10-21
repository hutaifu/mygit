
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



function getKeyString(String){
    let vForString = String;
    let wrods = vForString.split(' ');
    let itemString = '';
    let indexString = '';
    let arrString = '';

    //得到数组字符串
    arrString = wrods[wrods.length - 1];

    //如果分割后长度为四
    if (wrods.length === 4){
        itemString = wrods[0].replace(/[(\),]/g,"");
        indexString = wrods[1].replace(/[(\)]/g,"");
    }else {
        //长度为三
        //如果第一项包含逗号
        if (wrods[0].includes(",")){
            itemString = wrods[0].split(",")[0].replace(/[(\)]/g,"");
            indexString = wrods[0].split(",")[1].replace(/[(\)]/g,"");
        } else {
            //不包含逗号
            itemString = wrods[0].replace(/[(\)]/g,"")
        }
    }
    return [itemString,indexString,arrString]
}




