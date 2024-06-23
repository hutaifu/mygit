import {isExpression} from "@/js/jsExpress";
export default function dealKey(vue,obj,key) {
    let keys = Object.keys(obj.attributes);
    let keyValue = keys.filter(item => /^(:|v-bind:)*key$/.test(item))[0];
    if (keyValue) {
        if (vue[obj.attributes[keyValue]]) {
            key = vue[obj.attributes[keyValue]];
        } else {
            let jsFn = isExpression.bind(vue)(obj.attributes[keyValue])
            if (jsFn) {
                //如果是js表达式
                key = jsFn();
            } else {
                key = obj.attributes[keyValue]
            }
        }
    }
}