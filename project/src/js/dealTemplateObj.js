export default function dealTemplateObj(obj,scopedSlots) {
    //插槽
    //是否有v-slot属性
    let sltoKey = Object.keys(obj.attributes).filter(item => /^(v-slot:)|#/.test(item))[0];
    let afterSltoKey = sltoKey?.replace(/^(v-slot:)|#/, "");
    if (afterSltoKey && afterSltoKey !== 'default') {
        //是否有参数
        if (obj.attributes[sltoKey]) {
            //作用域插槽
            scopedSlots[afterSltoKey] = afterSltoKey;
            obj.slotKey = sltoKey;
            obj._vnodeConfig = [obj.tagName, {}]
        } else {
            //非传参插槽
            obj._vnodeConfig = [obj.tagName, {slot: obj.attributes[sltoKey]}]
        }
    } else {
        //默认插槽
        obj._vnodeConfig = [obj.tagName, {slot: 'default'}]
    }
}