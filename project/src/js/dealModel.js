//处理v-model属性
export default function dealvModel(obj,vue,model) {
    let keys = Object.keys(obj.attributes);
    keys.filter(item => /^v-model$/.test(item)).forEach(item => {
        //存在v-model属性，
        let value = obj.attributes[item];
        if (jugeisStrign(value)) {
           model.value = value;
        } else {
            //如果不是字符串
            if (vue[value]) {
                model.value = vue.value
            }
            //双向绑定
            model.callback = function ($$v) {
                vue[value] = $$v
            }
            model.expression = value;
        }
    })
}