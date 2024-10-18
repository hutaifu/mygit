import jugeisStrign from "@/js/myAddCompoent/jugeisDoubleString";
import {isExpression} from "@/js/myAddCompoent/jsExpress";
// 获取prop属性并处理类型
export default function getProp(attr,vue,obj,watchProps,scope) {
    let keys = Object.keys(obj.attributes);
    let rel = /^(:|v-bind:)/;
    let afterKeys = keys.filter(item => rel.test(item) && !/(ref|class|key|style)$/.test(item));
    afterKeys.forEach(item => {
        let afterItem = item.replace(rel, "");
        let value = obj.attributes[item];
        //判断是否为字符串
        if (jugeisStrign(value)){
            //如果是双重字符串
            attr[afterItem] = value.replace(/['"`]/g, "")
        }else {
            //不是字符串
            // 处理布尔类型
            if (value === "false") {
                attr[afterItem] = false;
            } else if (value === "true") {
                attr[afterItem] = true;
            } else if (!isNaN(Number(value))) { // 检查是否为数字
                attr[afterItem] = Number(value); // 转换为数字
            } else {
                // 其他情况
                if (vue[value]) {
                    //如果是父组件的属性
                    attr[afterItem] = vue[value]; // 绑定属性
                    //记录到监听信息中
                    watchProps.push(value)
                } else {
                    //是否为表达式
                    let fn = isExpression.bind(vue)(value,scope);
                    if (fn){
                        attr[afterItem] = fn;
                    }
                }
            }


        }
    });
}