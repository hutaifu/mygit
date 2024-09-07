
export default function dealDomProps(obj,attrs,domProps){
    let keys = Object.keys(obj.attributes);
    //处理原生属性
    let domPropsString = ['checked', 'value', 'innerHTML']//dom属性数组，
    let vuePropsString = ['ref',"key"] //vue专有属性，排除掉
    keys.filter(item => !/^(@|:|v-)/.test(item) && !vuePropsString.includes(item) ).forEach(item => {
        if (!domPropsString.includes(item)) {
            //如果不是dom属性，就是html属性
            attrs[item] = obj.attributes[item]
        } else {
            domProps[item] = obj.attributes[item]
        }
    })

}