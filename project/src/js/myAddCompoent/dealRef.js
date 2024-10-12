import {isExpression} from "@/js/myAddCompoent/jsExpress";
export default function dealRef(obj,vue,watchProps){
    let keys = Object.keys(obj.attributes)
    let refValue = keys.filter(item => /^(:|v-bind:)*ref$/.test(item))[0];
    if (refValue) {
        if (vue[obj.attributes[refValue]]) {
            //记录监听信息
            watchProps.push(obj.attributes[refValue])
            return  vue[obj.attributes[refValue]];
        } else {
            let jsFn = isExpression.bind(vue)(obj.attributes[refValue])
            if (jsFn) {
                //如果是js表达式
                return jsFn();
            } else {
                return obj.attributes[refValue];
            }
        }

    }


}