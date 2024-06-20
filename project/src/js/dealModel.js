//处理v-model属性
function dealvModel(keys,obj,vue,valueKey,on,props) {
    keys.filter(item => /^v-model$/.test(item)).forEach(item => {
        //存在v-model属性，
        let value = obj.attributes[item];
        if (jugeisStrign(value)) {
            //如果是字符串,不做处理
            // domProps.value = value;
        } else {
            //如果不是字符串
            if (vue[value]) {
                // props.value = this.value
                //实现响应式
                let key = value;
                (function () {
                    handleReactive(key, () => {
                        //更新数据
                        myComp.value = vue[key]
                    }, collector)
                })()
                valueKey.push(value);
            }
            //双向绑定
            on.input = inputvalue => {
                vue[value] = inputvalue;
            }
        }
    })
}