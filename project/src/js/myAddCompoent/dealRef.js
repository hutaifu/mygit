import {isExpression} from "@/js/jsExpress";
export default function dealRef(obj,vue,ref){
    let keys = Object.keys(obj.attributes)
    let refValue = keys.filter(item => /^(:|v-bind:)*ref$/.test(item))[0];
    if (refValue) {
        if (vue[obj.attributes[refValue]]) {
            ref = vue[obj.attributes[refValue]];
        } else {
            let jsFn = isExpression.bind(vue)(obj.attributes[refValue])
            if (jsFn) {
                //如果是js表达式
                ref = jsFn();
            } else {
                ref = obj.attributes[refValue];
            }
        }

    }


}