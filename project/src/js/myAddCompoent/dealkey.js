import {isExpression} from "@/js/myAddCompoent/jsExpress";
export default function dealKey(vue,obj,watchProps,scope) {
    let keys = Object.keys(obj.attributes);
    let keyValue = keys.filter(item => /^(:|v-bind:)*key$/.test(item))[0];
    if (keyValue) {
        if (vue[obj.attributes[keyValue]]) {
            //记录监听信息
            watchProps.push(obj.attributes[keyValue])
            return  vue[obj.attributes[keyValue]];
        } else {
            let jsFn = isExpression.bind(vue)(obj.attributes[keyValue],scope)
            if (jsFn) {
                //如果是js表达式
                return  jsFn;
            } else {
                return  obj.attributes[keyValue]
            }
        }
    }
}