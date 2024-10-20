
export default function dealKey(keys,vue,obj,key) {
    let keyValue = keys.filter(item => /^(:|v-bind:)*key$/.test(item))[0];
    if (keyValue) {
        if (vue[obj.attributes[keyValue]]) {
            let key = obj.attributes[keyValue];

            (function () {
                handleReactive(key, () => {
                    myComp['key'] = vue[key]
                }, collector)
            })();

            key = vue[obj.attributes[keyValue]];
        } else {
            let jsFn = isExpression.bind(vue)(obj.attributes[keyValue], collector)
            if (jsFn) {
                //如果是js表达式
                key = jsFn;
            } else {
                key = obj.attributes[keyValue]
            }
        }
    }
}