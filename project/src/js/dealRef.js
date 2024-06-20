
export default function dealRef(keys,obj,vue,ref){
    let refValue = keys.filter(item => /^(:|v-bind:)*ref$/.test(item))[0];
    if (refValue) {
        if (vue[obj.attributes[refValue]]) {
            //实现响应式
            let key = obj.attributes[refValue];

            (function () {
                handleReactive(key, () => {
                    //更新数据
                    myComp["ref"] = vue[key]
                }, collector)
            })()
            ref = vue[obj.attributes[refValue]];
        } else {
            let jsFn = isExpression.bind(vue)(obj.attributes[refValue], collector)
            if (jsFn) {
                //如果是js表达式
                ref = jsFn;
            } else {
                ref = obj.attributes[refValue];
            }
        }

    }


}